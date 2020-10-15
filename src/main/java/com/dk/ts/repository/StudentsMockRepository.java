package com.dk.ts.repository;



import com.dk.ts.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentsMockRepository implements IStudentRepository {
    @Override
    public boolean create(Student t) {
        return false;
    }

    @Override
    public List<Student> readAll() {
        //List<Student> students = new ArrayList<>();
        //students.add(new Student());
        return null; //students;
    }
}
