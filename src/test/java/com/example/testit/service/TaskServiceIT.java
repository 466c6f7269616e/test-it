package com.example.testit.service;

import com.example.testit.adapter.mail.MailService;
import com.example.testit.model.Task;
import com.example.testit.repository.TaskRepository;
import com.example.testit.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TaskServiceIT {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    MailService mailService;

    @Autowired
    TaskService taskService;

    @Test
    public void testDeleteTask() {
        var task = new Task();

        task.setTitle("task1");
        task.setDescription("This is the frist task");
        var taskSaved = taskRepository.save(task);

        taskService.deleteTask(taskSaved.getId());

        Assertions.assertThat(taskRepository.findAll()).isEqualTo(List.of());
    }
}
