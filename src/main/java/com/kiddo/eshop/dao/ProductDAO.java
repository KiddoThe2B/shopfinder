/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiddo.eshop.dao;

import com.kiddo.eshop.model.Product;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kiddo
 */
@Repository("productDao")
public class ProductDAO extends DAO{

    public Product getProductById(int id) {
        Session session = this.getSession();     
        Criteria cr = session.createCriteria(Product.class)
        .add(Restrictions.eq("id", id));
        List l = cr.list();
        return (Product) l.get(0);
    }

    public List<Product> getProducts() {
        Session session = this.getSession();     
        Criteria cr = session.createCriteria(Product.class).addOrder(Order.asc("id"));
        return cr.list();
    }
}
