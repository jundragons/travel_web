package com.journey.covid_journey.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Country {

    @Id @GeneratedValue
    @Column(name = "country_id")
    private Long id;

    @Column(name = "country_name")
    private String countryName;

    private int viewCount;

    private int likeCount;

    private String maskInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "continent_id")
    private Continent continent;

    @OneToMany(mappedBy = "country")
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "country")
    private List<Info> infoList = new ArrayList<>();

    @OneToMany(mappedBy = "country")
    private List<Document> documentList = new ArrayList<>();

}
