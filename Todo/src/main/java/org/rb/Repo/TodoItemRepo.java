package org.rb.Repo;

import org.rb.Model.TodoItem;

import org.springframework.data.repository.CrudRepository;

public interface TodoItemRepo extends CrudRepository<TodoItem, Long> {

}
