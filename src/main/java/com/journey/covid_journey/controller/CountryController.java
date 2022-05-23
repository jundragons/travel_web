package com.journey.covid_journey.controller;

import com.journey.covid_journey.domain.Country;
import com.journey.covid_journey.domain.CountryDetail;
import com.journey.covid_journey.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/")
    public String countryList(Model model){
        List<Country> countries = countryService.getCountryList();
        model.addAttribute("countries",countries);
        return "list";
    }

    @GetMapping("/country/{id}")
    public String countryDetail(@PathVariable Long id,Model model){

        List<CountryDetail> detailList = countryService.getDetailList(id);
        model.addAttribute("details",detailList);
        return "listDetailModal";
    }
}
