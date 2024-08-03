package com.course.hsa.controller;

import com.course.hsa.controller.dto.TaskDto;
import com.course.hsa.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping(path = "/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTask(@RequestBody TaskDto taskDto) {
        taskService.addTask(taskDto);
    }

    @GetMapping(path = "/tasks")
    public List<TaskDto> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping(path = "/tasklogs")
    public List<TaskDto> getTaskLogs() {
        return taskService.getTaskLogs();
    }
}
