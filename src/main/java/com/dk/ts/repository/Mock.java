package com.dk.ts.repository;


import com.dk.ts.model.Student;

import java.util.List;

public class Mock implements IStudentRepository {
    @Override
    public boolean create(Student t) {
        return false;
    }

    @Override
    public List<Student> readAll() {
        return null;
    }
}
