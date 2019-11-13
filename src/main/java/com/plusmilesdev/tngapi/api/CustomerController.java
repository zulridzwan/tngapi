package com.plusmilesdev.tngapi.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.plusmilesdev.tngapi.model.SampleResponse;

@RestController
public class CustomerController {

	public CustomerController() {
		super();
	}
	
	@RequestMapping(value="/api/customer", method=RequestMethod.GET)
	@ResponseBody
	public SampleResponse getCustomer() {
		return new SampleResponse("1234567890");
	}
	
	@RequestMapping(value="/api/customer", method=RequestMethod.POST)
	@ResponseBody
	public SampleResponse addCustomer() {
		return new SampleResponse("Added");
	}
	
	@RequestMapping(value="/api/customer", method=RequestMethod.PUT)
	@ResponseBody
	public SampleResponse updateCustomer() {
		return new SampleResponse("Updated");
	}
	
	@RequestMapping(value="/api/customer", method=RequestMethod.DELETE)
	@ResponseBody
	public SampleResponse deleteCustomer() {
		return new SampleResponse("Deleted");
	}
	
	
	

}
