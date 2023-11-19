package co.udea.ssmu.api.model.enums;

public enum Approved {
    APROBADO("Aprobado"),
    RECHAZADO("Rechazado"),
    INDEFINIDO("Indefinido");


    public final String translate;

    Approved(String translate) {
        this.translate = translate;
    }
    String translate() {
        return this.translate;
    }



}
