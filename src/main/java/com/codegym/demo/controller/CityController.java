package com.codegym.demo.controller;

import com.codegym.demo.model.Country;
import com.codegym.demo.model.City;
import com.codegym.demo.service.CountryService;
import com.codegym.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CityController {
    @Autowired
    private CountryService countryService;

    @Autowired
    public CityService cityService;

    @ModelAttribute("countries")
    public Iterable<Country> countries(){
        return countryService.findAll();
    }

    @RequestMapping
    public String testLayout(){
        return "layout";
    }

    @GetMapping("/home")
    public ModelAndView showHome(@RequestParam("s") Optional<String> s,
                                 @RequestParam("s1") Optional<String> s1,
                                 @RequestParam("page") Optional<Integer> page,
                                 Pageable pageable){
        Page<City> citys;
        int pageNum = 0;
        if (page.isPresent() && page.get() > 1) {
            pageNum = page.get() - 1;
        }
        Sort sort = Sort.by("name");
        if(s.isPresent()){
            pageable = PageRequest.of(pageNum, 10);
            citys = cityService.findAllByNameContaining(s.get(), pageable);
        } else {
            if(s1.isPresent()){
                pageable = PageRequest.of(pageNum, 10, sort);
                citys= cityService.findAll(pageable);
            }else {
                pageable = PageRequest.of(pageNum, 10);
                citys = cityService.findAll(pageable);
            }
        }
        System.out.println();
        ModelAndView modelAndView = new ModelAndView("city/home");
        modelAndView.addObject("citys", citys);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createCityForm(){
        ModelAndView modelAndView=new ModelAndView("city/create","city",new City());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCity(@Valid @ModelAttribute("city") City city, BindingResult bindingResult, Pageable pageable){

        ModelAndView modelAndView;


        if(bindingResult.hasFieldErrors()){
            modelAndView=new ModelAndView("city/create");
            return modelAndView;
        }
        cityService.save(city);
        modelAndView=new ModelAndView("city/create");
        modelAndView.addObject("city",new City());
        modelAndView.addObject("message","New city created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable ("id") Long id){
        ModelAndView modelAndView=new ModelAndView("city/edit");
        City city= cityService.findById(id);
        modelAndView.addObject("city",city);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editCity(@Valid @ModelAttribute("city") City city, BindingResult bindingResult){
        ModelAndView modelAndView;
        if(bindingResult.hasFieldErrors()){
            modelAndView=new ModelAndView("city/edit");
            return modelAndView;
        }
        cityService.save(city);
        modelAndView=new ModelAndView("city/edit");
        modelAndView.addObject("city",new City());
        modelAndView.addObject("message"," City editted successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteCity(@PathVariable("id") Long id){
        cityService.remove(id);
        return "redirect:/home";
    }

    @GetMapping("/info/{id}")
    public ModelAndView infoCity(@PathVariable("id") Long id){
        ModelAndView modelAndView=new ModelAndView("city/info");
        City city= cityService.findById(id);
        modelAndView.addObject("city",city);
        return modelAndView;
    }






}
