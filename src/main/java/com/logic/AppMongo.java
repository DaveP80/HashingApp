package com.logic;

import com.logic.dao.AccountMDao;
import com.logic.model.Account;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppMongo extends PasswordHashing {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        try {

            AccountMDao am = new AccountMDao();

            while (true) {

                System.out.println("Please enter an example password");

                String testinput = scan.next();

                Account a = new Account(doHashing(testinput));

                am.insertUser(a);

                Thread.sleep(2000);
                System.out.println("press 1 to end program, any int to continue");
                while (scan.nextInt() == 1) {
                    System.exit(0);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("enter an integer to continue");
        }
    }
}