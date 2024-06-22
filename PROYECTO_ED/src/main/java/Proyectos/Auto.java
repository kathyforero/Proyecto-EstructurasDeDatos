package Proyectos;

import Bases.*;
import Proyectos.*;

public class Auto {
    private float precio;
    private String marca;
    private String modelo;
    private String tipo;
    private int año;
    private int kilometraje;
    private String motor;
    private String transmisión;
    private float peso;
    private String ubicacion;
    private Usuario usuario;
    
    public Auto(float precio, String marca, String modelo, String tipo, int año, int kilometraje, String motor, String transmisión, float peso, String ubicacion, Usuario usuario){
        this.precio = precio;
        this.marca = marca;
        this.modelo = modelo;        
        this.tipo = tipo;
        this.año = año;
        this.kilometraje = kilometraje;
        this.motor = motor;
        this.transmisión = transmisión;        
        this.peso = peso;
        this.ubicacion = ubicacion;
        this.usuario = usuario;
    }

    public float getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public int getAño() {
        return año;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public String getMotor() {
        return motor;
    }

    public String getTransmisión() {
        return transmisión;
    }

    public float getPeso() {
        return peso;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public void setTransmisión(String transmisión) {
        this.transmisión = transmisión;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }        
    
}
