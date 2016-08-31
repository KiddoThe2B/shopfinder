package com.kiddo.eshop.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.kiddo.eshop.jsonview.Views;
import com.kiddo.eshop.model.Item;
import com.kiddo.eshop.model.Product;
import com.kiddo.eshop.model.Store;
import com.kiddo.eshop.model.Store_Product;
import com.kiddo.eshop.service.UserService;
import com.kiddo.eshop.model.User;
import com.kiddo.eshop.service.ProductService;
import com.kiddo.eshop.service.StoreService;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles requests for the application home page.
 */
@RestController
public class RESTController {
	
	private static final Logger logger = LoggerFactory.getLogger(RESTController.class);
	
        
        @Autowired(required=true)
        @Qualifier(value="userService")
        private UserService userService;
        
        @Autowired(required=true)
        @Qualifier(value="productService")
        private ProductService productService;
        
        @Autowired(required=true)
        @Qualifier(value="storeService")
        private StoreService storeService;
      
    
        public void setUserService(UserService us){
            this.userService = us;
        }
        
        public void setProductService(ProductService ps){
            this.productService = ps;
        }
    
        public void setStoreService(StoreService ss){
            this.storeService = ss;
        }
        
        @JsonView(Views.Public.class)
        @RequestMapping(value="/user/{id}/account", method = RequestMethod.GET)
	public @ResponseBody User account(@PathVariable int id) {
                
                return this.userService.getUserByID(id);
	}
        
        @JsonView(Views.Public.class)
        @RequestMapping(value="/product/{id}", method = RequestMethod.GET)
	public @ResponseBody Product product(@PathVariable int id) {
                
                return this.productService.getProductById(id);
	}
        
        @JsonView(Views.Public.class)
        @RequestMapping(value="/user/{id}/cart", method = RequestMethod.GET)
	public @ResponseBody List<Item> cart(@PathVariable int id) {
                
            return this.userService.getCartById(id);
	}
        
        @JsonView(Views.Public.class)
        @RequestMapping(value="/store/{id}", method = RequestMethod.GET)
	public @ResponseBody Store store(@PathVariable int id) {
                
                return this.storeService.getStoreById(id);
	}
        
        @JsonView(Views.Public.class)
        @RequestMapping(value="/product/{id}/shops", method = RequestMethod.GET)
	public @ResponseBody Set<Store> shops(@PathVariable int id) {
                
            return this.productService.getShopsById(id);
	}
	
}
