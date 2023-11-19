package co.udea.ssmu.api.model.enums;

public enum GrievanceType {
    SANCIONES_INJUSTAS("Sanciones Injustas"),
    PROBLEMAS_DE_FACTURACION("Problemas de Facturacion"),
    OTROS("Otros");

    public final String description;

    GrievanceType(String description) {
        this.description = description;
    }

    String description() {
        return description;
    }

}
