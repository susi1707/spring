package org.rb.Config;

import org.rb.Model.TodoItem;
import org.rb.Repo.TodoItemRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TodoDataLoader implements CommandLineRunner {
	private final Logger logger = LoggerFactory.getLogger(TodoDataLoader.class);
	
	@Autowired
	private TodoItemRepo itemRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		LoadSeedData();
	}
	public void LoadSeedData() {
		if(itemRepo.count()==0) {
			TodoItem todoItem1 = new TodoItem("Get the Book");
			TodoItem todoItem2 = new TodoItem("Study for 1hr");
			
			itemRepo.save(todoItem1);
			itemRepo.save(todoItem2);
		}
		logger.info("Number of Todo Items: {}",itemRepo.count());
	}

}
