package com.isil.inventario.entities;

public enum Categoria {

    ENUM1("Ropa"),
    ENUM2("Abarrotes"),
    ENUM3("Tecnologia"),
    ENUM4("Bebidas"),
    ENUM5("Hogar");

    private String categoriaNombre;

    private Categoria(String categoriaNombre){
        this.categoriaNombre = categoriaNombre;
    }

    @Override public String toString(){
        return categoriaNombre;
    }

}
