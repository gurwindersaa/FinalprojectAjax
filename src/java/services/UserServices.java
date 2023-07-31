/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.UserDB;
import java.util.List;
import models.Item;
import models.User;

/**
 *
 * @author gurwi
 */
public class UserServices {

    public User get(String email) {
        UserDB userdb = new UserDB();
        User user = userdb.get(email);
        return user;
    }

    public List<Item> getAll(String email) throws Exception {
        UserDB userdb = new UserDB();
        List<Item> items = userdb.getAll(email);
        return items;
    }
}
