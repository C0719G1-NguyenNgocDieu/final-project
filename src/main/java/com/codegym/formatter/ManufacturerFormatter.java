package com.codegym.formatter;

import com.codegym.model.Manufacturer;
import com.codegym.repository.ManufacturerRepository;
import com.codegym.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class ManufacturerFormatter implements Formatter<Manufacturer> {
    private ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerFormatter(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @Override
    public Manufacturer parse(String text, Locale locale) throws ParseException {
        return manufacturerService.findById(Long.valueOf(text));
    }

    @Override
    public String print(Manufacturer object, Locale locale) {
        return object.toString();
    }
}
