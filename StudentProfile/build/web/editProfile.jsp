<%-- 
    Document   : editProfile
    Created on : Dec 24, 2025, 10:27:28 AM
    Author     : nurul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Edit Profile</title>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&family=Playfair+Display:wght@600&display=swap" rel="stylesheet">
        <style>
            body {
                margin: 0;
                padding: 20px;
                font-family: "Inter", sans-serif;
                background: linear-gradient(135deg, #ffe6f2, #e3f2ff, #fff8cc);
                background-size: 300% 300%;
                animation: pastelFlow 10s ease infinite;
                min-height: 100vh;
            }

            @keyframes pastelFlow {
                0% { background-position: 0% 50%; }
                50% { background-position: 100% 50%; }
                100% { background-position: 0% 50%; }
            }

            .container {
                width: 100%;
                max-width: 800px;
                background: #ffffff;
                padding: 40px;
                border-radius: 16px;
                box-shadow: 0 8px 40px rgba(0,0,0,0.08);
                border: 1px solid rgba(255,182,193,0.2);
                margin: 0 auto;
            }

            .main-title {
                text-align: center;
                font-family: 'Playfair Display', serif;
                font-size: 32px;
                color: #2c3e50;
                margin-bottom: 8px;
                font-weight: 600;
            }

            .subtitle {
                text-align: center;
                color: #7f8c8d;
                font-size: 14px;
                margin-bottom: 30px;
                font-weight: 400;
            }

            .section-title {
                font-size: 18px;
                font-weight: 600;
                color: #3498db;
                margin-top: 30px;
                margin-bottom: 8px;
                padding-left: 8px;
                border-left: 3px solid #ff6b95;
            }

            .divider {
                height: 1px;
                background: linear-gradient(90deg, transparent, #ffb6d9, #a7c7ff, transparent);
                margin-bottom: 20px;
                margin-top: 5px;
            }

            label {
                font-weight: 500;
                color: #2c3e50;
                font-size: 14px;
                display: block;
                margin-bottom: 6px;
            }

            input, textarea, select {
                width: 97%;
                padding: 14px;
                margin-bottom: 20px;
                border-radius: 8px;
                border: 1.5px solid #e1e8ed;
                background-color: #f5f9fc;
                font-family: "Inter", sans-serif;
                font-size: 14px;
                transition: all 0.3s ease;
            }

            input:focus, textarea:focus, select:focus {
                outline: none;
                border-color: #3498db;
                background-color: #ffffff;
                box-shadow: 0 0 0 3px rgba(52, 152, 219, 0.1);
            }

            textarea {
                height: 110px;
                resize: vertical;
            }

            /* Language Checkbox Styling */
            .language-container {
                background: #f5f9fc;
                border: 1.5px solid #e1e8ed;
                border-radius: 8px;
                padding: 15px;
                margin-bottom: 20px;
                max-height: 200px;
                overflow-y: auto;
            }
            
            /* Skills Checkbox Styling */
            .skills-container {
                background: #f5f9fc;
                border: 1.5px solid #e1e8ed;
                border-radius: 8px;
                padding: 15px;
                margin-bottom: 20px;
                max-height: 200px;
                overflow-y: auto;
            }

            .skill-option {
                margin-bottom: 12px;
                display: flex;
                align-items: center;
                padding: 8px;
                border-radius: 6px;
                transition: background-color 0.2s;
            }

            .skill-option:hover {
                background-color: #e3f2ff;
            }

            .skill-option input[type="checkbox"] {
                width: 18px;
                height: 18px;
                margin: 0 12px 0 0;
                cursor: pointer;
            }

            .skill-option label {
                margin: 0;
                font-weight: normal;
                cursor: pointer;
                flex: 1;
            }

            /* Button Styling */
            .button-container {
                display: flex;
                gap: 15px;
                margin-top: 30px;
                width: 100%;
            }

            .submit-btn {
                width: 100%;
                padding: 16px;
                background: #2ecc71;
                border: none;
                color: white;
                font-size: 16px;
                font-weight: 600;
                border-radius: 10px;
                cursor: pointer;
                transition: all 0.3s ease;
                letter-spacing: 0.5px;
                box-shadow: 0 4px 15px rgba(39, 174, 96, 0.3);
            }

            .submit-btn:hover {
                transform: translateY(-2px);
                box-shadow: 0 6px 20px rgba(39, 174, 96, 0.4);
            }
            .cancel-btn {
                width: 100%;
                padding: 16px;
                background: #c0392b;
                border: none;
                color: white;
                font-size: 16px;
                font-weight: 600;
                border-radius: 10px;
                cursor: pointer;
                transition: all 0.3s ease;
                letter-spacing: 0.5px;
                text-align: center;
                box-shadow: 0 4px 15px rgba(39, 174, 96, 0.3);
                display: block;
                text-decoration: none;
            }

            .cancel-btn:hover {
                transform: translateY(-2px);
                box-shadow: 0 6px 20px rgba(231, 76, 60, 0.4);
            }

            .help-text {
                font-size: 12px;
                color: #7f8c8d;
                margin-bottom: 10px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="main-title">Edit Profile</div>
            <div class="subtitle">Update profile information</div>

            <%
                Connection conn = null;
                PreparedStatement pstmt = null;
                ResultSet rs = null;
                String id = request.getParameter("id");
                
                try {
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    conn = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentProfilesDB", "app", "app");
                    
                    String sql = "SELECT * FROM profile WHERE id = ?";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, Integer.parseInt(id));
                    rs = pstmt.executeQuery();
                    
                    if (rs.next()) {
                        // Get current values
                        String name = rs.getString("name");
                        String studentId = rs.getString("student_id");
                        String program = rs.getString("program");
                        String phone = rs.getString("phone");
                        String email = rs.getString("email");
                        String dob = rs.getString("dob");
                        String favColour = rs.getString("fav_colour");
                        String favFood = rs.getString("fav_food");
                        String hobbies = rs.getString("hobbies");
                        String languages = rs.getString("languages");
                        String education = rs.getString("education");
                        String skills = rs.getString("skills");
                        String achievement = rs.getString("achievement");
                        String goals = rs.getString("goals");
                        String intro = rs.getString("intro");
                        
                        // Split comma-separated strings into arrays for checkboxes
                        String[] langArray = languages.split(", ");
                        String[] skillsArray = skills.split(", ");
            %>
            
            <form action="UpdateProfileServlet" method="post">
                <input type="hidden" name="id" value="<%= id %>">
                
                <!-- SECTION 1 -->
                <div class="section-title">Personal Information</div>
                <div class="divider"></div>

                <div>
                    <label>Name:</label>
                    <input type="text" name="name" value="<%= name %>" required>
                </div>

                <div>
                    <label>Student ID:</label>
                    <input type="text" name="studentId" value="<%= studentId %>" required readonly>
                </div>

                <div>
                    <label>Program:</label>
                    <input type="text" name="program" value="<%= program %>" required>
                </div>
                
                <div>
                    <label>Phone Number:</label>
                    <input type="tel" name="phone" value="<%= phone %>" required>
                </div>
                    
                <div>
                    <label>Email:</label>
                    <input type="email" name="email" value="<%= email %>" required>
                </div>

                <div>
                    <label>Date of Birth:</label>
                    <input type="date" name="dob" value="<%= dob %>">
                </div>

                <!-- SECTION 2 -->
                <div class="section-title">Additional Information</div>
                <div class="divider"></div>
                
                <div>
                    <label>Favourite Colour:</label>
                    <input type="text" name="favColours" value="<%= favColour %>">
                </div>

                <div>
                    <label>Favourite Food:</label>
                    <input type="text" name="favFood" value="<%= favFood %>">
                </div>
                
                <div>
                    <label>Hobbies:</label>
                    <input type="text" name="hobbies" value="<%= hobbies %>">
                </div>
                
                <div class="form-group">
                    <label>Languages:</label>
                    <div class="language-container">
                        <div class="skill-option">
                            <input type="checkbox" id="lang1" name="languages" value="Malay" <%= java.util.Arrays.asList(langArray).contains("Malay") ? "checked" : "" %>>
                            <label for="lang1">Malay</label>
                        </div>
                        <div class="skill-option">
                            <input type="checkbox" id="lang2" name="languages" value="English" <%= java.util.Arrays.asList(langArray).contains("English") ? "checked" : "" %>>
                            <label for="lang2">English</label>
                        </div>
                        <div class="skill-option">
                            <input type="checkbox" id="lang3" name="languages" value="Chinese" <%= java.util.Arrays.asList(langArray).contains("Chinese") ? "checked" : "" %>>
                            <label for="lang3">Chinese</label>
                        </div>
                        <div class="skill-option">
                            <input type="checkbox" id="lang4" name="languages" value="Indian" <%= java.util.Arrays.asList(langArray).contains("Indian") ? "checked" : "" %>>
                            <label for="lang4">Indian</label>
                        </div>
                        <div class="skill-option">
                            <input type="checkbox" id="lang5" name="languages" value="Arabic" <%= java.util.Arrays.asList(langArray).contains("Arabic") ? "checked" : "" %>>
                            <label for="lang5">Arabic</label>
                        </div>
                        <div class="skill-option">
                            <input type="checkbox" id="lang6" name="languages" value="French" <%= java.util.Arrays.asList(langArray).contains("French") ? "checked" : "" %>>
                            <label for="lang6">French</label>
                        </div>
                        <div class="skill-option">
                            <input type="checkbox" id="lang7" name="languages" value="German" <%= java.util.Arrays.asList(langArray).contains("German") ? "checked" : "" %>>
                            <label for="lang7">German</label>
                        </div>
                    </div>
                </div>
                
                <div>
                    <label>Highest Education:</label>
                    <input type="text" name="education" value="<%= education %>">
                </div>
                
                <div>
                    <label>Skills:</label>
                    <div class="help-text">Select all that apply:</div>
                    <div class="skills-container">
                        <div class="skill-option">
                            <input type="checkbox" id="skill1" name="skills" value="Creativity" <%= java.util.Arrays.asList(skillsArray).contains("Creativity") ? "checked" : "" %>>
                            <label for="skill1">Creativity</label>
                        </div>
                        <div class="skill-option">
                            <input type="checkbox" id="skill2" name="skills" value="Problem-solving" <%= java.util.Arrays.asList(skillsArray).contains("Problem-solving") ? "checked" : "" %>>
                            <label for="skill2">Problem-solving</label>
                        </div>
                        <div class="skill-option">
                            <input type="checkbox" id="skill3" name="skills" value="Communication" <%= java.util.Arrays.asList(skillsArray).contains("Communication") ? "checked" : "" %>>
                            <label for="skill3">Communication</label>
                        </div>
                        <div class="skill-option">
                            <input type="checkbox" id="skill4" name="skills" value="Critical Thinking" <%= java.util.Arrays.asList(skillsArray).contains("Critical Thinking") ? "checked" : "" %>>
                            <label for="skill4">Critical Thinking</label>
                        </div>
                        <div class="skill-option">
                            <input type="checkbox" id="skill5" name="skills" value="Leadership" <%= java.util.Arrays.asList(skillsArray).contains("Leadership") ? "checked" : "" %>>
                            <label for="skill5">Leadership</label>
                        </div>
                        <div class="skill-option">
                            <input type="checkbox" id="skill6" name="skills" value="Team Collaboration" <%= java.util.Arrays.asList(skillsArray).contains("Team Collaboration") ? "checked" : "" %>>
                            <label for="skill6">Team Collaboration</label>
                        </div>
                        <div class="skill-option">
                            <input type="checkbox" id="skill7" name="skills" value="Presentation Skills" <%= java.util.Arrays.asList(skillsArray).contains("Presentation Skills") ? "checked" : "" %>>
                            <label for="skill7">Presentation Skills</label>
                        </div>
                        <div class="skill-option">
                            <input type="checkbox" id="skill8" name="skills" value="Emotional Intelligence" <%= java.util.Arrays.asList(skillsArray).contains("Emotional Intelligence") ? "checked" : "" %>>
                            <label for="skill8">Emotional Intelligence</label>
                        </div>
                        <div class="skill-option">
                            <input type="checkbox" id="skill9" name="skills" value="Computer Skills" <%= java.util.Arrays.asList(skillsArray).contains("Computer Skills") ? "checked" : "" %>>
                            <label for="skill9">Computer Skills</label>
                        </div>
                    </div>
                </div>
                
                <div>
                    <label>Biggest Achievement:</label>
                    <input type="text" name="achievement" value="<%= achievement %>">
                </div>

                <div>
                    <label>Main Dream or Goals:</label>
                    <textarea name="goals" rows="2"><%= goals %></textarea>
                </div>

                <div>
                    <label>Self Introduction:</label>
                    <textarea name="intro"><%= intro %></textarea>
                </div>

                <div class="button-container">
                    <button class="submit-btn" type="submit">Update Profile</button>
                    <a href="profileDetails.jsp?id=<%= id %>" class="cancel-btn">Cancel</a>
                </div>
            </form>
            <%
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try { if (rs != null) rs.close(); } catch (SQLException e) {}
                    try { if (pstmt != null) pstmt.close(); } catch (SQLException e) {}
                    try { if (conn != null) conn.close(); } catch (SQLException e) {}
                }
            %>
        </div>
    </body>
</html>
