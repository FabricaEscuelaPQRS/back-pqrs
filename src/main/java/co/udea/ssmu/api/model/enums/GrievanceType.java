package co.udea.ssmu.api.model.enums;

public enum GrievanceType {
    SancionesInjustas("Sanciones Injustas"),
    ProblemasDeFacturacion("Problemas de Facturación"),
    Otros("Otros");

    public final String description;

    GrievanceType(String description) {
        this.description = description;
    }

    String description() {
        return description;
    }

}
