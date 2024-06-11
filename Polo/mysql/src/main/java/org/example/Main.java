package org.example;

import java.sql.*;


public class Main {
    public static void main(String[] args) {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;

        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mp", "root", "");
            //Statement st = conn.createStatement();

            String sql= "SELECT `id`, `nombre`, `estado` FROM `carritos` WHERE id=?   ";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 2);
            rs = stmt.executeQuery();

            while(rs.next()){

                System.out.println(rs.getString("nombre"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}