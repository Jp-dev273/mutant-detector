package com.jp.mutant.detector.service;

import com.jp.mutant.detector.repository.DnaResultRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StatisticsServiceTest {

    private StatisticsService statisticsService;

    @Mock
    private DnaResultRepository dnaResultRepository;

    @BeforeEach
    void setUp(){
        statisticsService = new StatisticsService(dnaResultRepository);
    }

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