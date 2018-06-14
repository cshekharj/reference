package com.example.demo.model;

import com.example.demo.model.views.View;
import com.fasterxml.jackson.annotation.JsonView;

public class Tradelines {

	@JsonView(View.Summary.class)
	private long monthly_payment;
	@JsonView(View.Summary.class)
    private long current_balance;
	@JsonView(View.Summary.class)
    private String reported_Date;
    private String code;
    private String subcode;
    @JsonView(View.Summary.class)
    private String type;

    public String getReported_Date() {
		return reported_Date;
	}

	public void setReported_Date(String reported_Date) {
		this.reported_Date = reported_Date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSubcode() {
		return subcode;
	}

	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}
    
    public long getMonthly_payment ()
    {
        return monthly_payment;
    }

    public void setMonthly_payment (long monthly_payment)
    {
        this.monthly_payment = monthly_payment;
    }

    public long getCurrent_balance ()
    {
        return current_balance;
    }

    public void setCurrent_balance (long current_balance)
    {
        this.current_balance = current_balance;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }
}
