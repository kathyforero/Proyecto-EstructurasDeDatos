package Proyectos;

public enum Tipo {
    SEDÁN("Sedán"),
    COUPÉ("Coupé"),
    CONVERTIBLE("Convertible"),
    HATCHBACK("Hatchback"),
    SUV("SUV"),
    PICK_UP("Pick Up"),
    HÍBRIDO("Híbrido");
    
    private final String displayName;

    Tipo(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
