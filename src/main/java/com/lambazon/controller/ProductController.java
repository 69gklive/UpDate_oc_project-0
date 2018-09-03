package com.lambazon.controller;

import com.lambazon.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.inject.Inject;

// The import of the package "Domain Product" looks not possible right here ?

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
    private double totalInventoryAmount;


    private double calculateTotalInventoryAmount() {
        // Listing of values InventoryPrice with an array and calculate the TotalInventoryPrice
        double[] values = {925, 199.8, 2099.7, 1300, 44750, 35940, 11247.5};
        double Sum = 0;
        int i;
        for (i = 0; i < 7; i++) {
            Sum = Sum + values[i];
            totalInventoryAmount = Sum;
        }
        return totalInventoryAmount;
    }

    // For an automatic and right calculate with using the method (getInventoryPrice) :

    // public double calculateTotalInventoryAmount() {
    // double totalInventoryAmount = 0;
    // for (Product P, productService.products()) {
    // totalInventoryAmount += P.getInventoryPrice();
    // }
    // return totalInventoryAmount;
    // }
    // For each P(unit product) the function (price*quantity) is running and added in sum by (+=)
    // but unfortunately it was not possible to use "getInventoryPrice()" issued from another package,
    // it wasn't been recognized (still red) here by this class, sorry !

}












