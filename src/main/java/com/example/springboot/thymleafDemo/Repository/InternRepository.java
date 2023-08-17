package com.example.springboot.thymleafDemo.Repository;

import com.example.springboot.thymleafDemo.Entity.Intern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InternRepository extends JpaRepository<Intern, Integer> {
    Optional<Intern> findInternByEmail(String email);
}
