package com.dk.ts.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long lesson_id;
    private String description;
    @ManyToMany(mappedBy = "fk_students")
    private List<Student> studentList = new ArrayList<>();

    private int fk_teacher;

    public Lesson(String description){
        this.description = description;
    }
    public void addStudent(Student student){
        studentList.add(student);
    }


    /*
    int lesson_id
    description
    fk_student
    fk_teacher

     */
}
