/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiddo.eshop.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.kiddo.eshop.jsonview.Views;
import java.util.List;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Francisco Javier
 */
@Entity
@Table(name = "store_products")
@AssociationOverrides({
    @AssociationOverride(name = "pk.store",
            joinColumns = @JoinColumn(name = "shop_id")),
    @AssociationOverride(name = "pk.product",
            joinColumns = @JoinColumn(name = "product_id")) })
public class Store_Product {
    
    @JsonView(Views.Public.class)
    private Store_ProductId pk = new Store_ProductId();
//    private List<Review> reviews;
    @JsonView(Views.Public.class)
    private int storeproduct_id;
    @JsonView(Views.Public.class)
    private double price;
    
    public Store_Product(){
    }
    
    @Id
    @Column(name="storeproduct_id")
    @GeneratedValue
    public int getStoreproduct_id() {
        return storeproduct_id;
    }

    public void setStoreproduct_id(int storeproduct_id) {
        this.storeproduct_id = storeproduct_id;
    }
    
    @Column(name="price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
//    @EmbeddedId
    public Store_ProductId getPk() {
            return pk;
    }

    public void setPk(Store_ProductId pk) {
            this.pk = pk;
    }
    
    @Transient
    public Store getStore() {
            return getPk().getStore();
    }

    public void setStore(Store store) {
            getPk().setStore(store);
    }

    @Transient
    public Product getProduct() {
            return getPk().getProduct();
    }

    public void setProduct(Product product) {
            getPk().setProduct(product);
    }
    
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk2.product", cascade=CascadeType.ALL)
//    public List<Review> getReviews() {
//        return reviews;
//    }
//
//    public void setReviews(List<Review> reviews) {
//        this.reviews = reviews;
//    }
}
