package com.journey.covid_journey.service;

import com.journey.covid_journey.domain.CountryDetail;
import com.journey.covid_journey.repository.CountryDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryDetailService {

    private CountryDetailRepository detailRepository;

    public Long makeDetail(CountryDetail countryDetail){
        detailRepository.save(countryDetail);
        return countryDetail.getId();
    }
}
