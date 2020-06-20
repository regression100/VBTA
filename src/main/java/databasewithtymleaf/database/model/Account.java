package databasewithtymleaf.database.model;

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

    public Account(int id, String password, String userName, String firstName, String lastName, String email, String phone, String birthDate, String address, String pin) {
        this.id = id;
        this.password = password;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.address = address;
        this.pin=pin;
    }



    public Account(String password, String userName) {
        this.password = password;
        this.userName = userName;
    }
}
