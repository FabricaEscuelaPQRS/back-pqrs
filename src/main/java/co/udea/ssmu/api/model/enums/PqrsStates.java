package co.udea.ssmu.api.model.enums;

public enum PqrsStates {
    PENDIENTE("Pendiente"),
    PROCESO("Proceso"),
    FINALIZADO("Finalizado");
    private final String value;
    PqrsStates(String pqrsState) {
        this.value = pqrsState;
    }
    public String getValue(){
        return value;
    }
}
