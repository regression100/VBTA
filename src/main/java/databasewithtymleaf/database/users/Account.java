package databasewithtymleaf.database.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private int id;
    private String password;
    private String userName;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String phone;
    private String birthDate;
    private String address;
    private String pin;
    private double balance;
}
