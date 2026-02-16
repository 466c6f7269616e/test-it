package com.example.testit.service;

import com.example.testit.model.Task;
import com.example.testit.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Transactional
public class TaskServiceIT {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskService taskService;

    @Test
    public void testFindById() {
        var task = new Task();
        task.setTitle("Task to find");
        task.setDescription("Description");
        var taskSaved = taskRepository.save(task);

        var foundTask = taskService.findById(taskSaved.getId());

        Assertions.assertThat(foundTask).isPresent().get().usingRecursiveComparison().isEqualTo(taskSaved);
    }

    @Test
    public void testDeleteTask() {
        var task = new Task();

        task.setTitle("task to delete");
        task.setDescription("This is the frist task");
        var taskSaved = taskRepository.save(task);

        taskService.deleteTask(taskSaved.getId());

        Assertions.assertThat(taskRepository.findAll()).isEqualTo(List.of());
    }
}
