package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final DbService service;
    private final TaskMapper taskMapper;

    @GetMapping
    public ResponseEntity<List<TaskDto>> getTasks() {
        List<Task> tasks = service.getAllTasks();
        return ResponseEntity.ok(taskMapper.mapToTaskDtoList(tasks));
    }

    @GetMapping(value = "{taskId}")
    public ResponseEntity<TaskDto> getTask(@PathVariable Long taskId) throws TaskNotFoundException {
        return ResponseEntity.ok(taskMapper.mapToTaskDto(service.getTask(taskId)));
    }

    //    public ResponseEntity<TaskDto> getTask(@PathVariable long taskId) {
//        try{
//            return new ResponseEntity<TaskDto>(taskMapper.mapToTaskDto(service.getTask(taskId)), HttpStatus.OK);
//        } catch (TaskNotFoundException e) {
//            return new ResponseEntity<>(
//                    new TaskDto(0L, "theres's no task with id equal to " + taskId, ""), HttpStatus.BAD_REQUEST);
//        }
//    }
//    public ResponseEntity<TaskDto> getTask(@PathVariable Long taskId) throws TaskNotFoundException {
//        return new ResponseEntity<>(taskMapper.mapToTaskDto(service.getTask(taskId)), HttpStatus.OK);
//    }

    @DeleteMapping(value = "{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Long taskId) throws TaskNotFoundException {
        return ResponseEntity.ok().body("Task no. " + taskId + " deleted successfully");
    }

    @PutMapping(value = "")
    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto taskDto) {
        Task task = taskMapper.mapToTask(taskDto);
        Task savedTask = service.saveTask(task);
        return ResponseEntity.ok(taskMapper.mapToTaskDto(savedTask));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTask(@RequestBody TaskDto taskDto) {
        Task task = taskMapper.mapToTask(taskDto);
        service.saveTask(task);
        return ResponseEntity.ok().build();
    }
}