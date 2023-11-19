package co.udea.ssmu.api.model.enums;

public enum ComplainType {

    MAL_COMPORTAMIENTO_DEL_CONDUCTOR("Mal comportamiento del conductor"),
    ESTADO_DEL_VEHICULO("Estado del vehiculo"),
    COBRO_INADECUADO("Cobro inadecuado"),
    CONDUCCION_PELIGROSA("Conduccion peligrosa"),
    SITUACIONES_ANOMALAS_CON_PASAJEROS("Situaciones anomalas con pasajeros"),
    OTROS("Otros");

    public final String description;

    ComplainType(String description) {
        this.description = description;
    }
    String description() {
        return this.description;
    }

}
