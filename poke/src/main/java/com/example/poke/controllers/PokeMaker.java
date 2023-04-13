package com.example.poke.controllers;

import com.example.poke.models.PokeName;
import com.example.poke.models.PokeOrder;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import com.example.poke.models.Filling;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.poke.models.Filling.Type;

@Slf4j
@Controller
@SessionAttributes("PokeOrder")
@RequestMapping("/maker")
public class PokeMaker {

    @ModelAttribute
    public void addFillingsToModel(Model model){
        List<Filling> fillings = Arrays.asList(
                new Filling("Rice", "Rice", Type.Base),
                new Filling("Quinoa", "Quinoa", Type.Base),
                new Filling("Sal", "Salmon", Type.Stuffing),
                new Filling("Tuna", "Tuna", Type.Stuffing),
                new Filling("Tofu", "Tofu", Type.Stuffing),
                new Filling("Oran", "Orange", Type.Stuffing),
                new Filling("Cucu", "Cucumber", Type.Stuffing),
                new Filling("Avoc", "Avocado", Type.Stuffing),
                new Filling("Ging", "Ginger", Type.Stuffing),
                new Filling("Rad", "Radish", Type.Stuffing),
                new Filling("Edam", "Edamame", Type.Stuffing)

        );
        Type[] types = Filling.Type.values();
        for(Type type: types){
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(fillings, type));
        }
    }

    @ModelAttribute(name="PokeOrder")
    public PokeOrder pokeorder(){
        return new PokeOrder();
    }

    @ModelAttribute(name="poke")
    public PokeName pokename(){
        return new PokeName();
    }

    private Iterable<Filling> filterByType(
            List<Filling> fillings, Type type
    ){
        return fillings.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processPoke(
            @Valid PokeName pokename, Errors errors, @ModelAttribute PokeOrder PokeOrder
    ){
        if (errors.hasErrors()){
            return "maker";
        }
        PokeOrder.addPoke(pokename);
        log.info("Processing poke: {}", pokename);
        return "redirect:/orders/current";
    }

    @GetMapping
    public String showMakerForm(){
        return "maker";
    }
}