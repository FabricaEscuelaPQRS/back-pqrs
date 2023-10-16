package co.udea.ssmu.api.model.dto;

import lombok.Data;

@Data
public class PqrsMessage {

    private Long Id;
    private String message;
    private Long pqrsId;
}