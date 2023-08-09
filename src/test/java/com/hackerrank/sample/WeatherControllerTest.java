package com.hackerrank.sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerrank.sample.model.Weather;
import com.hackerrank.sample.resquest.WeatherRequest;
import com.hackerrank.sample.service.WeatherService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class WeatherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private WeatherService mock;

    LocalDateTime date = LocalDateTime.of(2021,12,25,11,30);

    WeatherRequest weatherRequest = WeatherRequest.builder()
            .location("Lisbon")
            .temperature(20.00)
            .date(date)
            .build();

    Weather weatherParam = Weather.builder()
            .location("Lisbon")
            .temperature(20.00)
            .date(date)
            .build();

    Weather weatherSaved = Weather.builder()
            .id(1)
            .location("Lisbon")
            .temperature(20.00)
            .date(date)
            .build();

    Weather weatherSaved1 = Weather.builder()
            .id(2)
            .location("London")
            .temperature(30.00)
            .date(date)
            .build();

    @Before
    public void setup() {

    }

    @Test
    public void shouldInsertWeather() throws Exception {
        BDDMockito.given(mock.insert(weatherParam)).willReturn(Optional.of(weatherSaved));

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/weather")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(weatherRequest));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").isNotEmpty());
    }

    @Test
    public void shouldReturnListWeather() throws Exception {
        BDDMockito.given(mock.findOrderById()).willReturn(Optional.of(Arrays.asList(weatherSaved, weatherSaved1)));

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/weather")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }
}
