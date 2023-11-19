package co.udea.ssmu.api.model.enums;

public enum PqrsTypes {
    QUEJA("Queja"),
    PETICION("Peticion"),
    RECLAMO("Reclamo"),
    SUGERENCIA("Sugerencia"),
    FELICITACION("Felicitacion");
    private final String value;
    PqrsTypes(String pqrsType) {
    this.value = pqrsType;
    }
    public String getValue(){
        return value;
    }
}
