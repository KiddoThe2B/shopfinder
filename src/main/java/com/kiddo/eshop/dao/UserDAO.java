/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiddo.eshop.dao;

import com.kiddo.eshop.model.Item;
import com.kiddo.eshop.model.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kiddo
 */
@Repository("userDao")
public class UserDAO extends DAO{

    public void save(User user) {
        Session session = this.getSession();
        session.save(user);
    }

    public String login(String email) {
        Session session = this.getSession();     
        Criteria cr = session.createCriteria(User.class)
        .add(Restrictions.eq("email", email))
        .setProjection(Projections.property("password"));
        List l = cr.list();
        if(l!=null){
            return (String) l.get(0);
        }
        else{
            return null;
        }
    }
    public User getUserById(String email) {
        Session session = this.getSession();     
        Criteria cr = session.createCriteria(User.class)
        .add(Restrictions.eq("email", email));
        List l = cr.list();
        return (User) l.get(0);
    }
    
    public User getUserByID(int id) {
        Session session = this.getSession();     
        Criteria cr = session.createCriteria(User.class)
        .add(Restrictions.eq("user_id", id));
        List l = cr.list();
        return (User) l.get(0);
    }

}
