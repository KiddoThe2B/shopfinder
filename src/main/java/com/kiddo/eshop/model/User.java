/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiddo.eshop.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.kiddo.eshop.jsonview.Views;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kiddo
 */
@Entity
@Table(name="users")
public class User {

    @JsonView(Views.Public.class)
    int user_id;
    @JsonView(Views.Public.class)
    String fullname;
    @JsonView(Views.Public.class)
    String email;
    @JsonView(Views.Public.class)
    String password;
    @JsonView(Views.Public.class)
    List<Item> cart;
    
    @Id
    @Column(name="user_id")
    @GeneratedValue
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Column(name="fullname")
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Column(name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.user", cascade=CascadeType.ALL)
    public List<Item> getCart() {
        return cart;
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }
}
