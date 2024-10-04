package com.applicataion.restSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class StudentRepository {

    public static int studentCount=5;
    private static List<Student> students = new ArrayList<>();

    static
    {
        students.add(new Student(1, "Krutika", "12-01-12"));
        students.add(new Student(2, "Abha", "01-02-99"));
        students.add(new Student(3, "Nikita", "18-08-78"));
        students.add(new Student(4, "Rajiv", "16-11-12"));
        students.add(new Student(5, "Kushansh", "13-11-92"));
    }

    public List<Student> findAll()
    {
        return students;
    }

    public Student save(Student student)
    {
        if(student.getId()==null)
        {
            student.setId(++studentCount);
        }
        students.add(student);
        return student;
    }

    public Student findOne(int id)
    {
        for(Student student:students)
        {
            if(student.getId()==id)
                return student;
        }
        return null;
    }

    public Student deleteById(int id)
    {
        Iterator<Student> iterator = students.iterator();
        while(iterator.hasNext())
        {
            Student student = iterator.next();
            if(student.getId()==id)
            {
                iterator.remove();
                return student;
            }
        }
        return null;
    }
}
