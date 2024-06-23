/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyectos;

/**
 *
 * @author Kathy
 */
public enum Transmision {
    MANUAL("Manual"),
    AUTOMÁTICA("Automática"),
    CVT("Continuamente Variable"),
    DSG("Doble Embrague"),
    AMT("Manual Automatizada"),
    MANUAL_SECUENCIAL("Manual Secuencial"),
    EVT("Electrónica Variable"),
    HIDRÁULICA("Hidráulica");
    
    private final String displayName;

    Transmision(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
