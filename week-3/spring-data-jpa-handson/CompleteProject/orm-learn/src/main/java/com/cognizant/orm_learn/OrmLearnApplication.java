package com.cognizant.orm_learn;

import com.cognizant.orm_learn.Exception.CountryNotFoundException;
import com.cognizant.orm_learn.Model.Country;
import com.cognizant.orm_learn.Service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);

		getAllCountriesTest();
		addCountryTest();
		findCountryByCodeTest();
		updateCountryTest();
		deleteCountryTest();
	}

	private static void getAllCountriesTest() {
		LOGGER.info("Start: getAllCountriesTest");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("Countries: {}", countries);
		LOGGER.info("End: getAllCountriesTest");
	}

	private static void addCountryTest() {
		LOGGER.info("Start: addCountryTest");
		Country newCountry = new Country();
		newCountry.setCode("JP");
		newCountry.setName("Japan");
		countryService.addCountry(newCountry);
		LOGGER.debug("Added Country: {}", newCountry);
		LOGGER.info("End: addCountryTest");
	}

	private static void findCountryByCodeTest() {
		LOGGER.info("Start: findCountryByCodeTest");
		try {
			Country country = countryService.findCountryByCode("JP");
			LOGGER.debug("Found Country: {}", country);
		} catch (CountryNotFoundException e) {
			LOGGER.warn("Exception: {}", e.getMessage());
		}
		LOGGER.info("End: findCountryByCodeTest");
	}

	private static void updateCountryTest() {
		LOGGER.info("Start: updateCountryTest");
		try {
			Country updatedCountry = countryService.updateCountry("JP", "Nippon");
			LOGGER.debug("Updated Country: {}", updatedCountry);
		} catch (CountryNotFoundException e) {
			LOGGER.warn("Exception: {}", e.getMessage());
		}
		LOGGER.info("End: updateCountryTest");
	}

	private static void deleteCountryTest() {
		LOGGER.info("Start: deleteCountryTest");
		try {
			countryService.deleteCountry("JP");
			LOGGER.debug("Deleted Country with code JP");
		} catch (CountryNotFoundException e) {
			LOGGER.warn("Exception: {}", e.getMessage());
		}
		LOGGER.info("End: deleteCountryTest");
	}
}