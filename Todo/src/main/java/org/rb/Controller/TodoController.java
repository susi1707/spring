package org.rb.Controller;

import java.time.Instant;

import javax.validation.Valid;

import org.rb.Model.TodoItem;
import org.rb.Repo.TodoItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoController {
	
	@Autowired
	private TodoItemRepo repo;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelandview = new ModelAndView("index");
		modelandview.addObject("todoItems", repo.findAll());
		return modelandview;
	} 
	
	@PostMapping("/todo")
	public String addTodo(@Valid TodoItem item, BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "add-todo-item";
		}
		item.setCreatedDate(Instant.now());
		item.setModifiedDate(Instant.now());
		repo.save(item);
		return "redirect:/";
	}
	@PostMapping("/todo/{id}")
	public String updateItem(@PathVariable("id") long id ,@Valid TodoItem todoItem,BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors()) {
			todoItem.setId(id);
			return "update-todo-item";
		}
		todoItem.setModifiedDate(Instant.now());
		repo.save(todoItem);
		return "redirect:/";
	}	
}
