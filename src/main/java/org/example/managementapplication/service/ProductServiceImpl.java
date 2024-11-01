package org.example.managementapplication.service;

import org.example.managementapplication.dao.ProductDAO;
import org.example.managementapplication.model.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO = new ProductDAO();

    @Override
    public List<Product> findAllProduct() {
        return productDAO.getAllProducts();
    }

    @Override
    public Product findProductById(int id) {
        return productDAO.getProductById(id);
    }

    @Override
    public boolean deleteProductById(int id) {
        return productDAO.deleteById(id);
    }

    @Override
    public boolean insertProduct(Product product) {
        return productDAO.insertProduct(product);
    }
}
