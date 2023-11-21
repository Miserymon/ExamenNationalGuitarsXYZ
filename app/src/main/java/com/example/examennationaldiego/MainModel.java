package com.example.examennationaldiego;

public class MainModel {
    String Marca, Modelo, imgURL, Precio;

    public MainModel() {
    }

    public MainModel(String marca, String modelo, String imgURL, String precio) {
        Marca = marca;
        Modelo = modelo;
        this.imgURL = imgURL;
        Precio = precio;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }
}
