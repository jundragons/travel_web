package com.journey.covid_journey.controller;

import com.journey.covid_journey.domain.Country;
import com.journey.covid_journey.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/")
    public String countryList(Model model){
        List<Country> countries = countryService.getList();
        model.addAttribute("countries",countries);
        return "list";
    }
}
