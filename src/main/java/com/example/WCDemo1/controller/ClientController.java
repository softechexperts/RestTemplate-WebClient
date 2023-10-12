package com.example.WCDemo1.controller;

import com.example.WCDemo1.model.Student;
import com.example.WCDemo1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/students")
public class ClientController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Flux<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Mono<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Mono<Student> createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public Mono<Void> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }
}
