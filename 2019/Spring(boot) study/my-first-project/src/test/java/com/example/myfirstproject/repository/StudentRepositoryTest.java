package com.example.myfirstproject.repository;

import com.example.myfirstproject.entity.Student;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;

    @After
    public void cleanUp() {
        studentRepository.deleteAll();
    }

    @Test
    public void saveAndFindAllTest() {
        // given
        Student student = new Student();
        student.setName("Sohee");
        student.setHackbun("2015108196");
        student.setBirthday("19960829");
        student.setGender("w");

        // when
        studentRepository.save(student);
        List<Student> students = (List<Student>) studentRepository.findAll();

        // then
        Student result = students.get(0);

        assertThat(result.getId(), is(student.getId()));
        assertThat(result.getName(), is(student.getName()));
        assertThat(result.getHackbun(), is(student.getHackbun()));
        assertThat(result.getGender(), is(student.getGender()));
        assertThat(result.getBirthday(), is(student.getBirthday()));
    }
}
