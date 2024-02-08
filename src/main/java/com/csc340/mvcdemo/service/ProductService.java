package com.csc340.mvcdemo.service;

import com.csc340.mvcdemo.model.Product;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author csc340-sp24
 */
@Service
public class ProductService {

    NavigableMap<Integer, Product> products = new TreeMap<>();

    /**
     * Get entire list of products.
     *
     * @return the product list.
     */
    public Collection getAllProducts() {
        if (products.isEmpty()) {
            products.put(0, new Product(0, "sample", 1.25));
        }
        return products.values();
    }

    /**
     * Get a specific product using id.
     *
     * @param productId
     * @return the product.
     */
    public Product getProductById(int productId) {

        return products.get(productId);
    }

    /**
     * Add a new product to the list.
     *
     * @param product
     */
    public void createProduct(Product product) {
        Entry<Integer, Product> lastEntry = products.lastEntry();
        int index = lastEntry.getKey() + 1;
        product.setProductId(index);
        products.put(product.getProductId(), product);

    }

    /**
     * Delete a specific product using id.
     *
     * @param productId
     */
    public void deleteProduct(Integer productId) {
        products.remove(productId);
    }
}
