package com.codegym.demo;

import com.codegym.demo.service.CountryService;
import com.codegym.demo.service.CityService;
import com.codegym.demo.service.impl.CountryServiceImp;
import com.codegym.demo.service.impl.CityServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CityService cityService(){
        return new CityServiceImpl();
    }

    @Bean
    public CountryService countryService(){
        return new CountryServiceImp();
    }


}
