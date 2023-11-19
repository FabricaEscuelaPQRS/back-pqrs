package co.udea.ssmu.api.model.enums;

public enum Approved {
    APROBADO("Aprobado"),
    RECHAZADO("Rechazado"),
    INDEFINIDO("Indefinido");


    public final String value;

    Approved(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }



}
