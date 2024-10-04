package com.applicataion.restSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> findAll()
    {
        return studentRepository.findAll();
    }

    public Student save(Student user)
    {
        return studentRepository.save(user);
    }

    public Student findOne(int id)
    {
        return studentRepository.findOne(id);
    }

    public Student deleteById(int id)
    {
        return studentRepository.deleteById(id);
    }
}

