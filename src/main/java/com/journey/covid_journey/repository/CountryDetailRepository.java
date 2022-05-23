package com.journey.covid_journey.repository;

import com.journey.covid_journey.domain.CountryDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryDetailRepository extends JpaRepository<CountryDetail, Long> {
}
