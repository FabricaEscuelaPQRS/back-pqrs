package co.udea.ssmu.api.model.dto;

import lombok.Data;

@Data
public class PqrsMessage {

    private Long id;
    private String message;
    private Long pqrsId;
}