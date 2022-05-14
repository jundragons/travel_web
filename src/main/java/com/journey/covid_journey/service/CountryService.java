package com.journey.covid_journey.service;

import com.journey.covid_journey.repository.CountryRepository;
import com.journey.covid_journey.domain.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public List<Country> getList(){
        return countryRepository.findAll();
    }

    @Transactional
    public Long join(Country country){
        countryRepository.save(country);
        return country.getId();
    }
}
