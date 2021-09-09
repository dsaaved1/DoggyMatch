package com.springboot.firstapp1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//the class is flagged as a @RestController, meaning it's ready
// for use by Spring MVC to handle web requests.
//When invoked from a browser or by using curl on the command line, the method returns pure text.
@RestController
public class NameOfAppReveal {

	// @GetMapping maps / to the index()
	@GetMapping("/")
	public String index() {
		return "My team is 3_rk_1 and we will build an application called DOGGY MATCH.";
	}

}
