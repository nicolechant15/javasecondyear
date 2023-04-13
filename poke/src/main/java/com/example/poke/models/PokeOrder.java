package com.example.poke.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PokeOrder {

    @NotBlank(message = "Улица доставки обязательна для заполнения")
    private String deliveryStreet;

    @NotBlank(message = "Необходимо заполнить город доставки")
    private String deliveryCity;

    @CreditCardNumber
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Неверный CVV")
    private String ccCVV;

    private List<PokeName> tacos = new ArrayList<>();

    public void addPoke(PokeName pokename){
        this.tacos.add(pokename);
    }
}
