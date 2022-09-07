package org.rb.Model;

import java.time.Instant;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="todo_item")
public class TodoItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	@Getter
	@Setter
	private String description;
	
	@Getter
	@Setter
	private boolean complete;
	
	@Getter
	@Setter
	private Instant createdDate;
	
	@Getter
	@Setter
	private Instant modifiedDate;

	public TodoItem() {
		super();
	}
	
	public TodoItem(String description) {
		this.description=description;
		this.complete=false;
		this.createdDate = Instant.now();
		this.modifiedDate=Instant.now();
	}

	@Override
	public String toString() {
		return "TodoItem [id=" + id + ", description=" + description + ", complete=" + complete + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate + "]";
	}
	

}
