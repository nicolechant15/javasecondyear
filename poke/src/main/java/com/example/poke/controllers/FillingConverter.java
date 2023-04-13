package com.example.poke.controllers;


import com.example.poke.models.Filling;
import com.example.poke.models.Filling.Type;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.HashMap;


@Component
public class FillingConverter implements Converter<String, Filling>{

    private final Map<String, Filling> fillingMap = new HashMap<>();

    public FillingConverter() {
        fillingMap.put("Rice", new Filling("Rice", "Rice", Type.Base));
        fillingMap.put("Quinoa", new Filling("Quinoa", "Quinoa", Type.Base));
        fillingMap.put("Sal", new Filling("Sal", "Salmon", Type.Stuffing));
        fillingMap.put("Tuna", new Filling("Tuna", "Tuna", Type.Stuffing));
        fillingMap.put("Tofu", new Filling("Tofu", "Tofu", Type.Stuffing));
        fillingMap.put("Oran", new Filling("Oran", "Orange", Type.Stuffing));
        fillingMap.put("Cucu", new Filling("Cucu", "Cucumber", Type.Stuffing));
        fillingMap.put("Avoc", new Filling("Avoc", "Avocado", Type.Stuffing));
        fillingMap.put("Ging", new Filling("Ging", "Ginger", Type.Stuffing));
        fillingMap.put("Rad", new Filling("Rad", "Radish", Type.Stuffing));
        fillingMap.put("Edam", new Filling("Edam", "Edamame", Type.Stuffing));
    }

    @Override
    public Filling convert(String id){
        return fillingMap.get(id);
    }

}

