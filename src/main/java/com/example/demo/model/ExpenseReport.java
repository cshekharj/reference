package com.example.demo.model;

import java.util.ArrayList;

import com.example.demo.model.views.View;
import com.fasterxml.jackson.annotation.JsonView;

public class ExpenseReport {

	@JsonView(View.Summary.class)
	private ArrayList<Tradelines> tradelines = new ArrayList<Tradelines>();
	@JsonView(View.Summary.class)
	    private float fixed_expenses_before_education;

	    public ArrayList<Tradelines> getTradelines ()
	    {
	        return tradelines;
	    }

	    public void setTradelines (ArrayList<Tradelines> tradelines)
	    {
	        this.tradelines = tradelines;
	    }

	    public float getFixed_expenses_before_education ()
	    {
	        return fixed_expenses_before_education;
	    }

	    public void setFixed_expenses_before_education (float fixed_expenses_before_education)
	    {
	        this.fixed_expenses_before_education = fixed_expenses_before_education;
	    }

}
