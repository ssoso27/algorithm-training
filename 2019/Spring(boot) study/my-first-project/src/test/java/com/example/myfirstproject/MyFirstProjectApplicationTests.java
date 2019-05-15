package com.example.myfirstproject;

import com.example.myfirstproject.controller.StudentController;
import com.example.myfirstproject.entity.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

@RunWith(SpringRunner.class)
@SpringBootTest(
		properties = {
			"spring.datasource.url=jdbc:mysql://localhost/jeju?charset=utf-8&serverTimezone=UTC",
			"spring.datasource.username=jeju",
			"spring.datasource.password=jejupw"
		}
)
@Transactional
public class MyFirstProjectApplicationTests {
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String jejupw;

	@Autowired
	private StudentController studentController;

	private Student student;
	private Student realStudent;

	@Before
	public void setUp() {
		student = new Student();
		student.setName("고길동");
		student.setHackbun("2011103102");
		student.setBirthday("19920514");
		student.setGender("m");

		realStudent = new Student();
		realStudent.setId(1);
		realStudent.setName("김철수");
		realStudent.setHackbun("2011150251");
		realStudent.setBirthday("19920501");
		realStudent.setGender("m");

	}

	@Test
	public void contextLoads() {
		assertThat(url, is("jdbc:mysql://localhost/jeju?charset=utf-8&serverTimezone=UTC"));
		assertThat(username, is("jeju"));
		assertThat(jejupw, is("jejupw"));
	}

	@Test
	public void testList() {
		List<Student> results = studentController.list();

		assertThat(results.size(), is(9));
		assertThat(results.get(0), is(realStudent));
	}

	@Test
	public void testGet() {
		int id = 1;
		String name = "김철수";
		Student result = studentController.get(id);

		assertThat(result.getId(), is(id));
		assertThat(result.getName(), is(name));
	}

	@Test
	public void testCreate() {
		Student target = student;
		studentController.create(target);
		Student result = studentController.get(target.getId());

		assertThat(result.getId(), is(target.getId()));
		assertThat(result.getName(), is(target.getName()));
		assertThat(result.getBirthday(), is(target.getBirthday()));
	}

	@Test
	public void testUpdate() {
		Student target = student;
		studentController.create(target);

		target.setName("바뀐애");
		target.setGender("f");
		target.setBirthday("33333333");
		target.setHackbun("33학번");

		studentController.update(target);
		Student result = studentController.get(target.getId());

		assertThat(result, is(target));
	}

	@Test
	public void testDelete() {
		// 타겟 객체 만들기
		Student target = new Student();
		target.setName("삭제될애");
		target.setHackbun("16학번");
		target.setBirthday("19971205");
		target.setGender("f");

		// DB에 inset해보고 (create)
		studentController.create(target);

		// 걔를 그대로 delete 하고 (delete)
		studentController.delete(target.getId());

		// 걔 id 가지고 get 해 본 뒤에 (get)
		Student result = studentController.get(target.getId());

		// 가지고 온 결과가 null 인지 확인 (assertThat)
		assertThat(result, is(nullValue()));
	}
}
