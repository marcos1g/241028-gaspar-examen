import jakarta.servlet.ServletException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;
import java.io.OutputStream;
/**
 * Servlet implementation class Nose
 */
@WebServlet("/Nose")
public class Nose extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/mp_arg";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    
    /**
     * Default constructor. 
     */
    public Nose() {
        super();
    }
    
    private List<Product> getProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM productos");
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("nombre");
                double price = rs.getDouble("precio");
                
                Product product = new Product(id, name, price);
                products.add(product);
            }
        }
        
        return products;
    }
    
    private String getProductsJson() throws SQLException {
        List<Product> products = getProducts();
        Gson gson = new Gson();
        return gson.toJson(products);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String filePath = getServletContext().getRealPath("/index.html");
        String idParam = request.getParameter("p");
        
        if (idParam == null) {
            // Set the content type to text/html
            response.setContentType("text/html");
            
            // Read the HTML file and write it to the response
            try (FileInputStream fis = new FileInputStream(new File(filePath));
                 OutputStream os = response.getOutputStream()) {
                
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            }
        } else {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            
            try {
                String json = getProductsJson();
                response.getWriter().write(json);
            } catch (SQLException e) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error retrieving data from the database.");
            }
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    // Inner class for Product
    private static class Product {
        private int id;
        private String name;
        private double price;

        public Product(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }
}