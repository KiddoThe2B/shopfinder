/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiddo.eshop.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.kiddo.eshop.jsonview.Views;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 *
 * @author Francisco Javier
 */

@Embeddable
class Store_ProductId implements java.io.Serializable {
    
    @JsonView(Views.Public.class)
    private Store store;
    private Product product;

    @ManyToOne
    public Store getStore() {
            return store;
    }

    public void setStore(Store store) {
            this.store = store;
    }

    @ManyToOne
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Store_ProductId that = (Store_ProductId) o;

        if (store != null ? !store.equals(that.store) : that.store != null) return false;
        if (product != null ? !product.equals(that.product) : that.product != null)
            return false;

        return true;
    }



    public int hashCode() {
        int result;
        result = (product != null ? product.hashCode() : 0);
        result = 31 * result + (store != null ? store.hashCode() : 0);
        return result;
    }
}
