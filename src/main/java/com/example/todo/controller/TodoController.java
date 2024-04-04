package com.example.todo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.domain.Todo;
import com.example.todo.service.TodoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todos")
public class TodoController {

	private final TodoService todoService;

	@GetMapping
	public List<Todo> getAllTodos() {
		return todoService.findAll();
	}

	@GetMapping("/{id}")
	public Todo getTodoById(@PathVariable Long id) {
		return todoService.findById(id);
	}

	@PostMapping
	public Todo createTodo(@RequestBody Todo todo) {
		return todoService.save(todo);
	}

	@PutMapping("/{id}")
	public Todo updateTodo(@PathVariable Long id, @RequestBody Todo toDoDetails) {
		return todoService.updateTodo(id, toDoDetails);
	}

	@DeleteMapping("/{id}")
	public void deleteTodo(@PathVariable Long id) {
		 todoService.deleteTodo(id);
	}
}
