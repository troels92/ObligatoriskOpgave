package com.dk.ts.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long lesson_id;
    private String description;
    private int fk_student;
    private int fk_teacher;

    public Lesson(String description){
        this.description = description;
    }


    /*
    int lesson_id
    description
    fk_student
    fk_teacher

     */
}
