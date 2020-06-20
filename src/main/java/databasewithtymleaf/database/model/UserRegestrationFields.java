package databasewithtymleaf.database.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegestrationFields {

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String confrimPassword;
    private String birthdate;
    private String gender;
    private String phone;
    private String address;
    private String pin;
    private String confrimPin;

}
