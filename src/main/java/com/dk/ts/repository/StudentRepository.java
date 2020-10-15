package com.dk.ts.repository;

import com.dk.ts.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

// @Repository
public class StudentRepository implements IStudentRepository {

    @Autowired
    private JdbcTemplate jdbc;
    private List<Student> students;
    private SqlRowSet rs;

    public StudentRepository() {
        students = new ArrayList<Student>();
    }


    @Override
    public List<Student> readAll() {
        students.clear();
        rs = jdbc.queryForRowSet("select * from students");
        while (rs.next()) {

            students.add(new Student(rs.getInt("students_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),

                    rs.getString("cpr")));

        }
        return students;
    }

    @Override
    public boolean create(Student student) {


        jdbc.update("insert into students(first_name,last_name, cpr)" +
                "values('" + student.getFirstName() + "','" + student.getLastName() + "', '" +
                 "', '" + student.getCpr() + "')");

        return true;
    }


/*

    @Override
    public Student read(int id) {
        // Student without enrollments
        rs = jdbc.queryForRowSet("SELECT * FROM students where students_id ='" + id + "'");
        while (rs.next()) {

            return new Student(rs.getInt("students_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),

                    rs.getString("cpr"));

        }

        return new Student();
    }



    @Override
    public boolean update(Student student) {

        int result = jdbc.update("UPDATE students SET " +
                "first_name ='" + student.getFirstName() + "' , " +
                "last_name='" + student.getLastName() + "' ," +
                "cpr='" + student.getCpr() + "' WHERE students_id = '" + student.getStudentId() + "'");
        return true;

    }

    @Override
    public boolean delete(int id) {
        // TODO: return type bool
        int result = jdbc.update("DELETE FROM students WHERE students_id='" + id + "'");
        return true;
    }

    */
}
