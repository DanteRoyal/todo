package com.example.todo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo.domain.Todo;
import com.example.todo.repository.TodoRepository;
import com.example.todo.request.TodoRequest;
import com.example.todo.response.TodoResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {

	private final TodoRepository todoRepository;

	public void saveTodo(final TodoRequest request) {
		Todo todo = Todo.builder()
			.title(request.getTitle())
			.content(request.getContent())
			.completed(false)
			.build();

		todoRepository.save(todo);
	}

	public TodoResponse findTodoById(final Long id) {
		Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("못찾음"));

		return TodoResponse.builder()
			.id(todo.getId())
			.title(todo.getTitle())
			.content(todo.getContent())
			.completed(todo.isCompleted())
			.build();
	}

	public final List<TodoResponse> findAllTodos() {
		return todoRepository.findAll().stream()
			.map(todo -> new TodoResponse(todo.getId(), todo.getTitle(), todo.getContent(), todo.isCompleted()))
			.collect(Collectors.toList());

	}
	@Transactional
	public TodoResponse updateTodo(final Long id, final TodoRequest request) {
		Todo todo = todoRepository.findById(id)
			.orElseThrow(() -> new RuntimeException("못찾음"));

		todo.update(request.getTitle(), request.getContent(), request.isCompleted());

		return TodoResponse.builder()
			.id(todo.getId())
			.title(todo.getTitle())
			.content(todo.getContent())
			.completed(todo.isCompleted())
			.build();
	}

	public void deleteTodo(final Long id) {
		Todo todo = todoRepository.findById(id)
			.orElseThrow(() -> new RuntimeException("못찾음"));

		todoRepository.delete(todo);
	}
}
