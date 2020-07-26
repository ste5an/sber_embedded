package com.sberbank.app.controller;


import com.google.gson.Gson;
import com.sberbank.app.controller.dto.NewEmployeeInfoDto;
import com.sberbank.app.dao.model.Employee;
import com.sberbank.app.service.EmployeeService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
@ExtendWith(SpringExtension.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService service;

    @Autowired
    private WebApplicationContext wac;


    // write test cases here
    @Test
    public void getAllEmployees() throws Exception {
        NewEmployeeInfoDto newEmployeeInfoDto = new NewEmployeeInfoDto();
        newEmployeeInfoDto.setFirstName("Stepan");
        newEmployeeInfoDto.setLastName("Papazian");
        newEmployeeInfoDto.setGivenName("M");
        newEmployeeInfoDto.setPosition("Junior");
        newEmployeeInfoDto.setAge(28);
        service.save(newEmployeeInfoDto);

        Optional<NewEmployeeInfoDto> allEmployees = Optional.of(newEmployeeInfoDto);

        mockMvc.perform(get("http://localhost:8080/rest/employee/employees")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)))
                .andExpect((ResultMatcher) jsonPath("$[0].firstName", is(newEmployeeInfoDto.getFirstName())))
                .andExpect((ResultMatcher) jsonPath("$[0].lastName", is(newEmployeeInfoDto.getLastName())))
                .andExpect((ResultMatcher) jsonPath("$[0].givenName", is(newEmployeeInfoDto.getGivenName())))
                .andExpect((ResultMatcher) jsonPath("$[0].position", is(newEmployeeInfoDto.getPosition())))
                .andExpect((ResultMatcher) jsonPath("$[0].age", is(newEmployeeInfoDto.getAge())));
    }

    @Test///тест бла бла
    public void saveEmployee() throws Exception {
        Employee newEmployeeInfoDto = new Employee();
        newEmployeeInfoDto.setFirstName("Stepan");
        newEmployeeInfoDto.setLastName("Papazian");
        newEmployeeInfoDto.setGivenName("M");
        newEmployeeInfoDto.setPosition("Junior");
        newEmployeeInfoDto.setAge(28);
        when(service.findAll()).thenReturn(Arrays.asList(newEmployeeInfoDto));

        mockMvc.perform(post("http://localhost:8080/rest/employee/save"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect((ResultMatcher) jsonPath("$[0].firstName", is(newEmployeeInfoDto.getFirstName())))
                .andExpect((ResultMatcher) jsonPath("$[0].lastName", is(newEmployeeInfoDto.getLastName())))
                .andExpect((ResultMatcher) jsonPath("$[0].givenName", is(newEmployeeInfoDto.getGivenName())))
                .andExpect((ResultMatcher) jsonPath("$[0].position", is(newEmployeeInfoDto.getPosition())))
                .andExpect((ResultMatcher) jsonPath("$[0].age", is(newEmployeeInfoDto.getAge())))
                .andExpect(jsonPath("$.message").value(newEmployeeInfoDto.toString()));

    }
}
