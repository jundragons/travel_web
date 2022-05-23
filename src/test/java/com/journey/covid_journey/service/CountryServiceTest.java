package com.journey.covid_journey.service;

import com.journey.covid_journey.domain.Country;
import com.journey.covid_journey.domain.CountryDetail;
import com.journey.covid_journey.repository.CountryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CountryServiceTest {

    @Autowired CountryService countryService;
    @Autowired
    CountryRepository countryRepository;
    @Test
    void 국가생성(){
        Country c1 = new Country();
        c1.setCountryName("한국");
        countryRepository.save(c1);
        Country country = countryRepository.findById(c1.getId()).orElseThrow(()->new IllegalArgumentException());
        assertEquals(c1.getId(),country.getId());
    }


    @Test
    void 전체국가조회(){
        Country c1 = new Country();
        c1.setCountryName("일본");
        countryRepository.save(c1);
        Country c2 = new Country();
        c2.setCountryName("중국");
        countryRepository.save(c2);

        List<Country> list = countryService.getCountryList();
        assertEquals(2,list.size());

    }

    @Test
    void 삭제(){
        Country c2 = new Country();
        c2.setCountryName("미국");
        countryRepository.save(c2);
    }

}