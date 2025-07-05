package com.cognizant.orm_learn.Service;

import com.cognizant.orm_learn.Model.Country;
import com.cognizant.orm_learn.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    public final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository){
        this.countryRepository=countryRepository;
    }

    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }


}
