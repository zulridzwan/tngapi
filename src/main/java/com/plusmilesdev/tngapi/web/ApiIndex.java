package com.plusmilesdev.tngapi.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApiIndex {

	@RequestMapping("api")
	public String apiIndex() {
		return "api_index";
	}

}
