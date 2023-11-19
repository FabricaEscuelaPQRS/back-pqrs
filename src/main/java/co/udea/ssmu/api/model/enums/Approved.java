package co.udea.ssmu.api.model.enums;

public enum Approved {
    APROBADO("Aprobado"),
    RECHAZADO("Rechazado"),
    INDEFINIDO("Indefinido");


    private final String status;
    Approved(String status) {
        this.status = status;
    }

    // Public method to get the status
    public String getStatus() {
        return status;
    }



}
