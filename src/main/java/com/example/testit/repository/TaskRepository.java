package com.example.testit.repository;

import com.example.testit.model.Status;
import com.example.testit.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE t.assignedUser.id = :userId AND t.status = :status")
    List<Task> findByUserAndStatus(@Param("userId") Long userId, @Param("status") Status status);

    List<Task> findByAssignedUserId(Long userId);
}
