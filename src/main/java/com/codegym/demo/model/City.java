package com.codegym.demo.model;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;
    @NumberFormat
    @Min(1)
    private double aria;
    @NumberFormat
    @Min(1)
    private int population;
    @NumberFormat
    @Min(1)
    private double gdp;
    @NotEmpty
    private String desv;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public City() {
    }

    public City(Long id,String name,double aria,  int population, double gdp,  String desv, Country country) {
        this.id = id;
        this.name = name;
        this.aria = aria;
        this.population = population;
        this.gdp = gdp;
        this.desv = desv;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAria() {
        return aria;
    }

    public void setAria(double aria) {
        this.aria = aria;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getGdp() {
        return gdp;
    }

    public void setGdp(double gdp) {
        this.gdp = gdp;
    }

    public String getDesv() {
        return desv;
    }

    public void setDesv(String desv) {
        this.desv = desv;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
