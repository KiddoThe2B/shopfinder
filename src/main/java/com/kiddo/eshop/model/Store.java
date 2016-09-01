/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiddo.eshop.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.kiddo.eshop.jsonview.Views;
import java.io.Serializable;
import java.util.List;
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
 * @author Francisco Javier munoz
 */
@Entity
@Table(name="stores")
public class Store implements Serializable{
    
    @JsonView(Views.Public.class)
    int id;
    @JsonView(Views.Public.class)
    String name;
    @JsonView(Views.Public.class)
    String address;
    @JsonView(Views.Public.class)
    String image;
    List<Store_Product> store_products;
    
    @Id
    @Column(name="shop_id")
    @GeneratedValue
    public int getStoreId(){
        return id;
    }
    
    public void setStoreId(int id){
        this.id = id;
    }

    public Store() {
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name="image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.store", cascade=CascadeType.ALL)
    public List<Store_Product> getStore_Products() {
        return store_products;
    }

    public void setStore_Products(List<Store_Product> store_products) {
        this.store_products = store_products;
    }
}

