/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiddo.eshop.service;

import com.kiddo.eshop.dao.ProductDAO;
import com.kiddo.eshop.model.Product;
import com.kiddo.eshop.model.Store;
import com.kiddo.eshop.model.Store_Product;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kiddo
 */
@Service("productService")
public class ProductService {
    @Autowired 
    private ProductDAO productDAO;
 
    @Transactional
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
    
    @Transactional
    public Product getProductById (int id){
        
        return this.productDAO.getProductById(id);
    }
    
    @Transactional
    public Set<Store> getShopsById (int id){
        
        return this.getStores(this.getProductById(id).getStore_Products());
    }
    
    public Set<Store> getStores(List<Store_Product> store_products){
        Set<Store> stores = new HashSet<Store>();
        for (Store_Product sd : store_products){
            stores.add(sd.getStore());
        }
        return stores;
    }
}
