package com.example.RTDemo1.service;

import com.example.RTDemo1.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentService {

    @Autowired
    private RestTemplate restTemplate;

    private final String baseUrl = "http://localhost:8080/api/students";

    public Student getStudent(Long id) {
        return restTemplate.getForObject(baseUrl + "/" + id, Student.class);
    }
    public Student[] getAllStudents() {
        return restTemplate.getForObject(baseUrl, Student[].class);
    }

    public Student getStudentById(Long id) {
        return restTemplate.getForObject(baseUrl + "/" + id, Student.class);
    }
    public Student createStudent(Student student) {
        return restTemplate.postForObject("http://localhost:8080/api/students", student, Student.class);

    }

    public void updateStudent(Long id, Student student) {
        restTemplate.put(baseUrl + "/" + id, student);
    }

    public void deleteStudent(Long id) {
        restTemplate.delete(baseUrl + "/" + id);
    }
}
