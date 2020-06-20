package databasewithtymleaf.database.controllers;

import databasewithtymleaf.database.tajriba.Methods;
import databasewithtymleaf.database.model.Account;
import databasewithtymleaf.database.model.Admin;
import databasewithtymleaf.database.model.UserRegestrationFields;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;

@Controller
public class MainController {

//    Connection connection=null;
//    Statement statement=null;
//    Statement statement2=null;
//    ResultSet resultSet=null;
//    private String url="jdbc:postgresql://localhost:5432/TestBot";
//    private String userDB="postgres", pass="mahmudxon";
//    ArrayList<Account> accounts=new ArrayList<>();
    String natija="aaaaaaaa";
    Methods methods=new Methods();
    Account account=null;
    Admin admin=null;
    UserRegestrationFields user=null;
    String xato="";
    String xato_register="";

    @GetMapping("/")
    public String first(){
        account=null;
        admin=null;
        return "home_page";
    }

    @GetMapping("/xato")
    public String error(){
        return "error_page";
    }

    @GetMapping("/succes")
    public String succes(){
        return "succes_page";
    }

    @GetMapping("/admin")
    public String admin(){

        if (admin!=null) {
            return "admin/admin_page";
        }
        else {
            return "redirect:/login";
        }

    }

    @GetMapping("/user_password_change")
    @PostMapping("/user_password_change")
    public String user(Model model,@RequestParam(value="password_change", required=false, defaultValue= "") String password_change,@RequestParam(value="new_password", required=false, defaultValue= "") String new_password) throws SQLException, ClassNotFoundException {
        String natija_change_password="";
        if (account!=null){
            natija_change_password=methods.change_password(account.getId(),new_password);
            model.addAttribute("natija_change_password",natija_change_password);
            account=methods.login_account(account.getUserName(),new_password);
            return "redirect:/user";
        }

        return "redirect:/user";
    }

    @GetMapping("/user_update")
    @PostMapping("/user_update")
    public String user(Model model,@RequestParam(value="username_ch", required=false, defaultValue= "") String username_ch,@RequestParam(value="firstname_ch", required=false, defaultValue= "") String firstname_ch,@RequestParam(value="lastname_ch", required=false, defaultValue= "") String lastname_ch,@RequestParam(value="email_ch", required=false, defaultValue= "") String email_ch,@RequestParam(value="phone_ch", required=false, defaultValue= "") String phone_ch,@RequestParam(value="address_ch", required=false, defaultValue= "") String address_ch,@RequestParam(value="birthdate_ch", required=false, defaultValue= "") String birthdate_ch,@RequestParam(value="pin_ch", required=false, defaultValue= "") String pin_ch,@RequestParam(value="password_ch", required=false, defaultValue= "") String password_ch) throws SQLException, ClassNotFoundException {
        System.out.println("pin : "+pin_ch);
        if (account!=null){
            Account account1=new Account(account.getId(),password_ch,username_ch,firstname_ch,lastname_ch,email_ch,phone_ch,birthdate_ch,address_ch,pin_ch);
            System.out.println("account1 = "+account1);
            if (account1.getPassword().equals(account.getPassword())){
                natija=methods.update_account(account1);
                account=methods.login_account(username_ch,account.getPassword());
                model.addAttribute("natija",natija);
            }
            else {
                model.addAttribute("natija", "Nomaʻlum xatolik");
            }
        }
        else {
            model.addAttribute("natija", "Parol notoʻgʻri!");
        }
        return "redirect:/user";
    }



    @GetMapping("/user")
    @PostMapping("/user")
    public String user(@RequestParam(value="trans_summa", required=false, defaultValue= "0") String trans_summa, @RequestParam(value="id_send", required=false, defaultValue= "0") String id_send, @RequestParam(value="id_this", required=false, defaultValue="0") String id_this, @RequestParam(value="deposit_summa", required=false, defaultValue="0") String deposit_summa, @RequestParam(value="deposit_password", required=false, defaultValue="0") String deposit_password, @RequestParam(value="deposit_pin", required=false, defaultValue="0") String deposit_pin, Model model,Model model2) throws SQLException, ClassNotFoundException {


        if (account!=null){
            model.addAttribute("account",account);
            model2.addAttribute("a"," ");
            System.out.println(account.getUserName());
            id_this= String.valueOf(account.getId());
            System.out.println(id_this);
            System.out.println(id_send);
            System.out.println(trans_summa);
            if (!id_send.equals("0")){
                String xabar=methods.transfer_balance_in_account(Integer.parseInt(id_this),Integer.parseInt(id_send), Double.parseDouble(trans_summa));
                System.out.println(xabar);
                model2.addAttribute("xabarTrans", xabar);
                id_send="0";
                account=methods.login_account(account.getUserName(),account.getPassword());
                return "redirect:/user";
            }
            if (!deposit_summa.equals("0")){
                String xabarDeposit=methods.add_balance_in_account(Double.parseDouble(deposit_summa), String.valueOf(Integer.parseInt(deposit_pin)),Integer.parseInt(id_this));
                System.out.println(xabarDeposit);
                model2.addAttribute("xabarDeposit", xabarDeposit);
                account=methods.login_account(account.getUserName(),account.getPassword());
                return "redirect:/user";
            }
            return "user/user_page";
        }
        else {
            return "redirect:/login";
        }

    }



    @GetMapping("/login")
    @PostMapping("/login")
    public String login(@RequestParam(value="username", required=false, defaultValue="") String username, @RequestParam(value="password", required=false, defaultValue="") String password, Model model, Model model2) throws SQLException, ClassNotFoundException {
        String a="aaaaaa";
        account=null;
        admin=null;
        model2.addAttribute("a", "xato");
        model.addAttribute("account",account);



        model2.addAttribute("xato", xato);
        if (username.equals("") && password.equals("")){
            xato="";
            return "login_page";

        }
        account=methods.login_account(username,password);
        System.out.println(account);
        System.out.println("xato: "+xato);
            if (account!=null){
                return "redirect:/user";
            }
            else {
                admin=methods.login_admin(username,password);
                if (admin!=null){
                    return "redirect:/admin";
                }
                else {
                    xato="Login yoki parol xato!";
                    return "redirect:/login";
                }

            }






    }

    @GetMapping("/register")
    @PostMapping("/register")
    public String register(@RequestParam(value="username", required=false, defaultValue="") String username,@RequestParam(value="firstname", required=false, defaultValue="") String firstname,@RequestParam(value="lastname", required=false, defaultValue="") String lastname,@RequestParam(value="password", required=false, defaultValue="") String password,@RequestParam(value="confrimPassword", required=false, defaultValue="") String confrimPassword,@RequestParam(value="email", required=false, defaultValue="") String email,@RequestParam(value="birthdate", required=false, defaultValue="") String birthdate,@RequestParam(value="phone", required=false, defaultValue="") String phone,@RequestParam(value="address", required=false, defaultValue="") String address,@RequestParam(value="pin", required=false, defaultValue="") String pin,@RequestParam(value="confrimPin", required=false, defaultValue="") String confrimPin, Model model) throws SQLException, ClassNotFoundException {
        account=new Account();
        model.addAttribute("xatoRegister", xato_register);

        if (username.equals("") && firstname.equals("") && lastname.equals("") && password.equals("") && email.equals("") && birthdate.equals("") && phone.equals("") && address.equals("") && pin.equals("")){
            return "register_page";
        }

        account.setUserName(username);
        account.setFirstName(firstname);
        account.setLastName(lastname);
        account.setPassword(password);
        account.setEmail(email);
        account.setBirthDate(birthdate);
        account.setPhone(phone);
        account.setAddress(address);
        account.setPin(pin);

            if (!methods.add_account(account)){
                xato_register="Username yoki email oldindan mavjud!";
                return "redirect:/register";
            }
            else {


                System.out.println(account);
                xato_register="";
                return "redirect:/succes";
            }







    }


}
