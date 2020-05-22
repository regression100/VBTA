package databasewithtymleaf.database.controllers;

import databasewithtymleaf.database.users.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.*;
import java.util.ArrayList;

@Controller
public class MainController {

    Connection connection=null;
    Statement statement=null;
    Statement statement2=null;
    ResultSet resultSet=null;
    private String url="jdbc:postgresql://localhost:5432/TestBot";
    private String userDB="postgres", pass="mahmudxon";



    @GetMapping("/home")
    public String home(Model model) throws SQLException, ClassNotFoundException {
        Account account=new Account();
        ArrayList<Account> accounts=new ArrayList<>();
//        Class.forName("org.postgresql.Driver");
//        connection= DriverManager.getConnection(url,userDB,pass);
//        statement=connection.createStatement();
//        statement2=connection.createStatement();
//        resultSet=statement.executeQuery("select username,firstname,lastname from users where id="+1+"");
//        if (resultSet.next()){
//            user.setFirstName(resultSet.getString(2));
//            users.add(user);
//        }
//
//        System.out.println(user.getFirstName());
//        model.addAttribute("user",user);
        return "home_page";
    }

    @GetMapping("/")
    public String login(Model model){
        String a="aaaaaa";
        model.addAttribute("a",a);
        return "login_page";
    }

    @GetMapping("/register")
    public String register(Model model){
        return "register_page";
    }
}
