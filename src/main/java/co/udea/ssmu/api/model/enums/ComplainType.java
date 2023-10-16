package co.udea.ssmu.api.model.enums;

public enum ComplainType {

    MalComportamientoDelConductor("Mal comportamiento del conductor"),
    EstadoDelVehiculo("Estado del vehículo"),
    CobroInadecuado("Cobro inadecuado"),
    ConduccionPeligrosa("Conducción peligrosa"),
    SituacionesAnomalasConPasajeros("Situaciones anómalas con pasajeros"),
    Otros("Otros");

    public final String description;

    ComplainType(String description) {
        this.description = description;
    }
    String description() {
        return this.description;
    }

}
