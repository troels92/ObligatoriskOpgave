package com.dk.ts.controller;

import com.dk.ts.model.Student;
import com.dk.ts.repository.StudentsJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController  {

    //IStudentRepository studentRepository;
    StudentsJPARepository studentRepository;

    public StudentController(StudentsJPARepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("std", studentRepository.findAll());
        return "index";
    }


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("student", new Student());
        return "create";

    }

    @PostMapping("/create")
    public String create(@ModelAttribute Student stu) {

        studentRepository.save(stu);
        return "redirect:/";
    }
/*
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, Model model) {
        model.addAttribute("stu", studentRepository.findById(id));

        return "/";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Student stu, Model model){
        studentRepository.delete(stu);
        return "redirect:/index";
    }

    @GetMapping("/edit")
    public String update(@RequestParam("id") int id, Model model){
        model.addAttribute("student", studentRepository.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/index";
    }



    @GetMapping("/enroll")
    public String enroll(@RequestParam("id") String id, Model model) {
        // TODO: Get list of Courses
        // model.addAttribute("courses", courserepository.readAll());
        model.addAttribute("stu", studentRepository.read(Integer.parseInt(id)));
        return "enroll"; // enroll.html is similar to create student
    }
*/
}
