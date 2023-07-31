/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import models.Item;
import models.User;

/**
 *
 * @author gurwi
 */
public class UserDB {

    public User get(String email) {

        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            User user = em.find(User.class, email);
            String role = user.getRole().getRoleName();

            return user;
        } finally {
            em.close();
        }
    }

     public List<Item> getAll(String owner) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            User user = em.find(User.class, owner);
            return user.getItemList();
        } finally {
            em.close();
        }
    }
}
