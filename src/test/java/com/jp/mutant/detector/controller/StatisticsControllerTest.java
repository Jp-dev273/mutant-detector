package com.jp.mutant.detector.controller;

import com.jp.mutant.detector.service.StatisticsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StatisticsController.class)
class StatisticsControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private StatisticsService statisticsService;

    @Test
    @DisplayName("Should return count_mutant_dna with 40 and Should return count_human_dna with 100 and Should return ratio with 0.4")
    void getStatistics() throws Exception {

        Object[] result = new Object[2];
        result[0] = 40;
        result[1] = 100;
        when(statisticsService.getStatistics()).thenReturn(result);

        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/stats")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.count_mutant_dna").value(40))
                .andExpect(jsonPath("$.count_human_dna").value(100))
                .andExpect(jsonPath("$.ratio").value(0.4));
    }
}