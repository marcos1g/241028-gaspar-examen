package org.mysql;

import org.sql.Buyer;
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
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mp_arg", "root", "");
            //Statement st = conn.createStatement();

            String sql;
            Scanner scanner = new Scanner(System.in);
            String nombre;
            boolean bandera = false;
            int opcion;
            Buyer cmp = new Buyer();

            while(true){
                System.out.println("\nIngresar tu nombre: ");
                nombre = scanner.nextLine();
                sql= "select * from compradores where nombre = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, nombre);
                rs = stmt.executeQuery();
                if(rs.first()){
                    cmp = new Buyer(rs.getInt("id"),rs.getString("nombre"));
                    break;
                }
                else{
                    System.out.println("Nombre invalido.");
                }
            }
            sql= "select * from usuario_carrito inner join carritos on usuario_carrito.carrito_id = carritos.id where usuario_carrito.usuario_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cmp.getId());
            rs = stmt.executeQuery();
            HashMap<Integer,Cart> carts = new HashMap<Integer,Cart>();
            while (rs.next()) {
                carts.put(rs.getInt("id"),new Cart(rs.getString("estado"),rs.getString("nombre")));
            }
            for(Integer c : carts.keySet()){
                sql= "select * from producto_carrito inner join productos on producto_carrito.producto_id = productos.id where producto_carrito.carrito_id = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, c);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println("wazaaaaa");
                    carts.get(c).addProduct(new Product(rs.getInt("id"),rs.getString("nombre"),rs.getDouble("precio")));
                }
            }
            do {
                // Mostrar las opciones del menú
                System.out.println("MENU DE OPCIONES");
                System.out.println("1. Listar Carritos");
                System.out.println("2. Buscar Carrito");
                System.out.println("3. Añadir carrito");
                System.out.println("4. Eliminar Carrito");
                System.out.println("5. Añadir productos a un carrito");
                System.out.println("6. Eliminar productos de un carrito");
                System.out.println("7. Pagar carrito");
                System.out.print("Ingrese el número de la opción que desea: ");

                // Leer la opción del usuario
                opcion = scanner.nextInt();

                // Evaluar la opción seleccionada
                switch (opcion) {
                    case 1:
                        System.out.println("Lista de carritos\n\n");
                        for(Cart c : carts.values()) {
                            System.out.println("Nombre: "+c.getNombre()+"\nEstado: "+c.getState()+"\nProductos añadidos: \n");
                            for(Product p : c.getProducts().values()){
                                System.out.println("Nombre: "+p.getTitle()+"\nPrecio: "+p.getPrice());

                            }
                        }

                        // Aquí iría el código correspondiente a la opción 1
                        break;
                    case 2:
                        System.out.println("Ingrese el nombre del carrito: ");
                        scanner = new Scanner(System.in);
                        String opcionn = scanner.nextLine();
                        for(Cart c : carts.values()){
                            if(opcionn == c.getNombre()){
                                System.out.println("El carrito ha sido encontrado, informe:");
                                System.out.println("Estado de compra: "+c.getState()+"\nProductos:");
                                for(Product p : c.getProducts().values()){
                                    System.out.println("\nNombre: "+p.getTitle()+"\nPrecio: "+p.getPrice());
                                }
                                break;
                            }
                        }
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

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}