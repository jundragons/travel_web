package com.journey.covid_journey.service;

import com.journey.covid_journey.domain.CountryDetail;
import com.journey.covid_journey.repository.CountryDetailRepository;
import com.journey.covid_journey.repository.CountryRepository;
import com.journey.covid_journey.domain.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryDetailRepository detailRepository;

    public Long createDetail(CountryDetail countryDetail){
        detailRepository.save(countryDetail);
        return countryDetail.getId();
    }

    public List<Country> getCountryList(){
        return countryRepository.findAll();
    }

    @Transactional
    public List<CountryDetail> getDetailList(Long id){
        Optional<Country> optionalCountry = countryRepository.findById(id);
        Country country = optionalCountry.get();
        country.viewCount();
        List<CountryDetail> detailList = country.getInfoList();
        return detailList;
    }

    @Transactional
    public Long join(Country country){
        countryRepository.save(country);
        return country.getId();
    }

}
