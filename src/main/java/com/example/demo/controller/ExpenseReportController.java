package com.example.demo.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.demo.model.ExpenseReport;
import com.example.demo.model.views.View;
import com.example.demo.service.interfaces.ExpenseReportService;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Component
@Path("/expensereport")
@Api(value = "expensereport")
public class ExpenseReportController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExpenseReportController.class);	
	
	@Inject
	private ExpenseReportService expenseService;
	
	
	@POST
    @Consumes("text/plain")
	@Produces("application/json")
	@JsonView(View.Summary.class)
	@ApiOperation(value = "Return Expense Report.",
    notes = "Multiple status values can be provided with comma seperated strings",
    response = ExpenseReport.class,
    responseContainer = "List")
    public Response getExpenseReport(String creditReport) throws Exception
    {
		logger.info("Received request with param-"+creditReport);
		ExpenseReport report = null;
		try {
			report = expenseService.getExpeneReport(creditReport);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(401).entity("error").build();
		}
        return Response.status(200).entity(report).build();
    }

}
