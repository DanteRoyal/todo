package com.example.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo.domain.Todo;
import com.example.todo.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TodoService {

	private final TodoRepository todoRepository;

	public final List<Todo> findAll() {
		return todoRepository.findAll();
	}

	public Todo findById(Long id) {
		return todoRepository.findById(id).orElseThrow();
	}

	public Todo save(Todo todo) {
		return todoRepository.save(todo);
	}

	public Todo updateTodo(Long id, Todo toDoDetails) {
		Todo todo = findById(id);
		todo.setDescription(toDoDetails.getDescription());
		todo.setTitle(toDoDetails.getTitle());
		todo.setCompleted(toDoDetails.isCompleted());
		return todoRepository.save(todo);
	}

	public void deleteTodo(Long id) {
		todoRepository.deleteById(id);
	}
}
