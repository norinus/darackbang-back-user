package com.lab.darackbang.repository;

import com.lab.darackbang.entity.AgeYearStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgeYearStatRepository extends JpaRepository<AgeYearStat, Long> ,
        JpaSpecificationExecutor<AgeYearStat> {

    Optional<AgeYearStat> findByAgeGroupAndYear(String ageGroup, String year);
}