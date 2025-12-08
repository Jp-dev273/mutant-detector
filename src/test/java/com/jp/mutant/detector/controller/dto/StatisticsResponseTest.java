package com.jp.mutant.detector.controller.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsResponseTest {

    private StatisticsResponse statisticsResponse;

    @BeforeEach
    void setUp(){
        statisticsResponse = new StatisticsResponse();
    }

    @Test
    @DisplayName("Given -1 human dna count Should return 0 human dna count")
    void setNegativeHumanDnaCount(){
        statisticsResponse.setCountHumanDna(-1);
        assertThat(statisticsResponse.getCount_human_dna()).isEqualTo(0);
    }

    @Test
    @DisplayName("Given -1 mutant dna count Should return 0 mutant dna count")
    void setNegativeMutantDnaCount() {
        statisticsResponse.setCountMutantDna(-1);
        assertThat(statisticsResponse.getCount_mutant_dna()).isEqualTo(0);
    }

    @Test
    @DisplayName("Given 0 human dna Should return mutant dna as ratio")
    void setRatioWhenTheresNotHumanDna() {
        statisticsResponse.setCountHumanDna(0);
        int countMutantDna = 100;
        statisticsResponse.setCountMutantDna(countMutantDna);
        statisticsResponse.setRatio();
        assertThat(statisticsResponse.getRatio()).isEqualTo(countMutantDna);
    }

    @Test
    @DisplayName("Given 0 mutant dna Should return 0")
    void setRatioWhenTheresNotMutantDna() {
        statisticsResponse.setCountHumanDna(100);
        int countMutantDna = 0;
        statisticsResponse.setCountMutantDna(countMutantDna);
        statisticsResponse.setRatio();
        assertThat(statisticsResponse.getRatio()).isEqualTo(countMutantDna);
    }

}