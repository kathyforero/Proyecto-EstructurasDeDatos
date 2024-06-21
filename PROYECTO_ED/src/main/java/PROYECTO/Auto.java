/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROYECTO;

/**
 *
 * @author Kathy
 */
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
    
    public Auto(float precio, String marca, String modelo, String tipo, int año, int kilometraje, String motor, String transmisión, float peso, String ubicacion){
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
    }
    
}
