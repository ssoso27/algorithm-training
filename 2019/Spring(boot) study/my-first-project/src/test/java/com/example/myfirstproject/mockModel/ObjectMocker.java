package com.example.myfirstproject.mockModel;

import com.example.myfirstproject.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class ObjectMocker {
    public List<Student> students;

    public ObjectMocker() {
        makeStudents();
    }

    private void makeStudents() {
        int size = 5;
        this.students = new ArrayList<Student>();
        for (int i = 1; i <= size; i++) {
            Student student = new Student();
            student.setId(i);
            student.setName("name"+i);
            student.setGender(i%2==0?"m":"f");
            student.setBirthday("199"+i+"0101");
            student.setHackbun("std"+i);
            students.add(student);
        }
    }
}
