package com.dk.ts.repository;

import com.dk.ts.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentsJPARepository extends CrudRepository<Student, Integer> {
}
