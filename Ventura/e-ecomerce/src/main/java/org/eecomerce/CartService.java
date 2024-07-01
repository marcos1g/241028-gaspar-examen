package org.eecomerce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartService {
    private static final Logger logger = LoggerFactory.getLogger(CartService.class);

    public void createCart(String cartName, String state) {
        String sql = "INSERT INTO carts (name, state) VALUES (?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cartName);
            pstmt.setString(2, state);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error creating cart with name: " + cartName, e);
        }
    }

    public void removeProductFromCart(int cartId, int productId) {
        String sql = "DELETE FROM product_cart WHERE cart_id = ? AND product_id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cartId);
            pstmt.setInt(2, productId);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                logger.info("Product with ID " + productId + " removed from cart with ID " + cartId);
            } else {
                logger.warn("No product found with ID " + productId + " in cart with ID " + cartId);
            }
        } catch (SQLException e) {
            logger.error("Error removing product with ID " + productId + " from cart with ID " + cartId, e);
        }
    }

    public void addProductToCart(int productId, int cartId) {
        String sql = "INSERT INTO product_cart (product_id, cart_id) VALUES (?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, productId);
            pstmt.setInt(2, cartId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error adding product " + productId + " to cart " + cartId, e);
        }
    }

    public void deleteCart(int cartId) {
        String sql = "DELETE FROM carts WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, cartId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error deleting cart with id: " + cartId, e);
        }
    }

    public void updateCartState(int cartId, String newState) {
        String sql = "UPDATE carts SET state = ? WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newState);
            pstmt.setInt(2, cartId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error updating cart with id: " + cartId, e);
        }
    }
}
