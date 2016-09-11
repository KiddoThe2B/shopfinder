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
//@Entity
//@Table(name = "reviews")
//@AssociationOverrides({
//    @AssociationOverride(name = "pk2.user",
//            joinColumns = @JoinColumn(name = "user_id")),
//    @AssociationOverride(name = "pk2.storeproduct",
//            joinColumns = @JoinColumn(name = "storeproduct_id")) })
public class Review implements Serializable {
    
    @JsonView(Views.Public.class)
    private ReviewId pk2 = new ReviewId();
    @JsonView(Views.Public.class)
    private String comments;
    @JsonView(Views.Public.class)
    private int rating;
    @JsonView(Views.Public.class)
    private double price;
    
    public Review(){
    }
    
//    @EmbeddedId
//    public ReviewId getPk() {
//            return pk2;
//    }
//
//    public void setPk(ReviewId pk2) {
//            this.pk2 = pk2;
//    }
//    
//    @Transient
//    public User getUser() {
//            return getPk().getUser();
//    }
//
//    public void setUser(User user) {
//            getPk().setUser(user);
//    }
//
//    @Transient
//    public StoreProduct getStoreProduct() {
//            return getPk().getStoreProduct();
//    }
//
//    public void setStoreProduct(StoreProduct storeproduct) {
//            getPk().setStoreProduct(storeproduct);
//    }
//
//    @Column(name="comments")
//    public String getComments() {
//        return comments;
//    }
//
//    public void setComments(String comments) {
//        this.comments = comments;
//    }
//
//    @Column(name="rating")
//    public int getRating() {
//        return rating;
//    }
//
//    public void setRating(int rating) {
//        this.rating = rating;
//    }
//
//    @Column(name="price")
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
    
    
    
}

