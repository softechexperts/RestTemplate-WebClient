package com.example.WCDemo1.service;

import com.example.WCDemo1.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    private final String baseUrl = "http://localhost:8080/api/students";

    public Flux<Student> getAllStudents() {
        return webClientBuilder.build()
                .get()
                .uri(baseUrl)
                .retrieve()
                .bodyToFlux(Student.class);
    }

    public Mono<Student> getStudentById(Long id) {
        return webClientBuilder.build()
                .get()
                .uri(baseUrl + "/" + id)
                .retrieve()
                .bodyToMono(Student.class);
    }

    public Mono<Student> createStudent(Student student) {
        return webClientBuilder.build()
                .post()
                .uri(baseUrl)
                .body(Mono.just(student), Student.class)
                .retrieve()
                .bodyToMono(Student.class);
    }

    public Mono<Void> updateStudent(Long id, Student student) {
        return webClientBuilder.build()
                .put()
                .uri(baseUrl + "/" + id)
                .body(Mono.just(student), Student.class)
                .retrieve()
                .bodyToMono(Void.class);
    }

    public Mono<Void> deleteStudent(Long id) {
        return webClientBuilder.build()
                .delete()
                .uri(baseUrl + "/" + id)
                .retrieve()
                .bodyToMono(Void.class);
    }
}
