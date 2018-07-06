package com.isil.inventario.entities;

import java.util.ArrayList;

public class Product {
    private String nameProduct;
    private int stockProduct;
    private double priceProduct;
    private ArrayList<Empresa> empresas;

    //Encapsulamiento

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getStockProduct() {
        return stockProduct;
    }

    public void setStockProduct(int stockProduct) {
        this.stockProduct = stockProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public ArrayList<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(ArrayList<Empresa> empresas) {
        this.empresas = empresas;
    }

    //CONSTRUCTOR

    public Product(String nameProduct, int stockProduct, double priceProduct, ArrayList<Empresa> empresas) {
        this.nameProduct = nameProduct;
        this.stockProduct = stockProduct;
        this.priceProduct = priceProduct;
        this.empresas = empresas;
    }
}
