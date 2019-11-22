package com.plusmilesdev.tngapi.api;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.plusmilesdev.tngapi.model.Customer;
import com.plusmilesdev.tngapi.model.SampleResponse;
import com.plusmilesdev.tngapi.repository.CustomerRepository;
import com.plusmilesdev.tngapi.service.SampleUtils;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository repository;
	
	public CustomerController() {
		super();
	}
	
	@RequestMapping(value="/api/customer", method=RequestMethod.GET)
	@ResponseBody
	public List<Customer> getCustomer() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@RequestMapping(value="/api/customer", method=RequestMethod.POST)
	@ResponseBody
	public SampleResponse addCustomer() {
		UUID uid=UUID.randomUUID();
		Customer c = new Customer(uid.toString(), SampleUtils.getRandomName(), new Timestamp(System.currentTimeMillis()));
		int affected = repository.save(c);
		String response = "Error! database insert failed";
		if(affected>0) {
			response = "Customer "+c.getCustomername()+" created";
		}
		return new SampleResponse(response);
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
