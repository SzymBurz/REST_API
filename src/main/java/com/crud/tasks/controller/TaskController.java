package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/v1/tasks")
public class TaskController {

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<TaskDto> getTasks() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public TaskDto getTask(Long taskId) {
        return new TaskDto(1L, "test title", "test_content");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "")
    public void deleteTask(Long taskId) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "")
    public TaskDto updateTask(TaskDto taskDto) {
        return new TaskDto(1L, "Edited test title", "Test content");
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public void createTask(TaskDto taskDto) {

    }
}