package org.tp11;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

import static javax.swing.JOptionPane.*;

public class Screen extends JFrame {
    private JButton ingresarButton;
    private JButton crearUsuarioButton;
    private JTextField text;
    private JPanel panel1;
    int usuarioID = -1;
    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;
    public Screen() {
        setContentPane(panel1);
        setTitle("Welcome");
        setSize(500, 200);
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 20, 40, 20));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        crearUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = text.getText(); // Obtener el nombre de usuario del JTextField
                try {
                    conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/tp11_dev", "root", "");

                    // Verificar si el usuario ya existe
                    String checkSql = "SELECT COUNT(*) AS count FROM compradores WHERE nombre = ?";
                    PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                    checkStmt.setString(1, usuario);
                    ResultSet checkRs = checkStmt.executeQuery();
                    checkRs.next();
                    int count = checkRs.getInt("count");

                    if (count > 0) {
                        showMessageDialog(null, "El usuario ya existe en la base de datos.");
                    } else {
                        // Insertar el nuevo usuario
                        String sql = "INSERT INTO compradores (nombre) VALUES (?)";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, usuario);
                        int insertCount = stmt.executeUpdate();
                        if (insertCount > 0) {
                            showMessageDialog(null, "Usuario creado con éxito");
                            text.setText(""); // Limpiar el JTextField después de la creación
                        } else {
                            showMessageDialog(null, "El usuario no pudo ser creado");
                        }
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } finally {
                    // Cerrar recursos en el bloque finally
                    try {
                        if (stmt != null) {
                            stmt.close();
                        }
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = text.getText(); // Obtener el DNI del JTextField
                try {
                    conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/tp11_dev", "root", "");
                    //Statement st = conn.createStatement();

                    String sql= "SELECT * FROM compradores WHERE nombre = ?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, usuario);
                    rs = stmt.executeQuery();
                    if(rs.next()){
                        usuarioID = rs.getInt("id");
                        showCartsScreen();
                    }else{
                        showMessageDialog(null, "El usuario no existe");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }

    private void showProductsScreen(int cartID) {
        // Close the current frame
        dispose();

        // Create a new frame for displaying products
        JFrame productFrame = new JFrame("Productos");
        productFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        productFrame.setSize(900, 400);

        JPanel panel = new JPanel();
        productFrame.add(panel);
        panel.setLayout(null);

        // Table to display products
        String[] columnNames = {"ID", "Nombre", "Precio"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        JTable table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Hacer que la tabla no sea editable
                return false;
            }
        };
        model.setColumnIdentifiers(columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 850, 300);
        panel.add(scrollPane);

        // Load products into the table
        loadProducts(model);

        // Button for the cart
        JButton cartButton = new JButton("Carritos");
        JButton addProd = new JButton("Agregar");
        JButton showCart = new JButton("Ver carrito");
        JButton crearProducto = new JButton("Crear producto");
        JButton eliminarProducto = new JButton("Eliminar producto"); // New button for deleting products
        addProd.setBounds(10, 320, 170, 25);
        crearProducto.setBounds(200, 320, 170, 25);
        cartButton.setBounds(400, 320, 100, 25);
        eliminarProducto.setBounds(520, 320, 170, 25);
        showCart.setBounds(700, 320, 159, 25);// Positioning the delete button
        panel.add(cartButton);
        panel.add(crearProducto);
        panel.add(eliminarProducto); // Adding the delete button to the panel
        panel.add(showCart);
        panel.add(addProd);
        crearProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCreateProductDialog();
                int rowCount = model.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                    model.removeRow(i);
                }
                loadProducts(model);
            }
        });
        eliminarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if a row is selected
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione un producto para eliminar.");
                    return;
                }

                // Get the product ID from the selected row
                int productID = (int) table.getValueAt(selectedRow, 0);

                // Perform deletion in database
                deleteProduct(productID);

                // Remove the row from the table model
                model.removeRow(selectedRow);
            }
        });
        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCartsScreen();
            }
        });
        addProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                int productID = (int) table.getValueAt(selectedRow, 0);
                addProductCart(productID, cartID);
            }
        });
        showCart.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            showCartScreen(cartID);
        }
    });
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        // Get the product ID from the selected row
                        int productID = (int) table.getValueAt(selectedRow, 0);
                        String nombre = (String) table.getValueAt(selectedRow, 1);
                        double precio = (double) table.getValueAt(selectedRow, 2);
                        showEditProductDialog(productID, nombre, precio, model, selectedRow);
                    }
                }
            }
        });
        productFrame.setVisible(true);
    }


    private void showEditProductDialog(int productID, String nombre, double precio, DefaultTableModel model, int rowIndex) {
        JDialog editDialog = new JDialog();
        editDialog.setTitle("Editar Producto");
        editDialog.setSize(300, 200);
        editDialog.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3, 2));

        panel.add(new JLabel("Nombre:"));
        JTextField nombreField = new JTextField(nombre);
        panel.add(nombreField);

        panel.add(new JLabel("Precio:"));
        JTextField precioField = new JTextField(String.valueOf(precio));
        panel.add(precioField);

        JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newNombre = nombreField.getText();
                double newPrecio = Double.parseDouble(precioField.getText());

                // Update the product in the database
                updateProduct(productID, newNombre, newPrecio);

                // Update the table model
                model.setValueAt(newNombre, rowIndex, 1);
                model.setValueAt(newPrecio, rowIndex, 2);

                editDialog.dispose();
            }
        });

        panel.add(saveButton);

        editDialog.add(panel, BorderLayout.CENTER);
        editDialog.setVisible(true);
    }

    private void updateProduct(int productID, String nombre, double precio) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/tp11_dev", "root", "");
            String sql = "UPDATE productos SET nombre = ?, precio = ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setDouble(2, precio);
            stmt.setInt(3, productID);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void showCartsScreen() {
        // Close the current frame
        dispose();

        // Create a new frame for displaying products
        JFrame productFrame = new JFrame("Carritos");
        productFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        productFrame.setSize(600, 400);

        JPanel panel = new JPanel();
        productFrame.add(panel);
        panel.setLayout(null);

        // Table to display products
        String[] columnNames = {"ID", "Nombre", "Estado"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        JTable table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Hacer que la tabla no sea editable
                return false;
            }
        };
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Permitir solo selección de una fila
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 560, 300);
        panel.add(scrollPane);

        // Load products into the table
        loadCarts(model);

        // Button for cart actions
        JButton cartPayButton = new JButton("Pagar carrito");
        JButton createCartButton = new JButton("Crear carrito");
        JButton deleteCartButton = new JButton("Eliminar carrito");
        cartPayButton.setBounds(250, 320, 100, 25);
        createCartButton.setBounds(75, 320, 170, 25);
        deleteCartButton.setBounds(350, 320, 170, 25);
        panel.add(cartPayButton);
        panel.add(createCartButton);
        panel.add(deleteCartButton);

        // Action listener for create cart button
        createCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCreateCartDialog();
                // Reload carts after creating a new one
                int rowCount = model.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                    model.removeRow(i);
                }
                loadCarts(model);
            }
        });

        deleteCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if a row is selected
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione un carrito para eliminar.");
                    return;
                }

                // Get the product ID from the selected row
                int cartID = (int) table.getValueAt(selectedRow, 0);

                // Perform deletion in database
                deleteCart(cartID);

                // Remove the row from the table model
                model.removeRow(selectedRow);
            }
        });

        // Mouse listener for table (to handle double-click for showing products)
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        // Get cart ID from the selected row
                        int cartID = (int) table.getValueAt(selectedRow, 0);
                        showProductsScreen(cartID);
                    }
                }
            }
        });

        // Action listener for cart payment button (if needed)
        cartPayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement payment logic if required
            }
        });

        // Make the frame visible
        productFrame.setVisible(true);
    }



    private void showCartScreen(int cartID) {
        // Close the current frame
        dispose();

        // Create a new frame for displaying products
        JFrame productFrame = new JFrame("Carrito");
        productFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        productFrame.setSize(600, 400);

        JPanel panel = new JPanel();
        productFrame.add(panel);
        panel.setLayout(null);

        // Table to display products
        String[] columnNames = {"ID", "Producto", "Precio"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        JTable table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Hacer que la tabla no sea editable
                return false;
            }
        };
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Permitir solo selección de una fila
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 560, 300);
        panel.add(scrollPane);

        // Load products into the table
        loadCart(model, cartID, usuarioID);

        // Button for cart actions
        JButton cartPayButton = new JButton("Pagar carrito");
        JButton goBackProd = new JButton("Productos");
        JButton deleteCartButton = new JButton("Eliminar producto");
        cartPayButton.setBounds(250, 320, 100, 25);
        goBackProd.setBounds(75, 320, 170, 25);
        deleteCartButton.setBounds(350, 320, 170, 25);
        panel.add(cartPayButton);
        panel.add(goBackProd);
        panel.add(deleteCartButton);

        // Action listener for create cart button
        goBackProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            showProductsScreen(cartID);
            }
        });

        deleteCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if a row is selected
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione un producto para eliminar.");
                    return;
                }

                // Get the product ID from the selected row
                int productID = (int) table.getValueAt(selectedRow, 0);

                // Perform deletion in database
                deleteProdCart(productID, cartID);

                // Remove the row from the table model
                model.removeRow(selectedRow);
            }
        });

        // Action listener for cart payment button (if needed)
        cartPayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement payment logic if required
            }
        });

        // Make the frame visible
        productFrame.setVisible(true);
    }





    private void deleteProdCart(int productID, int cartID) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/tp11_dev", "root", "");
            String sql = "DELETE FROM producto_carrito WHERE producto_id = ? AND carrito_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, productID);
            stmt.setInt(2, cartID);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Cerrar recursos (Statement y Connection)
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }





    private void addProductCart(int productID, int cartID) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/tp11_dev", "root", "");
            String sql = "INSERT INTO producto_carrito (producto_id, carrito_id) VALUES (?, ?)";
            stmt = conn.prepareStatement(sql);

            // Set the parameters for the statement
            stmt.setInt(1, productID);
            stmt.setInt(2, cartID);

            // Execute the update
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
                // Aquí puedes agregar código adicional si es necesario
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar el producto.");
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



    private void deleteProduct(int productID) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/tp11_dev", "root", "");
            String sql = "DELETE FROM productos WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, productID);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Cerrar recursos (Statement y Connection)
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


    private void deleteCart(int cartID) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/tp11_dev", "root", "");
            String sql = "DELETE carritos, usuario_carrito, producto_carrito " +
                    "FROM carritos " +
                    "INNER JOIN usuario_carrito ON carritos.id = usuario_carrito.carrito_id " +
                    "LEFT JOIN producto_carrito ON carritos.id = producto_carrito.carrito_id " +
                    "WHERE carritos.id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cartID);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Cerrar recursos (Statement y Connection)
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }



    private void loadCart(DefaultTableModel model, int cartID, int usuarioID) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/tp11_dev", "root", "");
            String sql = "SELECT p.id, p.nombre, p.precio " +
                    "FROM productos p " +
                    "JOIN producto_carrito pc ON p.id = pc.producto_id " +
                    "JOIN usuario_carrito uc ON pc.carrito_id = uc.carrito_id " +
                    "JOIN carritos c ON pc.carrito_id = c.id " +
                    "WHERE pc.carrito_id = ? AND uc.usuario_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cartID);
            stmt.setInt(2, usuarioID);
            rs = stmt.executeQuery();

            // Limpiar el modelo antes de agregar nuevos datos
            model.setRowCount(0);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                model.addRow(new Object[]{id, nombre, precio});
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



    private void loadProducts(DefaultTableModel model) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/tp11_dev", "root", "");
            String sql = "SELECT * FROM productos"; // Assuming you have a 'productos' table
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                model.addRow(new Object[]{id, nombre, precio});
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
}

    private void loadCarts(DefaultTableModel model) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/tp11_dev", "root", "");
            String sql = "SELECT * FROM carritos INNER JOIN usuario_carrito ON carritos.id = usuario_carrito.carrito_id WHERE usuario_carrito.usuario_id = "+ usuarioID; // Assuming you have a 'productos' table
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String estado = rs.getString("estado");
                model.addRow(new Object[]{id, nombre, estado});
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void openCreateCartDialog() {
        JDialog dialog = new JDialog(this, "Crear carrito", true);
        dialog.setSize(200, 100);
        JPanel inputPanel = new JPanel(new GridLayout(1, 1));
        JLabel nameLabel = new JLabel("Nombre:");
        JTextField nameField = new JTextField();
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);


        dialog.add(inputPanel, BorderLayout.CENTER);

        // Panel for the button
        JPanel buttonPanel = new JPanel(new BorderLayout());
        JButton createButton = new JButton("Crear");
        buttonPanel.add(createButton, BorderLayout.CENTER);

        dialog.add(buttonPanel, BorderLayout.SOUTH);



        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nameField.getText();

                String sql = "INSERT INTO carritos (nombre, estado) VALUES (?, 0)";

                try (Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/tp11_dev", "root", "");
                     PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {


                    stmt.setString(1, nombre);


                    int rowsAffected = stmt.executeUpdate();

                    if (rowsAffected == 1) {
                        // Si se insertó correctamente en carritos, obtenemos el ID generado
                        ResultSet generatedKeys = stmt.getGeneratedKeys();
                        if (generatedKeys.next()) {
                            int carritoId = generatedKeys.getInt(1); // Obtenemos el ID de carritos insertado


                            String sqlUsuarioCarrito = "INSERT INTO usuario_carrito (carrito_id, usuario_id) VALUES (?, ?)";
                            PreparedStatement stmtUsuarioCarrito = conn.prepareStatement(sqlUsuarioCarrito);


                            stmtUsuarioCarrito.setInt(1, carritoId); // Usamos el ID de carritos generado
                            stmtUsuarioCarrito.setInt(2, usuarioID); // Supongamos que tienes el ID del usuario

                            // Ejecutamos la inserción en usuario_carrito
                            int rowsAffectedUsuarioCarrito = stmtUsuarioCarrito.executeUpdate();

                            if (rowsAffectedUsuarioCarrito == 1) {
                                System.out.println("Se ha insertado correctamente en carritos y usuario_carrito.");
                            } else {
                                System.out.println("Error al insertar en usuario_carrito.");
                            }

                            stmtUsuarioCarrito.close();
                        } else {
                            System.out.println("No se pudo obtener el ID generado de carritos.");
                        }

                        generatedKeys.close();
                    } else {
                        System.out.println("Error al insertar en carritos.");
                    }
                } catch (SQLException x) {
                    x.printStackTrace();
                }
                dispose();
            }
        });

        dialog.setVisible(true);
    }



    private void openCreateProductDialog() {
        JDialog dialog = new JDialog(this, "Crear Producto", true);
        dialog.setSize(200, 100);
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        JLabel nameLabel = new JLabel("Nombre:");
        JTextField nameField = new JTextField();
        JLabel priceLabel = new JLabel("Precio:");
        JTextField priceField = new JTextField();
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);

        dialog.add(inputPanel, BorderLayout.CENTER);

        // Panel for the button
        JPanel buttonPanel = new JPanel(new BorderLayout());
        JButton createButton = new JButton("Crear");
        buttonPanel.add(createButton, BorderLayout.CENTER);

        dialog.add(buttonPanel, BorderLayout.SOUTH);



        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nameField.getText();
                double precio;
                try {
                    precio = Double.parseDouble(priceField.getText());
                } catch (NumberFormatException ex) {
                    showMessageDialog(dialog, "Precio inválido");
                    return;
                }

                try {
                    conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/tp11_dev", "root", "");
                    String sql = "INSERT INTO productos (nombre, precio) VALUES (?, ?)";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, nombre);
                    stmt.setDouble(2, precio);
                    int count = stmt.executeUpdate();
                    if (count > 0) {
                        showMessageDialog(dialog, "Producto creado con éxito");
                        dialog.dispose();
                    } else {
                        showMessageDialog(dialog, "El producto no pudo ser creado");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        dialog.setVisible(true);
    }
}
