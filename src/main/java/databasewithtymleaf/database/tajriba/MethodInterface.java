package databasewithtymleaf.database.tajriba;

import databasewithtymleaf.database.users.Account;
import databasewithtymleaf.database.users.Admin;

import java.sql.SQLException;

public interface MethodInterface {
    boolean find_account(String username, String email) throws ClassNotFoundException, SQLException;
    boolean find_admin(String email, String password) throws ClassNotFoundException, SQLException;
    boolean update_account(Account account);
    boolean add_account(Account account) throws SQLException, ClassNotFoundException;
    Account login_account(String username, String password) throws ClassNotFoundException, SQLException;
    Admin login_admin(String username,String password) throws ClassNotFoundException, SQLException;
    String add_balance_in_account(double summa, String pin, int id) throws ClassNotFoundException, SQLException;
    String transfer_balance_in_account(int id1, int id2, String pin, double amount) throws ClassNotFoundException, SQLException;
    String add_balance_in_admin(double summa, int id) throws ClassNotFoundException, SQLException;
    String tranfer_balance_in_admin(int id1, int id2, double summa) throws ClassNotFoundException, SQLException;
}
