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
    private StoreProduct storeproduct;

    @ManyToOne
    public User getUser() {
            return user;
    }

    public void setUser(User user) {
            this.user = user;
    }

    @ManyToOne
    public StoreProduct getStoreProduct() {
        return storeproduct;
    }

    public void setStoreProduct(StoreProduct storeproduct) {
        this.storeproduct = storeproduct;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReviewId that = (ReviewId) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (storeproduct != null ? !storeproduct.equals(that.storeproduct) : that.storeproduct != null)
            return false;

        return true;
    }



    public int hashCode() {
        int result;
        result = (user != null ? user.hashCode() : 0);
        result = 31 * result + (storeproduct != null ? storeproduct.hashCode() : 0);
        return result;
    }
}
