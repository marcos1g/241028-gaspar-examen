package org.sql;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;

        try{
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/tp11" , "root", "");

            String sql = "SELECT * FROM productos";
            stmt = conn.prepareStatement(sql);
            rs= stmt.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("nombre")+"  "+rs.getString("precio"));
            }

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}