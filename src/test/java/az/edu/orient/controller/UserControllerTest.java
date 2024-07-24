package az.edu.orient.controller;

import az.edu.orient.entity.UserEntity;
import az.edu.orient.exception.OrientException;
import az.edu.orient.model.UserDto;
import az.edu.orient.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    void getUsersGivenUsersIsNotEmptyExpectRespondOk() throws Exception {
        //setup
        List<UserDto> users = new ArrayList<>();
        users.add(new UserDto(1L, "Rashid", "Mammadli", "AZE"));
        Mockito.when(userService.getUsers()).thenReturn(users);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users")).andReturn();

        assertEquals(200, mvcResult.getResponse().getStatus());
        assertEquals(MediaType.APPLICATION_JSON_VALUE, mvcResult.getResponse().getContentType());
    }
    @Test
    void getUsersGivenUsersIsNotEmptyExpectRespondNotFound() throws Exception {
        //setup
        List<UserDto> users = new ArrayList<>();
        Mockito.when(userService.getUsers()).thenThrow(new OrientException("NOT FOUND", HttpStatus.NOT_FOUND));

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users")).andReturn();

        assertEquals(404, mvcResult.getResponse().getStatus());
        assertEquals(MediaType.APPLICATION_JSON_VALUE, mvcResult.getResponse().getContentType());
    }

}