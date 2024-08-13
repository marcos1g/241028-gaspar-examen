import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;
import java.io.OutputStream;
 /* Servlet implementation class Nose
 */
@WebServlet("/Tampoco")
public class Tampoco extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    String url = "jdbc:mariadb://localhost:3306/mp_arg";
    String user = "tu_usuario";
    String password = "tu_contraseña";
    
    
    
    /**
     * Default constructor. 
     */
    public Tampoco() {
        super();
    }
    
    private String getProducts() throws SQLException {
    	try {
            // Cargar el controlador JDBC
            Class.forName("org.mariadb.jdbc.client");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Driver not found");
        }
        
        Connection conn = DriverManager.getConnection(url, user, password);
        return "aaaa";
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("p");
        
            response.setCharacterEncoding("UTF-8");
            
            try {
                response.getWriter().write(getProducts());
            } catch (SQLException e) {
                response.getWriter().write("llorelooooo :v: "+e.getMessage());
            }
        
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}