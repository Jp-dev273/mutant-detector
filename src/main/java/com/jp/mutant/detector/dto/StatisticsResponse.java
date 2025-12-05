package com.jp.mutant.detector.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class StatisticsResponse {
    private int count_mutant_dna;
    private int count_human_dna;
    @Setter(AccessLevel.NONE)
    private double ratio;

    public void setCountHumanDna(int countHumanDna) {
        this.count_human_dna = Math.max(countHumanDna, 0);
    }

    public void setCountMutantDna(int countMutantDna){
        this.count_mutant_dna = Math.max(countMutantDna, 0);
    }

    public void setRatio(){
        if (count_human_dna<=0){
            this.ratio = count_mutant_dna;
        } else {
            this.ratio = (double) count_mutant_dna / count_human_dna;
        }

    }
}
