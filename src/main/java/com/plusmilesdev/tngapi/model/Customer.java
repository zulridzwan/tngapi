package com.plusmilesdev.tngapi.model;

import java.util.Date;

public class Customer {

	public Customer() {
		super();
	}
	
	private String tagid;
	
	private String customername;
	
	public String getTagid() {
		return tagid;
	}

	public void setTagid(String tagid) {
		this.tagid = tagid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	private Date createddate;

}
