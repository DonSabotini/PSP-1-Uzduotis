package com.psp.Lab3.controller;
import static org.mockito.Mockito.reset;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.psp.Lab3.model.User;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import com.psp.Lab3.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(value = UserController.class)
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    UserService userService;

    ObjectMapper objectMapper = new ObjectMapper();

    @AfterEach
    void tearDown() {
        reset(userService);
    }

    @Test
    void getAllUsersTest() throws Exception {
        List<User> users = new ArrayList<User>();
        users.add(new User("name",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$"));
        users.add(new User("name1",  "lastname1", "+37069999999", "email@gmail.com", "adress", "Passwor$"));
        when(userService.getAllUsers()).thenReturn(users);
        RequestBuilder rb = MockMvcRequestBuilders
                .get("/user")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isOk()) // 200
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String expected = objectMapper.writeValueAsString(users);
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

    }
    @Test
    void userByIdTest() throws Exception {
        User user = new User("name",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        when(userService.getById(Mockito.anyInt())).thenReturn(user);

        RequestBuilder rb = MockMvcRequestBuilders
                .get("/user/1")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String expected = objectMapper.writeValueAsString(user);
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

    }
    @Test
    void addUserTest() throws Exception {
        User user = new User("name",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        when(userService.add(Mockito.any(User.class))).thenReturn(user);

        String jsonUser = objectMapper.writeValueAsString(user);

        RequestBuilder rb = MockMvcRequestBuilders
                .post("/user")
                .content(jsonUser)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();


        JSONAssert.assertEquals(jsonUser, result.getResponse().getContentAsString(), false);
    }

    @Test
    void updateUserTest() throws Exception {
        User user = new User("name",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        when(userService.update(Mockito.any(User.class))).thenReturn(user);

        String jsonUser = objectMapper.writeValueAsString(user);

        RequestBuilder rb = MockMvcRequestBuilders
                .put("/user")
                .content(jsonUser)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();


        JSONAssert.assertEquals(jsonUser, result.getResponse().getContentAsString(), false);
    }
    @Test
    void deleteUserById() throws Exception {
        when(userService.getById(Mockito.anyInt())).thenReturn(new User());

        RequestBuilder rb = MockMvcRequestBuilders
                .delete("/user/1" );

        mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        verify(userService).removeById(Mockito.anyInt());
    }
}
