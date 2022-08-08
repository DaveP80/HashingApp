package com.logic.dao;

import com.logic.model.Account;
import com.logic.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao implements IAccountDao {

    @Override
    public int insert (Account a) {
        Connection conn = ConnectionUtil.getConnection();

        String sql = "INSERT INTO account (password) values (?) RETURNING account.id";

        try {

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, a.getPassword());

            ResultSet rs;

            if ((rs = stmt.executeQuery()) != null) {
                //if we return data, we can iterate over it

            rs.next();

            int id = rs.getInt(1);

            System.out.println("We returned an account with id #" + id);

            return id;

            //We need to capture the first column of data returned (which is the id of the
            //returned user


        }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
             return -1;
    }



}

