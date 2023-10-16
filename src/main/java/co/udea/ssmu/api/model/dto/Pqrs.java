package co.udea.ssmu.api.model.dto;


import co.udea.ssmu.api.model.enums.*;
import lombok.Data;

import java.util.Date;

@Data
public class Pqrs {

    private Long Id;
    private PqrsTypes pqrsType;
    private Long createdBy;
    private Long complainTo;
    private PqrsStates pqrsState;
    private Long admin;
    private Date createdAt;
    private Approved approved;
    private String pqrsDescription;
    private ComplainType complainType;
    private GrievanceType grievanceType;

}
