package com.dk.ts.repository;

import com.dk.ts.model.Student;
import java.util.List;

public interface IStudentRepository {

    // Crud methods

    boolean create(Student t);
    //Student read(int id);
    List<Student> readAll();
    //boolean update(Student t);
    //boolean delete(int id);
}

