package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import com.example.demo.model.ExpenseReport;
import com.example.demo.model.views.View;
import com.example.demo.service.ExpenseReportServiceImpl;
import com.example.demo.service.interfaces.ExpenseReportService;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExpenseReportTest {

	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();
		ExpenseReportService reportService = new ExpenseReportServiceImpl();
		ExpenseReport report;

		try {
			URL url = ExpenseReportTest.class.getClassLoader().getResource("input.txt");
			File file = new File(url.toURI());
			Scanner scanner = new Scanner(file,"UTF8");
			String input = scanner.useDelimiter("\\Z").next();
			scanner.close();
			System.out.println("Input -"+input);
	       
	        report=reportService.getExpeneReport(input);

			//Convert object to JSON string and pretty print
			String jsonInString = mapper.writerWithView(View.Summary.class).writeValueAsString(report);
			System.out.println(jsonInString);


		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
