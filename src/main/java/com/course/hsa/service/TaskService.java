package com.course.hsa.service;

import com.course.hsa.controller.dto.TaskDto;
import com.course.hsa.domain.Task;
import com.course.hsa.domain.TaskLog;
import com.course.hsa.repository.TaskLogRepository;
import com.course.hsa.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskLogRepository taskLogRepository;

    public void addTask(TaskDto taskDto) {
        var task = map(taskDto);
        taskRepository.save(task);

        var taskLog = mapLog(taskDto);
        taskLogRepository.save(taskLog);
    }

    public List<TaskDto> getTasks() {
        return taskRepository.findAll().stream().map(this::map).toList();
    }

    public List<TaskDto> getTaskLogs() {
        return StreamSupport.stream(taskLogRepository.findAll().spliterator(), false).map(this::mapLog).toList();
    }

    private Task map(TaskDto taskDto) {
        var entity = new Task();
        entity.setName(taskDto.getName());
        entity.setUser(taskDto.getUser());
        return entity;
    }

    private TaskLog mapLog(TaskDto taskDto) {
        var entity = new TaskLog();
        entity.setName(taskDto.getName());
        entity.setUser(taskDto.getUser());
        return entity;
    }

    private TaskDto map(Task task) {
        return new TaskDto(task.getName(), task.getUser());
    }

    private TaskDto mapLog(TaskLog taskLog) {
        return new TaskDto(taskLog.getName(), taskLog.getUser());
    }
}
