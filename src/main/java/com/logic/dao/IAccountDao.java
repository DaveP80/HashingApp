package com.logic.dao;

import com.logic.model.Account;

@FunctionalInterface
public interface IAccountDao {

    int insert (Account a);
}
