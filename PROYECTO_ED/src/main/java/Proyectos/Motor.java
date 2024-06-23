/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyectos;

/**
 *
 * @author Kathy
 */
public enum Motor {
    GASOLINA("Gasolina"),
    DIESEL("Diésel"),
    ELÉCTRICO("Eléctrico"),
    HÍBRIDO("Híbrido"),
    GAS("Gas");
    
    private final String displayName;

    Motor(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
