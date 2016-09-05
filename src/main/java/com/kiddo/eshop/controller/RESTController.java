package com.kiddo.eshop.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.kiddo.eshop.jsonview.Views;
import com.kiddo.eshop.model.Item;
import com.kiddo.eshop.model.Product;
import com.kiddo.eshop.model.Store;
import com.kiddo.eshop.model.Store_Product;
import com.kiddo.eshop.service.UserService;
import com.kiddo.eshop.model.User;
import com.kiddo.eshop.service.ItemService;
import com.kiddo.eshop.service.ProductService;
import com.kiddo.eshop.service.StoreService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
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
        
        @Autowired(required=true)
        @Qualifier(value="itemService")
        private ItemService itemService;
      
    
        public void setUserService(UserService us){
            this.userService = us;
        }
        
        public void setProductService(ProductService ps){
            this.productService = ps;
        }
    
        public void setStoreService(StoreService ss){
            this.storeService = ss;
        }
        
        public void setItemService(ItemService is){
            this.itemService = is;
        }
        
        @JsonView(Views.Public.class)
        @RequestMapping(value="/signin", method=RequestMethod.POST)
        public @ResponseBody User processLogin(HttpServletRequest request){
            String email=request.getParameter("email");
            String password=request.getParameter("password");
            User user = this.userService.login(email,password);
            if(user==null){
                user = new User();
            }
            return user;
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
        @RequestMapping(value="/catalog", method = RequestMethod.GET)
	public @ResponseBody List<Product> product() {
                return this.productService.getProducts();
	}
        
        @JsonView(Views.Public.class)
        @RequestMapping(value="/user/{id}/cart", method = RequestMethod.GET)
	public @ResponseBody List<Product> cart(@PathVariable int id) {
           List<Product> products = new ArrayList(); 
           List<Item> items = this.userService.getCartById(id);
           for(Item item:items){
               products.add(item.getProduct());
           }
           return products;
	}
        
        @JsonView(Views.Public.class)
        @RequestMapping(value="/removefromcart", method=RequestMethod.POST)
        public @ResponseBody String removeFromCart(HttpServletRequest request){
            int user_id=Integer.parseInt(request.getParameter("user_id"));
            int product_id=Integer.parseInt(request.getParameter("product_id"));
            this.itemService.deleteItem(user_id,product_id);
                
            return "success";
        }
        
        @JsonView(Views.Public.class)
        @RequestMapping(value="/addtocart", method=RequestMethod.POST)
        public @ResponseBody String addToCart(HttpServletRequest request){
            int user_id=Integer.parseInt(request.getParameter("user_id"));
            int product_id=Integer.parseInt(request.getParameter("product_id"));
            this.itemService.addItem(user_id,product_id);
                
            return "success";
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
        
        @JsonView(Views.Public.class)
        @RequestMapping(value="/product/{id}/storeproducts", method = RequestMethod.GET)
	public @ResponseBody List<Store_Product> storeproducts(@PathVariable int id) {
                
            return this.productService.getStoreProductsById(id);
	}
	
}
