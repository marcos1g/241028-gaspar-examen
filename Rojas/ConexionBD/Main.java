package Rojas.ConexionBD;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        Scanner scanner = new Scanner(System.in);

        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cpdb", "root", "");

            while (true) {
                System.out.println("Elige una operación:");
                System.out.println("1. Insertar un nuevo registro");
                System.out.println("2. Actualizar un registro existente");
                System.out.println("3. Eliminar un registro");
                System.out.println("4. Consultar un registro");
                System.out.println("5. Salir");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Ingresa el nombre del comprador: ");
                        String insertName = scanner.nextLine();

                        String insertSql = "INSERT INTO compradores (nombre) VALUES (?)";
                        stmt = conn.prepareStatement(insertSql);
                        stmt.setString(2, insertName);
                        stmt.executeUpdate();
                        System.out.println("Registro insertado.");
                        break;

                    case 2:
                        System.out.print("Ingresa el ID del comprador a actualizar: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Ingresa el nuevo nombre del comprador: ");
                        String updateName = scanner.nextLine();

                        String updateSql = "UPDATE compradores SET nombre = ? WHERE id = ?";
                        stmt = conn.prepareStatement(updateSql);
                        stmt.setString(1, updateName);
                        stmt.setInt(2, updateId);
                        stmt.executeUpdate();
                        System.out.println("Registro actualizado.");
                        break;

                    case 3:
                        System.out.print("Ingresa el ID del comprador a eliminar: ");
                        int deleteId = scanner.nextInt();
                        scanner.nextLine();

                        String deleteSql = "DELETE FROM compradores WHERE id = ?";
                        stmt = conn.prepareStatement(deleteSql);
                        stmt.setInt(1, deleteId);
                        stmt.executeUpdate();
                        System.out.println("Registro eliminado.");
                        break;

                    case 4:
                        System.out.print("Ingresa el ID del comprador a consultar: ");
                        int selectId = scanner.nextInt();
                        scanner.nextLine();

                        String selectSql = "SELECT * FROM compradores WHERE id = ?";
                        stmt = conn.prepareStatement(selectSql);
                        stmt.setInt(1, selectId);
                        rs = stmt.executeQuery();

                        while (rs.next()) {
                            System.out.println("ID: " + rs.getString("id") + "\4n" + "Nombre: " + rs.getString("nombre"));
                        }
                        break;

                    case 5:
                        System.out.println("Saliendo...");
                        return;

                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            scanner.close();
        }
    }
}
