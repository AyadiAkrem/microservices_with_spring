/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdeep.micorservices.socialmathematics.multiplication.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itdeep.micorservices.socialmathematics.multiplication.domain.Multiplication;
import com.itdeep.micorservices.socialmathematics.multiplication.service.MultiplicationService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * SpringRunner tells JUnit to run using Spring's testing support. it is the new
 * name for SpringJUnit4ClassRunner
 *
 * Using @WebMvcTest, HTTP requests and responses will be mocked so the real
 * connections are not created.
 *
 * @author AYADI Akrem
 */
@RunWith(SpringRunner.class)
@WebMvcTest(MultiplicationController.class)
public class MultiplicationControllerTest {

    @MockBean
    private MultiplicationService multiplicationService;

    @Autowired
    private MockMvc mvc;

    private JacksonTester<Multiplication> json;

    public MultiplicationControllerTest() {
    }

    @Before
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    public void getRandomMultiplicationTest() throws Exception {
        //given 
        given(multiplicationService.createRandomMultiplication()).
                willReturn(new Multiplication(70, 29));
        // when 
        MockHttpServletResponse response = mvc.perform(get("/multiplications/random").accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        //then 
        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        Assertions.assertThat(response.getContentAsString()).isEqualTo(json.write(new Multiplication(70, 29)).getJson());
    }

}
