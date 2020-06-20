package databasewithtymleaf.database.tajriba;

import databasewithtymleaf.database.model.Account;
import databasewithtymleaf.database.model.Admin;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TajribaMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scannerInt=new Scanner(System.in);
        Scanner scannerString=new Scanner(System.in);
        Methods methods=new Methods();

//        java.util.Date dt = new java.util.Date();
//
//        java.text.SimpleDateFormat sdf =
//                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
        Date date=new Date();
        SimpleDateFormat  simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = simpleDateFormat.format(date);
        System.out.println(dateTime);


//        java.sql.Timestamp date1=new java.sql.Timestamp(date.getTime());
//        System.out.println(dateTime);

//        System.out.println(Calendar.SHORT);

        while (true){
            String username="";
            String password="";
            Account account=new Account();
            Admin admin=new Admin();


            System.out.println("1. Kirish\n2. Roʻyhatdan oʻtish\n3. Chiqish");

            switch (scannerInt.nextInt()){

                case 1:
                    System.out.println("Username ni kiriting");
                    username=scannerString.nextLine();
                    System.out.println("Parolni kiriting");
                    password=scannerString.nextLine();
                    account=methods.login_account(username,password);
                    if (account!=null){
                        System.out.println(account);



                        boolean bool=true;
                        while (bool){
                            double money=0;
                            String pin="";
                            int idTemp=0;
                            System.out.println("1. Balansni toʻldirish\n2. Mablagʻ yuborish\n3. Chiqish");
                            switch (scannerInt.nextInt()){

                                case 1:
                                    System.out.println("Pul miqdorini kiriting:");
                                    money=scannerInt.nextDouble();
                                    System.out.println("Pinni kiriting:");
                                    pin=scannerString.nextLine();
                                    System.out.println( methods.add_balance_in_account(money,pin,account.getId()));
                                    break;

                                case 2:
                                    System.out.println("Pul miqdorini kiriting:");
                                    money=scannerInt.nextDouble();
                                    System.out.println("Qabul qiluvchi id raqamini kiriting:");
                                    idTemp=scannerInt.nextInt();
                                    System.out.println("Pinni kiriting:");
                                    pin=scannerString.nextLine();
                                    System.out.println(methods.transfer_balance_in_account(account.getId(),idTemp,money));
                                    break;

                                default:
                                    bool=false;
                                    break;


                            }
                        }



                    }
                    else {
                        admin=methods.login_admin(username,password);
                        if (admin!=null){
                            System.out.println(admin);
                            boolean bool=true;


                            while (bool) {
                                double money=0;
                                String pin="";
                                int idTemp=0;
                                int idTemp2=0;
                                System.out.println("1. Account hisobiga mablagʻ qoʻshish\n2. Bir accountdan boshqa accountga mablagʻ oʻtkazish\n3. Chiqish");

                                switch (scannerInt.nextInt()){
                                    case 1:
                                        System.out.println("Mablagʻni kiriting:");
                                        money=scannerInt.nextDouble();
                                        System.out.println("Account id sini kiriting:");
                                        idTemp=scannerInt.nextInt();
                                        System.out.println(methods.add_balance_in_admin(money,idTemp));
                                        break;

                                    case 2:
                                        System.out.println("Mablagʻni kiriting:");
                                        money=scannerInt.nextDouble();
                                        System.out.println("1-Account id sini kiriting:");
                                        idTemp=scannerInt.nextInt();
                                        System.out.println("2-Account id sini kiriting:");
                                        idTemp2=scannerInt.nextInt();
                                        System.out.println(methods.tranfer_balance_in_admin(idTemp,idTemp2,money));
                                        break;

                                    default:
                                        bool=false;
                                        break;
                                }
                            }
                                }
                        else {
                            System.out.println("Login yoki parol xato!");
                        }
                    }
                    break;



                case 2:
                    String passwordTemp="";
                    String pinTemp="";
                    System.out.println("Ism:");
                    account.setFirstName(scannerString.nextLine());
                    System.out.println("familiya:");
                    account.setLastName(scannerString.nextLine());
                    System.out.println("username:");
                    account.setUserName(scannerString.nextLine());
                    System.out.println("email:");
                    account.setEmail(scannerString.nextLine());
                    System.out.println("parol:");
                    passwordTemp=scannerString.nextLine();
                    System.out.println("parolni tasdiqlash:");
                    if (passwordTemp.equals(scannerString.nextLine())){
                        account.setPassword(passwordTemp);
                    }
                    else {
                        System.out.println("parol tasdiqlanmadi!");
                        break;
                    }
                    System.out.println("pin:");
                    pinTemp=scannerString.nextLine();
                    System.out.println("pinni tasdiqlash:");
                    if (pinTemp.equals(scannerString.nextLine())){
                        account.setPin(pinTemp);
                    }
                    else {
                        System.out.println("Pin tasdiqlanmadi");
                        break;
                    }
                    System.out.println("balans:");
                    account.setBalance(scannerString.nextDouble());
                    methods.add_account(account);
                    break;



                case 3:

                    break;

                default:
                    break;


            }


        }






    }
}
