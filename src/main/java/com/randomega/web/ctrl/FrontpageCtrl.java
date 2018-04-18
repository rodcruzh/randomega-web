package com.randomega.web.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrontpageCtrl {

	@RequestMapping("/")
	public String home() {
		return "Welcome!";
	}

}
