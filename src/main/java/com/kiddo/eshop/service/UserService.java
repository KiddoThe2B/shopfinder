/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiddo.eshop.service;
import com.kiddo.eshop.model.User;
import com.kiddo.eshop.dao.UserDAO;
import com.kiddo.eshop.model.Item;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author kiddo
 */
@Service("userService")
public class UserService {
    
    @Autowired 
    private UserDAO userDAO;
 
    @Transactional
    public void setOrderDAO(UserDAO orderDAO) {
        this.userDAO = orderDAO;
    }
    
    @Transactional
    public String saveUser (User user){
        
        this.userDAO.save(user);
        return "User created successfully!";
    }
    
    @Transactional
    public User getUserById (String email){
        
        return this.userDAO.getUserById(email);
    }
    
    @Transactional
    public User getUserByID (int id){
        
        return this.userDAO.getUserByID(id);
    }
    
    @Transactional
    public List<Item> getCartById (int id){
        
        return this.userDAO.getUserByID(id).getCart();
    }
    
    @Transactional
    public User login (String email, String password){
        
        User user = this.userDAO.login(email,password);
        return user;
    }
   
}
