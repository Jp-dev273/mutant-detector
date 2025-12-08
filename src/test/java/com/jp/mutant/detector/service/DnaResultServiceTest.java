package com.jp.mutant.detector.service;

import com.jp.mutant.detector.controller.dto.DnaRequest;
import com.jp.mutant.detector.model.DnaRaze;
import com.jp.mutant.detector.repository.DnaResultRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DnaResultServiceTest {

    private DnaService dnaService;

    @Mock
    private DnaResultRepository dnaResultRepository;

    @BeforeEach
    void setUp(){
        this.dnaService = new DnaService(dnaResultRepository);
    }

    @Test
    @DisplayName("Given mutant dna Should return true")
    void saveMutant(){
        String[] mutantDna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

        DnaRequest dnaRequest = new DnaRequest();
        dnaRequest.dna = mutantDna;

        DnaRaze raze = dnaService.saveDna(dnaRequest);

        assertThat(raze).isSameAs(DnaRaze.MUTANT);

    }

    @Test
    @DisplayName("Given human dna Should return false")
    void saveHuman() {
        String[] humanDna = {"ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG" };

        DnaRequest dnaRequest = new DnaRequest();
        dnaRequest.dna = humanDna;

        DnaRaze raze = dnaService.saveDna(dnaRequest);

        assertThat(raze).isSameAs(DnaRaze.HUMAN);
    }
}