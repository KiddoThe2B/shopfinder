/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiddo.eshop.service;

import com.kiddo.eshop.dao.ProductDAO;
import com.kiddo.eshop.model.Product;
import com.kiddo.eshop.model.Store;
import com.kiddo.eshop.model.StoreProduct;
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
        
        return this.getStores(this.getProductById(id).getStoreProducts());
    }
    
    @Transactional
    public List<StoreProduct> getStoreProductsById (int id){
        return this.getProductById(id).getStoreProducts();
    }
    
    public Set<Store> getStores(List<StoreProduct> storeproducts){
        Set<Store> stores = new HashSet<Store>();
        for (StoreProduct sd : storeproducts){
            stores.add(sd.getStore());
        }
        return stores;
    }

    @Transactional
    public List<Product> getProducts() {
        return productDAO.getProducts();
    }
}
