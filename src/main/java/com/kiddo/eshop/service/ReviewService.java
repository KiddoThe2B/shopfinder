/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiddo.eshop.service;

import com.kiddo.eshop.dao.ProductDAO;
import com.kiddo.eshop.dao.StoreDAO;
import com.kiddo.eshop.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Francisco Javier
 */
@Service("reviewService")
public class ReviewService {
    
//    @Autowired 
//    private UserDAO userDAO;
//    
//    @Autowired 
//    private ProductDAO productDAO;
//    
//    @Autowired 
//    private StoreDAO storeDAO;
//    
//    @Autowired 
//    private ReviewDAO reviewDAO;
//    
//    @Transactional
//    public void addItem(String user_id, String product_id,String store_id,String comments,String rating, String price) {
//        this.reviewDAO.addReview(this.userDAO.getUserByID(Integer.valueOf(user_id)), this.productDAO.getProductById(Integer.valueOf(product_id)), this.storeDAO.getStoreById(Integer.valueOf(store_id)), comments, rating, price);    
//    }
    
}
