package org.example.managementapplication.service;
import org.example.managementapplication.dao.ProductDAO;

import java.util.List;
import org.example.managementapplication.model.Product;

public interface ProductService {
    List<Product> findAllProduct();
    Product findProductById(int id);
    boolean deleteProductById(int id);
    boolean insertProduct(Product product);
}
