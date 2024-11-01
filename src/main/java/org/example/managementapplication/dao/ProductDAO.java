package org.example.managementapplication.dao;

import org.example.managementapplication.connection.DatabaseConnection;
import org.example.managementapplication.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public static final String SQL_SELECT_ALL = "SELECT * FROM Product";
    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO product (nameProduct, brandProduct, priceProduct, descriptionProduct, quantityProduct) VALUES ( ?, ?, ?, ?, ?);";
    DatabaseConnection dbc = new DatabaseConnection();


    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            con = dbc.getConnection();
            stm = con.createStatement();
            rs = stm.executeQuery(SQL_SELECT_ALL);
            while (rs.next()) {
                int idProduct = rs.getInt("idProduct");
                String nameProduct = rs.getString("nameProduct");
                String brandProduct = rs.getString("brandProduct");
                double priceProduct = rs.getDouble("priceProduct");
                String descriptionProduct = rs.getString("descriptionProduct");
                int quantityProduct = rs.getInt("quantityProduct");
                Product product = new Product(idProduct, nameProduct, brandProduct, priceProduct, descriptionProduct, quantityProduct);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stm != null) stm.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return products;
    }

    public Product getProductById(Integer id) {
        Product p = null;
        Connection con = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            con = dbc.getConnection();
            pStmt = con.prepareStatement("SELECT * FROM Product WHERE idProduct = ?");
            pStmt.setInt(1, id);
            rs = pStmt.executeQuery();
            if (rs.next()) {
                p = new Product();
                p.setIdProduct(rs.getInt("idProduct"));
                p.setNameProduct(rs.getString("nameProduct"));
                p.setBrandProduct(rs.getString("brandProduct"));
                p.setPriceProduct(rs.getDouble("priceProduct"));
                p.setDescriptionProduct(rs.getString("descriptionProduct"));
                p.setQuantityProduct(rs.getInt("quantityProduct"));
                p.setStatusProduct(rs.getString("statusProduct"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pStmt != null) pStmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return p;
    }

    public boolean deleteById(int id) {
        Connection con = null;
        PreparedStatement pStmt = null;
        int countRemove = 0;
        try {
            con = dbc.getConnection();
            pStmt = con.prepareStatement("DELETE FROM product WHERE idProduct = ?");
            pStmt.setInt(1, id);
            countRemove = pStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pStmt != null) pStmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return countRemove > 0;
    }

    public boolean insertProduct(Product newProduct) {
        try (Connection con = dbc.getConnection();
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO product (nameProduct, brandProduct, priceProduct, descriptionProduct, quantityProduct) VALUES (?, ?, ?, ?, ?)")) {
            pstmt.setString(1, newProduct.getNameProduct());
            pstmt.setString(2, newProduct.getBrandProduct());
            pstmt.setDouble(3, newProduct.getPriceProduct());
            pstmt.setString(4, newProduct.getDescriptionProduct());
            pstmt.setInt(5, newProduct.getQuantityProduct());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

