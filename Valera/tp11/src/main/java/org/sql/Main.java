package org.mysql;

import org.sql.Cart;
import org.sql.Comprador;
import org.sql.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;

        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mp-arg", "root", "");
            //Statement st = conn.createStatement();

            String sql;
            Scanner scanner = new Scanner(System.in);
            String nombre;
            boolean bandera = false;

            while(true){
                System.out.println("Ingresar tu nombre: ");
                nombre = scanner.nextLine();
                sql= "select * from compradores where nombre = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, nombre);
                rs = stmt.executeQuery();
                if(rs.wasNull()){
                    break;
                }
            }

            do {
                // Mostrar las opciones del menú
                System.out.println("MENU DE OPCIONES");
                System.out.println("1. ");
                System.out.println("2. Opción 2");
                System.out.println("3. Opción 3");
                System.out.println("4. Salir");
                System.out.print("Ingrese el número de la opción que desea: ");

                // Leer la opción del usuario
                opcion = scanner.nextInt();

                // Evaluar la opción seleccionada
                switch (opcion) {
                    case 1:
                        System.out.println("Ha seleccionado la opción 1.");
                        // Aquí iría el código correspondiente a la opción 1
                        break;
                    case 2:
                        System.out.println("Ha seleccionado la opción 2.");
                        // Aquí iría el código correspondiente a la opción 2
                        break;
                    case 3:
                        System.out.println("Ha seleccionado la opción 3.");
                        // Aquí iría el código correspondiente a la opción 3
                        break;
                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                        break;
                }
            } while (opcion != 4);

            // Cerrar el scanner al finalizar
            scanner.close();
        }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}