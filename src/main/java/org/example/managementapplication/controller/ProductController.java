package org.example.managementapplication.controller;

import org.example.managementapplication.dao.ProductDAO;
import org.example.managementapplication.model.Product;
import org.example.managementapplication.service.ProductService;
import org.example.managementapplication.service.ProductServiceImpl;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ProductController", urlPatterns = "/products")
public class ProductController extends HttpServlet {
    private ProductDAO prd;
    ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "update":
                // TODO: update product
                break;
            case "view":
                productDetails(request, response);
                break;
            case "delete":
                productDelete(request, response);
                break;
            default:
                productsList(request, response);
                break;
        }
    }


    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = null;
        try {
            int idProduct = Integer.parseInt(request.getParameter("idProduct"));
            String nameProduct = request.getParameter("nameProduct");
            String brandProduct = request.getParameter("brandProduct");
            double priceProduct = Double.parseDouble(request.getParameter("priceProduct"));
            String descriptionProduct = request.getParameter("descriptionProduct");
            int quantityProduct = Integer.parseInt(request.getParameter("quantityProduct"));

            Product newProduct = new Product(idProduct, nameProduct, brandProduct, priceProduct, descriptionProduct, quantityProduct);
            prd.insertProduct(newProduct);

            // Redirect to /products if the product is added successfully
            response.sendRedirect(request.getContextPath() + "/products");
            return;
        } catch (NumberFormatException e) {
            msg = "Invalid input for price or quantity. Please enter valid numbers.";
        } catch (Exception e) {
            msg = "An error occurred while creating the product: " + e.getMessage();
        }

        // Forward to addProduct.jsp if there's an error
        request.setAttribute("errorMessage", msg);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Product/addProduct.jsp");
        dispatcher.forward(request, response);
    }



    private void productDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = request.getParameter("idProduct") != null ? Integer.valueOf(request.getParameter("idProduct")) : null;
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Product/listProducts.jsp");
        String msg;
        if (productService.deleteProductById(id)) {
            msg = "Xóa sản phẩm thành công";
        } else {
            msg = "Không xóa được sản phẩm";
        }
        request.setAttribute("message", msg);
        response.sendRedirect(request.getContextPath() + "/products");
    }


    private void productsList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Product/listProducts.jsp");
        List<Product> products = productService.findAllProduct();
        request.setAttribute("product", products);
        dispatcher.forward(request, response);
    }


    private void productDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        Integer id = request.getParameter("idProduct") != null ? Integer.valueOf(request.getParameter("idProduct")) : null;
        Product product = productService.findProductById(id);
        if (product == null) {
            response.sendRedirect("404.jsp");
        } else {
            request.setAttribute("p", product);
            dispatcher = request.getRequestDispatcher("/Product/detailProduct.jsp");
            dispatcher.forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }


}
