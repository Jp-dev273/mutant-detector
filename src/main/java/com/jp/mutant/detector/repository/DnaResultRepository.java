package com.jp.mutant.detector.repository;

import com.jp.mutant.detector.model.DnaResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface DnaResultRepository extends JpaRepository<DnaResult, UUID> {
    @Query("""
    SELECT
        SUM(CASE WHEN d.raze = 'mutant' THEN 1 ELSE 0 END) AS mutantCount,
        SUM(CASE WHEN d.raze = 'human' THEN 1 ELSE 0 END) AS humanCount
    FROM DnaResult d
    """)
    Object[] getMutantAndHumanCount();
}
