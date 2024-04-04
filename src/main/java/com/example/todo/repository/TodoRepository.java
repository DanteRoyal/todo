package com.example.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}