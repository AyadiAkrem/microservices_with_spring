package com.itdeep.micorservices.socialmathematics.multiplication.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itdeep.micorservices.socialmathematics.multiplication.domain.Multiplication;
import com.itdeep.micorservices.socialmathematics.multiplication.domain.MultiplicationResultAttempt;
import com.itdeep.micorservices.socialmathematics.multiplication.domain.User;
import com.itdeep.micorservices.socialmathematics.multiplication.service.MultiplicationService;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

    // These objects will be magically initialized by the
    private JacksonTester<MultiplicationResultAttempt> jsonResultAttempt;
    private JacksonTester<List<MultiplicationResultAttempt>> jsonResultAttemptList;

    @Before
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    public void postResultReturnCorrect() throws Exception {
        genericParameterizedTest(true);
    }

    @Test
    public void postResultReturnNotCorrect() throws Exception {
        genericParameterizedTest(false);
    }

    void genericParameterizedTest(final boolean correct) throws Exception {
        // given (remember we're not testing here the service itself)
        given(multiplicationService
                .checkAttempt(any(MultiplicationResultAttempt.class)))
                .willReturn(correct);
        User user = new User("john");
        Multiplication multiplication = new Multiplication(50, 70);
        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(
                user, multiplication, 3500, correct);

        // when
        MockHttpServletResponse response = mvc.perform(
                post("/results").contentType(MediaType.APPLICATION_JSON)
                        .content(jsonResultAttempt.write(attempt).getJson()))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonResultAttempt.write(
                        new MultiplicationResultAttempt(attempt.getUser(),
                                attempt.getMultiplication(),
                                attempt.getResultAttempt(),
                                correct)
                ).getJson());
    }

    @Test
    public void getUserStats() throws Exception {
        // given
        User user = new User("john_doe");
        Multiplication multiplication = new Multiplication(50, 70);
        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(
                user, multiplication, 3500, true);
        List<MultiplicationResultAttempt> recentAttempts = Lists.newArrayList(attempt, attempt);
        given(multiplicationService
                .getStatsForUser("john_doe"))
                .willReturn(recentAttempts);

        // when
        MockHttpServletResponse response = mvc.perform(get("/results").param("alias", "john_doe"))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonResultAttemptList.write(
                        recentAttempts
                ).getJson());
    }
}
