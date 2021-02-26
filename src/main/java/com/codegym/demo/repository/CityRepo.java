package com.codegym.demo.repository;

import com.codegym.demo.model.Country;
import com.codegym.demo.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepo extends PagingAndSortingRepository<City,Long> {

    Iterable<City> findAllByCountry(Country country);

    Page<City> findAllByNameContaining(String name, Pageable pageable);
}
