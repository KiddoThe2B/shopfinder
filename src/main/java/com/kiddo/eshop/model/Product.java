/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiddo.eshop.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.kiddo.eshop.jsonview.Views;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kiddo
 */
@Entity
@Table(name="products")
public class Product implements Serializable {
    
    @JsonView(Views.Public.class)
    int id;
    @JsonView(Views.Public.class)
    String name;
    @JsonView(Views.Public.class)
    String description;
    @JsonView(Views.Public.class)
    String image;
    List<Store_Product> store_products;
    
    List<Item> items;
    
    @Id
    @Column(name="product_id")
    @GeneratedValue
    public int getProductId(){
        return id;
    }
    
    public void setProductId(int id){
        this.id = id;
    }

    public Product() {
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.product")
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.product", cascade=CascadeType.ALL)
    public List<Store_Product> getStore_Products() {
        return store_products;
    }

    public void setStore_Products(List<Store_Product> store_products) {
        this.store_products = store_products;
    }
    


    
    
}
