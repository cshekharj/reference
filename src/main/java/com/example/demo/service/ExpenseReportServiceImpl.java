package com.example.demo.service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.constants.CreditFormatConstants;
import com.example.demo.constants.LiabilityTypes;
import com.example.demo.model.ExpenseReport;
import com.example.demo.model.Tradelines;
import com.example.demo.service.interfaces.ExpenseReportService;

@Named
public class ExpenseReportServiceImpl implements ExpenseReportService{
	
	private static final Logger logger = LoggerFactory.getLogger(ExpenseReportServiceImpl.class);
	private ExpenseReport expReport = new ExpenseReport();
	
	@Override
	public ExpenseReport getExpeneReport(String creditReport) throws Exception {
		if(creditReport == null)
			throw new Exception("Invalid credit report");
		long starttime = System.currentTimeMillis();
		logger.info("CreditReport :-"+creditReport);
		
		long housingExpenses=0;
		long nonHousingExpenses=0;
		
		Scanner scanner =  new Scanner(creditReport);
		InputStream stream = new ByteArrayInputStream(creditReport.getBytes());
		BufferedReader reader= new BufferedReader(new InputStreamReader(stream));
		String line="";
		ArrayList<Tradelines> tradelines = new ArrayList<Tradelines>();
		//while(scanner.hasNext()){
		do{
			
			//line=scanner.nextLine();
			line=reader.readLine();
			logger.info(line);
			
			 String tokens[] = line.split(" ");
			//skip invalid line
			if(tokens.length != CreditFormatConstants.VALID_TRADELINE_TOKENS)
				continue;
			
			Tradelines tline = new Tradelines();
			for(int i=0;i<tokens.length;i++){
				String token =tokens[i];
				logger.debug("token :-"+token);
				 
				// for each line parse appropriate tradeline properties
				switch(i){
					case CreditFormatConstants.REPORTED_DATE:
						tline.setReported_Date(token);
					case CreditFormatConstants.CODE:
						tline.setCode(token);
					case CreditFormatConstants.SUB_CODE:
						tline.setSubcode(token);
					case CreditFormatConstants.MONTTHLY_PAYMENT:
						tline.setMonthly_payment(Long.parseLong(token.replaceAll("[^0-9]", "")));
						
					case CreditFormatConstants.CURRENT_BALANCE:
						tline.setCurrent_balance(Long.parseLong(token.replaceAll("[^0-9]", "")));
				}	
			}
			tline.setType(getCreditType(tline.getCode(),tline.getSubcode()));
			
			//calculate expenses
			// code =10 and sub code = 12 or 15
			if(Integer.parseInt(tline.getCode()) == CreditFormatConstants.CON_MORTG_CODE 
				&& (Integer.parseInt(tline.getSubcode()) == CreditFormatConstants.CON_MORTG_SUB_CODE)
					|| (Integer.parseInt(tline.getCode()) == CreditFormatConstants.MORTG_SUB_CODE)){
				housingExpenses+=tline.getMonthly_payment();
			}
			
			//code NOT 10 and code NOT 5
			if(Integer.parseInt(tline.getCode()) != CreditFormatConstants.CON_MORTG_CODE 
					&& Integer.parseInt(tline.getSubcode()) != CreditFormatConstants.STUDENT_LOAN_CODE){
				nonHousingExpenses+=tline.getMonthly_payment();
			}
			tradelines.add(tline);
			
		}while(reader.readLine() != null);
		scanner.close();
		
		if(housingExpenses==0)
			housingExpenses=1061*CreditFormatConstants.CENTS_IN_DOLLAR;
		// populate expense report
		expReport.setFixed_expenses_before_education(housingExpenses+nonHousingExpenses);
		expReport.setTradelines(tradelines);
		
		logger.info("Time taken in milliseconds -"+ (System.currentTimeMillis()-starttime));
		return expReport;
	}
	
	/*
	 *  from Biz req
	 *  1 - All credit cards have a code of '12'.
	 *  2 - A conventional mortgage has a code of '10' and a subcode of '12'.
	 *  3 - A mortgage tradeline has a code of 10 and a subcode of 12 or 15.
	 *  4 - A student loan tradeline has a code of 5.
	 */
	private String getCreditType(String code, String subcode) {
		
		// code = 12 - type CC
		if(Integer.parseInt(code) == CreditFormatConstants.CREDIR_CARD_CODE)
			return LiabilityTypes.CREDIT_CARD;
		
		// code = 10 
		else if(Integer.parseInt(code) == CreditFormatConstants.CON_MORTG_CODE ){
			
			//sub code = 12 type - conv mortgage
			if(Integer.parseInt(subcode) == CreditFormatConstants.CON_MORTG_SUB_CODE)
				return LiabilityTypes.CONV_MORTGATE;
			
			//sub code = 15 type mortgage 
			else if(Integer.parseInt(subcode) == CreditFormatConstants.MORTG_SUB_CODE)
				return LiabilityTypes.MORTGATE;
		}
		// code = 5
		else if(Integer.parseInt(code) == CreditFormatConstants.STUDENT_LOAN_CODE)
			return LiabilityTypes.STUDENT_LOAN;
		
		// None of the above
		else
			return LiabilityTypes.MISC;
		
		return LiabilityTypes.UNKNOWN;
	}
}
