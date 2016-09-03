/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiddo.eshop.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.kiddo.eshop.jsonview.Views;
import javax.persistence.ManyToOne;

/**
 *
 * @author kiddo
 */
class ReviewId {
    @JsonView(Views.Public.class)
    private User user;
    @JsonView(Views.Public.class)
    private Store_Product product;

    @ManyToOne
    public User getUser() {
            return user;
    }

    public void setUser(User user) {
            this.user = user;
    }

    @ManyToOne
    public Store_Product getStore_Product() {
        return product;
    }

    public void setStore_Product(Store_Product product) {
        this.product = product;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReviewId that = (ReviewId) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (product != null ? !product.equals(that.product) : that.product != null)
            return false;

        return true;
    }



    public int hashCode() {
        int result;
        result = (user != null ? user.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }
}
