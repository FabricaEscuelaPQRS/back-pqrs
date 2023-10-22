package co.udea.ssmu.api.model.dto;
import lombok.Data;

@Data
public class Archivo {
    private Long id;
    private String url;
    private Long idMensaje;
}
