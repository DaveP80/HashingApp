package com.logic.dao;

import com.logic.model.Account;
import com.logic.util.MongoUtil;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class AccountMDao implements IMAccountDao{

    MongoUtil mongoUtil = new MongoUtil();
    MongoDatabase database = mongoUtil.getDB();
    MongoCollection<Document> collection = database.getCollection("user");
    @Override
    public void insertUser(Account a) throws InterruptedException {


        Document document = new Document("password", a.getPassword());
        mongoUtil.getUserCollection().insertOne(document);
        MongoCursor<Document> cur = collection.find().skip((int) collection.countDocuments()-1).iterator();
        while (cur.hasNext()) {
            Document doc = cur.next();
            ArrayList<Object> users = new ArrayList<>(doc.values());
            System.out.println("returned an object id");
            Thread.sleep(1500);
            System.out.println(users.get(0));
        }
    }


}