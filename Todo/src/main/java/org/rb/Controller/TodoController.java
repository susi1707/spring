package org.rb.Controller;

import org.rb.Repo.TodoItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TodoController {
	
	@Autowired
	private TodoItemRepo repo;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelandview = new ModelAndView("index");
		modelandview.addObject("todoItems", repo.findAll());
		return modelandview;
	} 

	
}
