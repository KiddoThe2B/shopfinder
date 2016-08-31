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

@Embeddable
public class ItemId implements java.io.Serializable {

    private User user;
    @JsonView(Views.Public.class)
    private Product product;

    @ManyToOne
    public User getUser() {
            return user;
    }

    public void setUser(User user) {
            this.user = user;
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

        ItemId that = (ItemId) o;

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
