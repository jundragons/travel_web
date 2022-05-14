package com.journey.covid_journey.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Info {

    @Id @GeneratedValue
    @Column(name = "info_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    private Boolean vaccinated;

    private Boolean travelOk;

    private String covidTesting;

    private String selfDistance;

    private String visa;


}
