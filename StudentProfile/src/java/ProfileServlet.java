/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import model.ProfileBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nurul
 */
@WebServlet(urlPatterns = {"/ProfileServlet"})
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            // Get all form data
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

            // Create ProfileBean object
            ProfileBean profile = new ProfileBean();
            profile.setName(name);
            profile.setStudentId(studentId);
            profile.setProgram(program);
            profile.setPhone(phone);
            profile.setEmail(email);
            profile.setDob(dob);
            profile.setFavColour(favColours);
            profile.setFavFood(favFood);
            profile.setHobbies(hobbies);
            profile.setLanguages(languages);
            profile.setEducation(education);
            profile.setSkills(skills);
            profile.setAchievement(achievement);
            profile.setGoals(goals);
            profile.setIntro(intro);

            // Database connection and insertion
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentProfiles", "app", "app");
            
            String sql = "INSERT INTO profile (name, student_id, program, phone, email, dob, fav_colour, fav_food, hobbies, languages, education, skills, achievement, goals, intro) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, profile.getName());
            pstmt.setString(2, profile.getStudentId());
            pstmt.setString(3, profile.getProgram());
            pstmt.setString(4, profile.getPhone());
            pstmt.setString(5, profile.getEmail());
            pstmt.setString(6, profile.getDob());
            pstmt.setString(7, profile.getFavColour());
            pstmt.setString(8, profile.getFavFood());
            pstmt.setString(9, profile.getHobbies());
            pstmt.setString(10, profile.getLanguages());
            pstmt.setString(11, profile.getEducation());
            pstmt.setString(12, profile.getSkills());
            pstmt.setString(13, profile.getAchievement());
            pstmt.setString(14, profile.getGoals());
            pstmt.setString(15, profile.getIntro());
            
            pstmt.executeUpdate();
            
            // Send ProfileBean object to JSP
            request.setAttribute("profile", profile);
            
            // Forward to profile.jsp
            request.getRequestDispatcher("profile.jsp").forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}