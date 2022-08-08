package com.logic.service;

import com.logic.dao.AccountDao;
import com.logic.dao.IAccountDao;
import com.logic.model.Account;

import java.sql.ResultSet;

public class AccountService {



    //dependency injection, this implementation will start the Account Dao layer
    //, and connect to db to do transaction.
    //business math
    public Account insertExample(Account a) {
        IAccountDao adao = new AccountDao();
        System.out.println("inserting the password");

        int generated_id = adao.insert(a);
        if (generated_id != -1 && generated_id != a.getId()) {
            a.setId(generated_id); //the account (for business math) is now set to the result from
            //the db query
        }
        System.out.println("Successfully entered with Id of " + a.getId());

       return a;
    }
}
