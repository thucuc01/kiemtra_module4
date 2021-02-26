package com.codegym.demo.service.impl;

import com.codegym.demo.model.Country;
import com.codegym.demo.model.City;
import com.codegym.demo.repository.CityRepo;
import com.codegym.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CityServiceImpl implements CityService {

    @Autowired
    public CityRepo cityRepository;

    @Override
    public Page<City> findAll(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).get();
    }

    @Override
    public void save(City product) {
        cityRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public Iterable<City> findAllByCategory(Country category) {
        return cityRepository.findAllByCountry(category);
    }

    @Override
    public Page<City> findAllByNameContaining(String name, Pageable pageable) {
        return cityRepository.findAllByNameContaining(name,pageable);
    }
}
