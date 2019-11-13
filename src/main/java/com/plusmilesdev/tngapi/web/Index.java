package com.plusmilesdev.tngapi.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {
	
	@RequestMapping(value="/")
	public String index() {
		return "index";
	}
}
