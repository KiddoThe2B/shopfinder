/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiddo.eshop.dao;

import com.kiddo.eshop.model.Item;
import com.kiddo.eshop.model.ItemId;
import com.kiddo.eshop.model.Product;
import com.kiddo.eshop.model.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Francisco Javier
 */
@Repository("itemDao")
public class ItemDAO  extends DAO{
    
    public void deleteItem(User user, Product product) {
        Item item = new Item();
        item.setUser(user);
        item.setProduct(product);
        Session session = this.getSession();
        session.delete(item);
    }

    public void addItem(User user, Product product) {
        Item item = new Item();
        item.setUser(user);
        item.setProduct(product);
        Session session = this.getSession();
        session.save(item);
    }
    
}
