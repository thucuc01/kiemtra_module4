package com.codegym.demo.service;

import com.codegym.demo.model.Country;
import com.codegym.demo.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService {
    Page<City> findAll(Pageable pageable);

    Iterable<City> findAll();

    City findById(Long id);

    void save(City product);

    void remove(Long id);

    Iterable<City> findAllByCategory(Country country);

    Page<City> findAllByNameContaining(String name, Pageable pageable);


}
