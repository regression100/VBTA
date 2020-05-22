package databasewithtymleaf.database.tajriba;

import databasewithtymleaf.database.users.Account;
import databasewithtymleaf.database.users.Admin;

import java.sql.*;

public class Methods implements MethodInterface {
    String temp="";
    Connection connection=null;
    Statement statement=null;
    Statement statement2=null;
    Statement statement3=null;
    ResultSet resultSet=null;
    ResultSet resultSet2=null;
    private String url="jdbc:postgresql://localhost:5432/VBT";
    private String userDB="postgres", pass="mahmudxon";

    @Override
    public boolean find_account(String username, String email) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection(url,userDB,pass);
        statement=connection.createStatement();
        resultSet=statement.executeQuery("select username, email from accounts where accounts.username='"+username+"' or accounts.email='"+email+"'");
        if (resultSet.next()){
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public boolean find_admin(String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection(url,userDB,pass);
        statement=connection.createStatement();
        resultSet=statement.executeQuery("select * from admins where admins.username='"+username+"' and admins.password='"+password+"'");
        if (resultSet.next()){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean update_account(Account account) {
        return false;
    }

    @Override
    public boolean add_account(Account account) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection(url,userDB,pass);
        statement=connection.createStatement();
        statement2=connection.createStatement();
        if (find_account(account.getUserName(),account.getEmail())){
            System.out.println("Email yoki username oldindan mavjud! Oʻzgartiring!");
            return false;
        }
        else {
            temp="'"+account.getUserName()+"','"+account.getFirstName()+"','"+account.getLastName()+"','"+account.getEmail()+"','"+account.getPassword()+"',"+account.getPin()+","+account.getBalance();
            statement.execute("insert into accounts(username,firstname,lastname,email,password,pin,balance) values ("+temp+")");
            System.out.println(account);
            return true;
        }


    }

    @Override
    public Account login_account(String username, String password) throws ClassNotFoundException, SQLException {
        Account account=new Account();

        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection(url,userDB,pass);
        statement=connection.createStatement();
        resultSet=statement.executeQuery("select id,username,firstname,lastname,email,password,pin,balance from accounts where accounts.username='"+username+"' and accounts.password='"+password+"'");
        if (resultSet.next()){
            account.setId(resultSet.getInt(1));
            account.setUserName(resultSet.getString(2));
            account.setFirstName(resultSet.getString(3));
            account.setLastName(resultSet.getString(4));
            account.setEmail(resultSet.getString(5));
            account.setPassword(resultSet.getString(6));
            account.setPin(resultSet.getString(7));
            account.setBalance(resultSet.getDouble(8));
            return account;
        }
        else {
            return null;
        }

    }

    @Override
    public Admin login_admin(String username, String password) throws ClassNotFoundException, SQLException {
        if (find_admin(username,password)){
            Admin admin=new Admin();
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection(url,userDB,pass);
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select * from Admins where Admins.password='"+password+"'");
            while (resultSet.next()){
                admin.setId(resultSet.getInt(1));
                admin.setUsername(resultSet.getString(2));
                admin.setPassword(resultSet.getString(3));
            }
            return admin;
        }
        else {
            return null;
        }
    }

    @Override
    public String add_balance_in_account(double summa, String pin, int id) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection(url,userDB,pass);
        statement=connection.createStatement();
        statement2=connection.createStatement();
        resultSet=statement.executeQuery("select pin from accounts where accounts.id="+id+"");
        while (resultSet.next()){
            if (resultSet.getString(1).equals(pin)){
                statement2.execute("select deposit("+id+","+summa+","+pin+")");
                return "Balans to'ldirildi!";
            }
            else {
                return "Pin notog'ri kiritilgan!";
            }
        }
        return null;
    }

    @Override
    public String transfer_balance_in_account(int id1, int id2, String pin, double amount) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection(url,userDB,pass);
        statement=connection.createStatement();
        statement2=connection.createStatement();
        resultSet=statement.executeQuery("select pin from accounts where accounts.id="+id1+"");
        while (resultSet.next()){
            if (resultSet.getString(1).equals(pin)){
                statement2.execute("select transfer("+id1+","+id2+","+amount+")");
                return "Mablagʻ yuborildi!";
            }
            else {
                return "Pin notog'ri kiritilgan!";
            }
        }
        return null;
    }

    @Override
    public String add_balance_in_admin(double summa, int id) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection(url,userDB,pass);
        statement=connection.createStatement();
        statement2=connection.createStatement();
        resultSet=statement.executeQuery("select id,pin from accounts where accounts.id="+id+"");
        if (resultSet.next()){
            statement2.execute("select deposit("+id+","+summa+","+resultSet.getString(2)+")");
            return "Mablagʻ muvaffaqiyatli qoʻshildi!";
        }
        else {
            return "Bunday id li account mavjud emas!";
        }
    }

    @Override
    public String tranfer_balance_in_admin(int id1, int id2, double summa) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection(url,userDB,pass);
        statement=connection.createStatement();
        statement2=connection.createStatement();
        statement3=connection.createStatement();
        resultSet=statement.executeQuery("select id from accounts where accounts.id="+id1+"");
        if (resultSet.next()){
            resultSet2=statement2.executeQuery("select id from accounts where accounts.id="+id2+"");
            if (resultSet2.next()){
                statement3.execute("select transfer("+id1+","+id2+","+summa+")");
                return "Pul koʻchirish muvaffaqiyatli amalga oshirildi!";
            }
            else {
                return "2 - id mavjud emas!";
            }
        }
        else {
            return "1 - id mavjud emas!";
        }
    }
}
