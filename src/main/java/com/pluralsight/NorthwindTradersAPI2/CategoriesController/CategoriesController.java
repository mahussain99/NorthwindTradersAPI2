package com.pluralsight.NorthwindTradersAPI2.CategoriesController;

import com.pluralsight.NorthwindTradersAPI2.models.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {
    private List<Category> categoryList;

    public CategoriesController(){
        categoryList = new ArrayList<>();

        categoryList.add(new Category(1, "Electronics" ));
        categoryList.add(new Category(2, "Food" ));
        categoryList.add(new Category(3, "OutDoors" ));
        categoryList.add(new Category(1, "Beverage" ));
        categoryList.add(new Category(1, "Electronics" ));

    }
@RequestMapping(path = "/categories", method = RequestMethod.GET)
    public List<Category> getAllCatergories() {
        return categoryList;
    }
    @RequestMapping(path = "/categories/{categoryId}", method = RequestMethod.GET)
    public Category getCategoriesById(@PathVariable int categoryId){
        for (Category category : categoryList) {
            if (category.getCategoryId() == categoryId){
                return category;

            }

        }

        return null;
    }


}
