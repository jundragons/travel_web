package com.journey.covid_journey.repository;

import com.journey.covid_journey.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findByCountryName(String countryName);
}
