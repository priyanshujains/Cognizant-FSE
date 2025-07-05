package com.cognizant.orm_learn.Service;



import com.cognizant.orm_learn.Exception.CountryNotFoundException;
import com.cognizant.orm_learn.Model.Country;
import com.cognizant.orm_learn.Repository.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CountryService {

    public final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository){
        this.countryRepository=countryRepository;
    }

    public List<Country> getAllCountries(){
        return countryRepository.findAll();

    }


    @Transactional
    public Country findCountryByCode(String countryCode)throws CountryNotFoundException{

        Optional<Country> result = countryRepository.findById(countryCode);
        if (result.isEmpty())throw new CountryNotFoundException("Country doesnot exist");

        Country country = result.get();
        return country;
    }


    @Transactional
    public void addCountry(Country country){
        countryRepository.save(country);
    }


    @Transactional
    public  Country updateCountry(String code, String name)throws CountryNotFoundException{
        Optional<Country> result = countryRepository.findById(code);
        if (result.isEmpty())throw new CountryNotFoundException("Country doesnot exist");

        Country country = result.get();
        country.setName(name);

        return countryRepository.save(country);


    }


    @Transactional
    public  void deleteCountry(String code) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(code);
        if (result.isEmpty())throw new CountryNotFoundException("Country doesnot exist");

        countryRepository.deleteById(code);
    }

}
