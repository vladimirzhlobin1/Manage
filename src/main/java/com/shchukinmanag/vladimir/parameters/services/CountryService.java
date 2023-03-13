package com.shchukinmanag.vladimir.parameters.services;

import com.shchukinmanag.vladimir.parameters.models.Country;
import com.shchukinmanag.vladimir.parameters.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    public List<Country> getAll(){
        return countryRepository.findAll();
    }
    public void save(Country country){
        countryRepository.save(country);
    }

    public void delete (Integer id){
        countryRepository.deleteById(id);
    }

    public Country getById(Integer id) {
       return countryRepository.findById(id).orElse(null);
    }
}
