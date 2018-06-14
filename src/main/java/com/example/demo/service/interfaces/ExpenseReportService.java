package com.example.demo.service.interfaces;

import javax.inject.Named;

import com.example.demo.model.ExpenseReport;

@Named
public interface ExpenseReportService {

	public ExpenseReport getExpeneReport(String creditReport) throws Exception;
}
