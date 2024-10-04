package com.applicataion.restSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class StudentController {

    /*@GetMapping(path = "/student")
    public String studentString() {
        return "Krutika";
    }*/

    @GetMapping(path = "/student-bean")
    public Student studentBean() {
        return new Student("Krutika");
    }

    /*@GetMapping(path="/student/{name}")
    public Student studentPathVariable(@PathVariable String name)
    {
        return new Student(String.format("%s", name)); //%s replace the name
    }*/

    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public List<Student> retriveAllStudents()
    {
        return service.findAll();
    }

    @GetMapping("/student/{id}")
    public Student retriveStudent(@PathVariable int id)
    {
        Student student =  service.findOne(id);
        if(student==null) {
            throw new StudentNotFoundException("id:" + id);
        }
        return student;
    }

    @PostMapping("/student")
    public ResponseEntity<Object> createSTudent(@RequestBody Student student)
    {
        Student savedStudent = service.save(student);
        // takes the current path, appends id that we got from the object
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedStudent.getId()).toUri();
        // this sets the status as 201 - created
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable int id)
    {
        Student student = service.deleteById(id);
        if(student==null) {
            throw new StudentNotFoundException("id: " + id);
        }
    }
}
