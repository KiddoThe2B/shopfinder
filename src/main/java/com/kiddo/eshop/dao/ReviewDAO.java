/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiddo.eshop.dao;

import com.kiddo.eshop.model.Product;
import com.kiddo.eshop.model.Review;
import com.kiddo.eshop.model.Store;
import com.kiddo.eshop.model.User;
import com.kiddo.eshop.model.StoreProduct;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Francisco Javier
 */
@Repository("reviewDao")
public class ReviewDAO extends DAO{

    public void addReview(User user, Product product, Store store, String comments, String rating, String price) {
        Review review = new Review();
//        review.setUser(user);
        StoreProduct  sp = new StoreProduct();
//        review.setStoreProduct(sp);
        Session session = this.getSession();
        session.save(review);
    }
    
}
