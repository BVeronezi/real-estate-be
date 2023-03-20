package com.brunsker.realestatebackend.utils;

public enum Type {

    PURCHASE("Comprar"),
    RENT("Alugar");
    private final String displayName;

    Type(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}