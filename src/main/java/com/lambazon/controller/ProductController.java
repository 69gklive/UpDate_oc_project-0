package com.lambazon.controller;

import com.lambazon.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.inject.Inject;

// Import the method from another package to use it in this class for calculating the TotalInventoryAmount
import static com.lambazon.domain.Product.getInventoryPrice;


@Controller
public class ProductController {


    @Inject
    private ProductService productService;

    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("prods", productService.products());
        model.addAttribute("totalInventoryAmount", calculateTotalInventoryAmount());
        return "products";
    }

    @GetMapping("/products/{id}/details")
    public String product(@PathVariable Integer id, Model model) {
        model.addAttribute("prod", productService.product(id));
        return "product";
    }


     // Declaration of the variable
     public double TotalInventoryAmount;

     private double calculateTotalInventoryAmount() {
     //Calculate the TotalInventoryAmount by using the method getInventoryPrice
     // The Total makes the sum (+=) of this function (quantity*price) for each product listed
            TotalInventoryAmount = 0;
            TotalInventoryAmount += getInventoryPrice();

            return TotalInventoryAmount;
     }

}












