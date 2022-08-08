package com.logic;

import com.logic.model.Account;
import com.logic.service.AccountService;

import java.util.Scanner;


public class App extends PasswordHashing {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        AccountService as = new AccountService();

        while (true) {

            System.out.println("Please enter an example password");

            String testinput = scan.next();

            Account a = new Account(doHashing(testinput));

            as.insertExample(a);
            Thread.sleep(3000);
            System.out.println("press 1 to end program");
            scan.next();
            System.exit(0);

        }
    }
}
