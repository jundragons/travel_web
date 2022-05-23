package com.journey.covid_journey.service;

import com.journey.covid_journey.domain.Country;
import com.journey.covid_journey.domain.CountryDetail;
import com.journey.covid_journey.repository.CountryDetailRepository;
import com.journey.covid_journey.repository.CountryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CountryDetailServiceTest {

    @Autowired
    private CountryDetailRepository detailRepository;
    @Autowired
    private CountryRepository countryRepository;

    @Test
    void 디테일_생성(){
        Country country = countryRepository.findByCountryName("미국").get(0);
        CountryDetail countryDetail = new CountryDetail();
        countryDetail.setCountry(country);
        countryDetail.setVaccinated(true);
        countryDetail.setCovidTesting("입국 전 24시간 이내 코로나 PCR 또는 항원 검사 필요");
        countryDetail.setTravelOk(true);
        countryDetail.setSelfDistance("격리 없음");
        countryDetail.setVisa("ESTA 필요");

        detailRepository.save(countryDetail);
        Optional<CountryDetail> detail = detailRepository.findById(countryDetail.getId());

        assertEquals(countryDetail.getId(),detail.get().getId());
    }
}