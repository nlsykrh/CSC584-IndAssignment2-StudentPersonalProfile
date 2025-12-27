/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

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

@WebServlet(urlPatterns = {"/UpdateProfileServlet"})
public class UpdateProfileServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String studentId = request.getParameter("studentId");
            String program = request.getParameter("program");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String dob = request.getParameter("dob");
            String favColours = request.getParameter("favColours");
            String favFood = request.getParameter("favFood");
            String hobbies = request.getParameter("hobbies");
            
            // Get languages as array
            String[] languagesArray = request.getParameterValues("languages");
            String languages = "";
            if (languagesArray != null) {
                languages = String.join(", ", languagesArray);
            }
            
            String education = request.getParameter("education");
            
            // Get skills as array
            String[] skillsArray = request.getParameterValues("skills");
            String skills = "";
            if (skillsArray != null) {
                skills = String.join(", ", skillsArray);
            }
            
            String achievement = request.getParameter("achievement");
            String goals = request.getParameter("goals");
            String intro = request.getParameter("intro");

            // Database connection and update
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentProfiles", "app", "app");
            
            String sql = "UPDATE profile SET name=?, program=?, phone=?, email=?, dob=?, fav_colour=?, fav_food=?, hobbies=?, languages=?, education=?, skills=?, achievement=?, goals=?, intro=? WHERE id=?";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, program);
            pstmt.setString(3, phone);
            pstmt.setString(4, email);
            pstmt.setString(5, dob);
            pstmt.setString(6, favColours);
            pstmt.setString(7, favFood);
            pstmt.setString(8, hobbies);
            pstmt.setString(9, languages);
            pstmt.setString(10, education);
            pstmt.setString(11, skills);
            pstmt.setString(12, achievement);
            pstmt.setString(13, goals);
            pstmt.setString(14, intro);
            pstmt.setInt(15, Integer.parseInt(id));
            
            pstmt.executeUpdate();
            
            // Redirect to profile details page
            response.sendRedirect("profileDetails.jsp?id=" + id);
            
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error updating profile: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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