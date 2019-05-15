package com.example.myfirstproject.controller;

import com.example.myfirstproject.mockModel.ObjectMocker;
import com.example.myfirstproject.service.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class StudentControllerTest extends ObjectMocker {

    private MockMvc mockMvc;

    @Autowired
    StudentController studentController;

    @MockBean
    private StudentService studentService;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }

    @Test
    public void testList() throws Exception {
        // given
        given(studentService.list()).willReturn(students);

        // when
        ResultActions actions = mockMvc.perform(get("/students"));

        // then
        actions.andExpect(status().isOk())
                .andExpect(model().size(students.size()));
    }
}
