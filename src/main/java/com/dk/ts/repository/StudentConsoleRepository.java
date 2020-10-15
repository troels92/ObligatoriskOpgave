package com.dk.ts.repository;


import com.dk.ts.model.Student;
import com.dk.ts.repository.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentConsoleRepository implements IStudentRepository {
    private Connection conn;
    private PreparedStatement preparedStatement;
    private ResultSet rs;
    private List<Student> students;

    public StudentConsoleRepository() {
        this.students = new ArrayList<Student>();
        this.conn = DbConnection.getConnection();
    }

    @Override
    public List<Student> readAll() {
        students.clear();

        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM students");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                students.add(new Student(rs.getInt("students_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("cpr")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return students;
    }

    @Override
    public boolean create(Student student) {
        try {

            preparedStatement = conn.prepareStatement("INSERT INTO students(first_name, last_name, cpr)  VALUES (?,?,?)");

            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getCpr());

            preparedStatement.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

