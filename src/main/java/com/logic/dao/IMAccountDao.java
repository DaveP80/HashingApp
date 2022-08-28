package com.logic.dao;

import com.logic.model.Account;
public interface IMAccountDao{

    void insertUser(Account a) throws InterruptedException;
}
