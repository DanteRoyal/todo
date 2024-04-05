package com.example.todo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.domain.Todo;
import com.example.todo.request.TodoRequest;
import com.example.todo.response.TodoResponse;
import com.example.todo.service.TodoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todos")
public class TodoController {

	private final TodoService todoService;

	@PostMapping
	public void createTodo(@RequestBody final TodoRequest reqeust) {
		 todoService.saveTodo(reqeust);
	}

	@GetMapping("/{id}")
	public TodoResponse getTodoById(@PathVariable final Long id) {
		return todoService.findTodoById(id);
	}

	@GetMapping
	public List<TodoResponse> getAllTodos() {
		return todoService.findAllTodos();
	}

	@PatchMapping("/{id}")
	public TodoResponse updateTodo(@PathVariable final Long id, @RequestBody final TodoRequest request) {
		return todoService.updateTodo(id, request);
	}

	@DeleteMapping("/{id}")
	public void deleteTodo(@PathVariable final Long id) {
		 todoService.deleteTodo(id);
	}
}
