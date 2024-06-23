package Proyectos;

import Bases.*;
import Proyectos.*;
import java.io.Serializable;

public class Auto implements Serializable{
    private float precio;
    private MarcaDeAuto marca;
    private Modelo modelo;
    private String tipo;
    private int año;
    private String placa;    
    private int kilometraje;
    private String motor;
    private String transmisión;
    private float peso;
    private String ubicacion;
    private String estado;
    private Usuario usuario;
    
    public Auto(float precio, MarcaDeAuto marca, Modelo modelo, String tipo, int año, String placa, int kilometraje, String motor, String transmisión, float peso, String ubicacion, Usuario usuario, String estado){
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
        this.estado = estado;
        this.placa = placa;
    }

    public float getPrecio() {
        return precio;
    }

    public MarcaDeAuto getMarca() {
        return marca;
    }

    public Modelo getModelo() {
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

    public String getEstado() {
        return estado;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setMarca(MarcaDeAuto marca) {
        this.marca = marca;
    }

    public void setModelo(Modelo modelo) {
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

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
