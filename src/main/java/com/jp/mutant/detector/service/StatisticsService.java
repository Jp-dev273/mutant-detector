package com.jp.mutant.detector.service;

import com.jp.mutant.detector.repository.DnaResultRepository;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {
    private final DnaResultRepository dnaResultRepository;
    public StatisticsService(DnaResultRepository dnaResultRepository) {
        this.dnaResultRepository = dnaResultRepository;
    }

    public Object[] getStatistics() {
        return this.dnaResultRepository.getMutantAndHumanCount();
    }
}
