package com.jp.mutant.detector.service;

import com.jp.mutant.detector.repository.DnaResultRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class StatisticsServiceTest {

    @Autowired
    private StatisticsService statisticsService;

    @MockitoBean
    private DnaResultRepository dnaResultRepository;

    @Test
    void getStatistics() {

        Object[] result = new Object[2];
        result[0] = 30;
        result[1] = 100;
        when(dnaResultRepository.getMutantAndHumanCount()).thenReturn(result);

        assertThat(
                statisticsService.getStatistics()
        ).isEqualTo(result);
    }
}