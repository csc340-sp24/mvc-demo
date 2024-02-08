package com.csc340.mvcdemo.controller;

import com.csc340.mvcdemo.model.Product;
import com.csc340.mvcdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author csc340-sp24
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping({"/all", "/", ""})
    public String getAllProducts(Model model) {
        model.addAttribute("productList",
                productService.getAllProducts());
        return "product/product-list";
    }

    @GetMapping("/id={productId}")
    public String getProductById(@PathVariable int productId, Model model) {
        model.addAttribute("product",
                productService.getProductById(productId));
        return "product/product-details";
    }

    @PostMapping("/create")
    public String createProduct(Product product) {
        productService.createProduct(product);
        return "redirect:/products/all";

    }

    @GetMapping("/delete/id={productId}")
    public String deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
        return "redirect:/products/all";
    }

}
