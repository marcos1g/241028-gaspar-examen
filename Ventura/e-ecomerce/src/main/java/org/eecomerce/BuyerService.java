package org.eecomerce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuyerService {
    private static final Logger logger = LoggerFactory.getLogger(BuyerService.class);
    public void createBuyer(String userName) {
        String sql = "INSERT INTO buyers (name) VALUES (?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userName);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                logger.info("User with name " + userName + " was created.");
            }

        } catch (SQLException e) {
            logger.error("Error creating user with name: " + userName, e);
        }
    }

    public Buyer loginBuyer(String userName) {
        String sql = "SELECT * FROM buyers WHERE name = ?";
        Buyer buyer = null;

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userName);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    buyer = new Buyer();
                    buyer.setId(rs.getInt("id"));
                    buyer.setName(rs.getString("name"));
                    //TODO test para ver si trae el user 0-0
                    System.out.println(buyer.toString());

                }
            }
        } catch (SQLException e) {
            logger.error("Error logging in user with name: " + userName, e);
        }

        return buyer;
    }

    public List<Cart> getBuyerCarts(int userId) {
        List<Cart> carts = new ArrayList<>();
        String sql = "SELECT c.id AS id, c.name AS name, c.state AS state " +
                "FROM carts c " +
                "JOIN user_cart uc ON c.id = uc.cart_id " +
                "WHERE uc.user_id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int cartId = rs.getInt("id");
                    String cartName = rs.getString("name");
                    String cartState = rs.getString("state");
                    Cart cart = new Cart(cartId, cartName, cartState);
                    carts.add(cart);
                }
            }
        } catch (SQLException e) {
            logger.error("Error retrieving carts for user id: " + userId, e);
        }

        return carts;
    }

    public void deleteBuyer(int userId) {
        String sql = "DELETE FROM buyers WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                logger.info("User with ID " + userId + " was deleted.");
            }

        } catch (SQLException e) {
            logger.error("Error deleting user with id: " + userId, e);
        }
    }

    public void updateBuyer(int userId, String newName) {
        String sql = "UPDATE buyers SET name = ? WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newName);
            pstmt.setInt(2, userId);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                logger.info("User with ID " + userId + " was updated.");
            } else {
                logger.warn("User with ID " + userId + " was not updated.");
            }
        } catch (SQLException e) {
            logger.error("Error updating user with id: " + userId, e);
        }
    }
}
