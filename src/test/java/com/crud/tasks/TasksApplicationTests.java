package com.crud.tasks;

import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TasksApplicationTests {

	public static void main(String[] args) {
		TaskDto taskDto = new TaskDto(
				1L,
				"Test title",
				"I want to be a coder!");

		Long id = taskDto.getId();
		String title = taskDto.getTitle();
		String content = taskDto.getContent();

		System.out.println(id + " " + title + " " + content);
	}
}
