package com.codegym.formatter;

import com.codegym.model.Manufacturer;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class ManufacturerFormatter implements Formatter<Manufacturer> {
    private

    @Override
    public Manufacturer parse(String text, Locale locale) throws ParseException {
        return null;
    }

    @Override
    public String print(Manufacturer object, Locale locale) {
        return null;
    }
}
