package com.itdeep.micorservices.socialmathematics.multiplication.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itdeep.micorservices.socialmathematics.multiplication.domain.Multiplication;
import com.itdeep.micorservices.socialmathematics.multiplication.domain.MultiplicationResultAttempt;
import com.itdeep.micorservices.socialmathematics.multiplication.domain.User;
import com.itdeep.micorservices.socialmathematics.multiplication.service.MultiplicationService;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * This class testing the class {@link MultiplicationResultAttemptController}
 *
 * @author Akrem AYADI
 */
@RunWith(SpringRunner.class)
@WebMvcTest(MultiplicationResultAttemptController.class)
public class MultiplicationResultAttemptControllerTest {

    @MockBean
    private MultiplicationService multiplicationService;

    @Autowired
    private MockMvc mvc;
    // this object will be automatically initialised by te initFields method below in the setUp method.
    private JacksonTester<MultiplicationResultAttempt> jsonResult;
    private JacksonTester<Map> jsonResponse;

    @Before
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    public void postResultReturnCorrect() throws Exception {
        genericParametrizedTest(true);
    }

    @Test
    public void postResultReturnNotCorrect() throws Exception {
        genericParametrizedTest(false);
    }

    private void genericParametrizedTest(final boolean correct) throws  Exception  {
        //given
        given(multiplicationService.checkAttempt(any(MultiplicationResultAttempt.class)))
                .willReturn(correct);
        User user = new User("AYADI");
        Multiplication multiplication = new Multiplication(50, 70);
        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3500);
        
        //when 
        MockHttpServletResponse response = mvc.perform(post("/results").contentType(MediaType.APPLICATION_JSON).content(jsonResult.write(attempt).getJson())).andReturn().getResponse();
        
        // then 
        
        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        Assertions.assertThat(response.getContentAsString()).isEqualTo(jsonResponse.write(Collections.singletonMap("Result", correct)).getJson());
        
        
    }
}
