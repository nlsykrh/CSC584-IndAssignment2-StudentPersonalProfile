/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nurul
 */

@WebServlet(urlPatterns = {"/DeleteProfileServlet"})
public class DeleteProfileServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        
        if (id != null && !id.trim().isEmpty()) {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentProfilesDB", "app", "app");
                
                String sql = "DELETE FROM profile WHERE id = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, Integer.parseInt(id));
                pstmt.executeUpdate();
                
                pstmt.close();
                conn.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        // Redirect back to view profiles page
        response.sendRedirect("viewProfiles.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}