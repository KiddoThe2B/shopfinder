/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiddo.eshop.service;

import com.kiddo.eshop.dao.StoreDAO;
import com.kiddo.eshop.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Francisco Javier
 */

@Service("storeService")
public class StoreService {
    @Autowired 
    private StoreDAO storeDAO;
 
    @Transactional
    public void setStoreDAO(StoreDAO storeDAO) {
        this.storeDAO = storeDAO;
    }
    
    @Transactional
    public Store getStoreById (int id){
        return this.storeDAO.getStoreById(id);
    }
}
