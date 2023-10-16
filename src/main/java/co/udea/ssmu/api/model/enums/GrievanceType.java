package co.udea.ssmu.api.model.enums;

public enum GrievanceType {
    SancionesInjustas("Sanciones Injustas"),
    ProblemasDeFacturacion("Problemas de Facturación"),
    Otros("Otros");

    private String description;

    GrievanceType(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }

}
