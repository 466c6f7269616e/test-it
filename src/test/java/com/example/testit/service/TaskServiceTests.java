package com.example.testit.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.example.testit.repository.*;
import com.example.testit.adapter.mail.MailService;
import com.example.testit.model.User;
import java.util.Optional;

public class TaskServiceTests {
    
    TaskService taskService;

    MailService mailService;
    TaskRepository taskRepository;
    UserRepository userRepository;

    @BeforeEach 
    void setUp() {
        mailService = Mockito.mock(MailService.class);
        taskRepository = Mockito.mock(TaskRepository.class);
        userRepository = Mockito.mock(UserRepository.class);
        taskService = new TaskService(taskRepository, userRepository, mailService);
    }
    
    @Test 
    public void testCreateTask() {
        var requester = new User("requester");
        var assigned = new User("assigned");

        requester.setId(1L);
        assigned.setId(2L);
        assigned.setManager(requester);

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(requester));
        Mockito.when(userRepository.findById(2L)).thenReturn(Optional.of(assigned));
        taskService.createTask("task1", "First task assigned to user 2", 1L, 2L);

        Mockito.verify(taskRepository).save(Mockito.any());
    }
}
