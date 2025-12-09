package com.pluralsight.NorthwindTradersAPI2.ProductsController;

import com.pluralsight.NorthwindTradersAPI2.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {
    private List<Product> productList;

    public ProductsController(){
        productList = new ArrayList<>();
        productList.add(new Product(1, "Phone", 1, 500));
        productList.add(new Product(2, "Chips", 2, 1.99));
        productList.add(new Product(3, "Soccer", 3, 20.99));
        productList.add(new Product(4, "Drinks", 4, 1.99));
        productList.add(new Product(1, "Head Phone", 5, 79));

    }

   @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> getALlProduct() {
        return productList;
    }

    @RequestMapping(path = "/products/{productid}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable int productId){
    for (Product product : productList) {
        if (product.getProductId() == productId){
            return  product;
        }

    }
    return null;
}

}
