package com.codegym.demo.service.impl;

import com.codegym.demo.model.Country;
import com.codegym.demo.repository.CountryRepository;
import com.codegym.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryServiceImp implements CountryService {
    @Autowired
    public CountryRepository countryRepository;

    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id).get();
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void remove(Long id) {
        countryRepository.deleteById(id);
    }
}
