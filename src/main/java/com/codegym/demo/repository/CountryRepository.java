package com.codegym.demo.repository;

import com.codegym.demo.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CountryRepository extends PagingAndSortingRepository<Country,Long> {
}
