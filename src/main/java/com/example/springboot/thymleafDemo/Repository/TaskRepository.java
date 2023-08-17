package com.example.springboot.thymleafDemo.Repository;

import com.example.springboot.thymleafDemo.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
