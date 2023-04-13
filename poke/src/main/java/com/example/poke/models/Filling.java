package com.example.poke.models;


import lombok.Data;

@Data
public class Filling{
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        Base,
        Stuffing
    }
}
