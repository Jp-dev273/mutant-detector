package com.jp.mutant.detector.controller;

import com.jp.mutant.detector.dto.StatisticsResponse;
import com.jp.mutant.detector.service.StatisticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatisticsController {

    private final StatisticsService statisticsService;
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }
    @GetMapping
    public ResponseEntity<StatisticsResponse> getStatistics(){

        Object[] statistics = this.statisticsService.getStatistics();

        StatisticsResponse response = new StatisticsResponse();
        response.setCountMutantDna((Integer) statistics[0]);
        response.setCountHumanDna((Integer) statistics[1]);
        response.setRatio();

        return ResponseEntity.ok(response);
    }
}
