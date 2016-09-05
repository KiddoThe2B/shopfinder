/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiddo.eshop.dao;

import com.kiddo.eshop.model.Store;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Francisco Javier
 */
@Repository("storeDao")
public class StoreDAO extends DAO{
    
    public Store getStoreById(int id) {
        Session session = this.getSession();     
        Criteria cr = session.createCriteria(Store.class)
        .add(Restrictions.eq("id", id));
        List l = cr.list();
        return (Store) l.get(0);
    }
    
}