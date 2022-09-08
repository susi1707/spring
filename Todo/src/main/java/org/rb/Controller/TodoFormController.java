package org.rb.Controller;

import org.rb.Model.TodoItem;
import org.rb.Repo.TodoItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TodoFormController {
	@Autowired
	private TodoItemRepo repo;
	
	@GetMapping("/edit/{id}")
	public String showUpForm(@PathVariable("id") long id,Model model) {
		TodoItem todoItem= repo.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("TodoItem id :"+id+"Not found"));
		model.addAttribute("todo", todoItem);
		return "update-todo-item";
	}

}
