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
    
    public Store_Product(){
    }

    @EmbeddedId
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
}
