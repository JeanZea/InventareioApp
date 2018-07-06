package com.isil.inventario.entities;

import java.util.ArrayList;

public class Empresa {
    private String nombreEmpresa;
    private String descripcionEmpresa;
    private Categoria categorias;
    private ArrayList<Product> products = new ArrayList<>();
    //ENCAPSULAMIENTO


    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDescripcionEmpresa() {
        return descripcionEmpresa;
    }

    public void setDescripcionEmpresa(String descripcionEmpresa) {
        this.descripcionEmpresa = descripcionEmpresa;
    }

    public Categoria getCategorias() {
        return categorias;
    }

    public void setCategorias(Categoria categorias) {
        this.categorias = categorias;
    }

    //CONSTRUCTOR

    public Empresa(String nombreEmpresa, String descripcionEmpresa, Categoria categorias){
        this.nombreEmpresa = nombreEmpresa;
        this.descripcionEmpresa = descripcionEmpresa;
        this.categorias = categorias;
    }
}
