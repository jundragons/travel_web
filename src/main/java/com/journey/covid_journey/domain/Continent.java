package com.journey.covid_journey.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Continent {

    @Id @GeneratedValue
    @Column(name = "continent_id")
    private Long id;

    @Column(name = "continent_name")
    private String name;
}
