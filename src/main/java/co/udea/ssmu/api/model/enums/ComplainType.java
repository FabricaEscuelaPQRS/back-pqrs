package co.udea.ssmu.api.model.enums;

public enum ComplainType {

    MalComportamientoDelConductor("Mal comportamiento del conductor"),
    EstadoDelVehiculo("Estado del vehiculo"),
    CobroInadecuado("Cobro inadecuado"),
    ConduccionPeligrosa("Conduccion peligrosa"),
    SituacionesAnomalasConPasajeros("Situaciones anomalas con pasajeros"),
    Otros("Otros");

    public final String description;

    ComplainType(String description) {
        this.description = description;
    }
    String description() {
        return this.description;
    }

}
