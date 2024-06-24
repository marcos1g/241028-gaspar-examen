package org.eecomerce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public void createProduct(String productName, double price){
        String sql = "INSERT INTO products (name, price) VALUES (?, ?)";

        try(Connection conn = DatabaseConfig.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, productName);
            pstmt.setDouble(2, price);
            pstmt.executeUpdate();
        } catch (SQLException e){
            logger.error("Error creating product with name: " + productName, e);
        }
    }

    public void updateProduct(int productId, String newName, double newPrice) {
        String sql = "UPDATE products SET name = ?, price = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newName);
            pstmt.setDouble(2, newPrice);
            pstmt.setInt(3, productId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error updating product with id: " + productId, e);
        }
    }

    public void deleteProduct(int productId) {
        String sql = "DELETE FROM products WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, productId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error deleting product with id: " + productId, e);
        }
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                Product product = new Product(id, name, price);
                products.add(product);
            }
        } catch (SQLException e) {
            logger.error("Error retrieving products", e);
        }

        return products;
    }
}