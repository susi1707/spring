package org.rb.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TodoController {
	
	@GetMapping("/home")
	public ModelAndView index() {
		ModelAndView modelandview = new ModelAndView("index");
		return modelandview;
	} 

}
