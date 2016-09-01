/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiddo.eshop.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.kiddo.eshop.jsonview.Views;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author kiddo
 */
@Entity
@Table(name = "items")
@AssociationOverrides({
    @AssociationOverride(name = "pk.user",
            joinColumns = @JoinColumn(name = "user_id")),
    @AssociationOverride(name = "pk.product",
            joinColumns = @JoinColumn(name = "product_id")) })
public class Item {
    
    @JsonView(Views.Public.class)
    private ItemId pk = new ItemId();
    
    public Item() {
    }

    @EmbeddedId
    public ItemId getPk() {
            return pk;
    }

    public void setPk(ItemId pk) {
            this.pk = pk;
    }
    
    @Transient
    public User getUser() {
            return getPk().getUser();
    }

    public void setUser(User user) {
            getPk().setUser(user);
    }

    @Transient
    public Product getProduct() {
            return getPk().getProduct();
    }

    public void setProduct(Product product) {
            getPk().setProduct(product);
    }


}
