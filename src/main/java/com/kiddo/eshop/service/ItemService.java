/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiddo.eshop.service;

import com.kiddo.eshop.dao.ItemDAO;
import com.kiddo.eshop.dao.ProductDAO;
import com.kiddo.eshop.model.User;
import com.kiddo.eshop.dao.UserDAO;
import com.kiddo.eshop.model.Item;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Francisco Javier
 */
@Service("itemService")
public class ItemService {
    @Autowired 
    private ItemDAO itemDAO;
    
    @Autowired 
    private UserDAO userDAO;
    
    @Autowired 
    private ProductDAO productDAO;
    
    @Transactional
    public void deleteItem(int user_id,int product_id) {
        this.itemDAO.deleteItem(this.userDAO.getUserByID(user_id), this.productDAO.getProductById(product_id));
    }
    
    @Transactional
    public void addItem(int user_id, int product_id) {
        this.itemDAO.addItem(this.userDAO.getUserByID(user_id), this.productDAO.getProductById(product_id));    
    }
    
}
