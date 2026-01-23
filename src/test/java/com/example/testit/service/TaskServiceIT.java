package com.example.testit.service;

import com.example.testit.model.Task;
import com.example.testit.model.User;
import com.example.testit.repository.TaskRepository;
import com.example.testit.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TaskServiceIT {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    @Test
    public void testUpdateTask() {
        var task = new Task();
        var assigned = new User();

        assigned.setId(1L);

        task.setTitle("task1");
        task.setDescription("This is the frist task");
        task.setAssignedUser(assigned);

        taskRepository.save(task);
    }
}
