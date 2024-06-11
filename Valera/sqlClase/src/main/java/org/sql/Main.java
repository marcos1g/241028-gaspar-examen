package org.mysql;

import java.sql.*;


public class Main {
    public static void main(String[] args) {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;

        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test", "root", "");
            //Statement st = conn.createStatement();

            String sql= "select * from usuarios where id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 1);
            rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("nombre_completo"));
            }
            sql= "insert into usuarios(nombre_completo) values(?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "anthony");
            stmt.executeUpdate();
            sql= "DELETE FROM usuarios\n" +
                    "WHERE id = (\n" +
                    "    SELECT id\n" +
                    "    FROM usuarios\n" +
                    "    ORDER BY id DESC\n" +
                    "    LIMIT 1\n" +
                    ");";
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            sql= "UPDATE usuarios SET nombre_completo = ? WHERE id = (\n" +
                    "    SELECT id\n" +
                    "    FROM usuarios\n" +
                    "    ORDER BY id DESC\n" +
                    "    LIMIT 1\n" +
                    ");";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "manuel");
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}