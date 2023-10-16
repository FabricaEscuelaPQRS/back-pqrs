package co.udea.ssmu.api.model.dto;

import co.udea.ssmu.api.model.enums.UserRoles;
import lombok.Data;

@Data
public class User {
    private Long Id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private boolean state;
    private UserRoles userRole;

}
