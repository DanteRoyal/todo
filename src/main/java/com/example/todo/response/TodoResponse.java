package com.example.todo.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@AllArgsConstructor
@Getter
@Builder
public class TodoResponse {

	private final Long id;

	private final String title;

	private final String content;

	private final boolean completed;
}
