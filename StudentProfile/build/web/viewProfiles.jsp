<%-- 
    Document   : viewProfiles
    Created on : Dec 23, 2025, 8:12:07 PM
    Author     : nurul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>View All Profiles</title>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&family=Playfair+Display:wght@600&display=swap" rel="stylesheet">
        <style>
            body {
                font-family: "Inter", sans-serif;
                background: linear-gradient(135deg, #ffe6f2, #e3f2ff, #fff8cc);
                background-size: 300% 300%;
                animation: pastelFlow 10s ease infinite;
                margin: 0;
                padding: 20px;
                min-height: 100vh;
            }
            
            @keyframes pastelFlow {
                0% { background-position: 0% 50%; }
                50% { background-position: 100% 50%; }
                100% { background-position: 0% 50%; }
            }
            
            .container {
                max-width: 1200px;
                margin: 0 auto;
                background: white;
                padding: 30px;
                border-radius: 16px;
                box-shadow: 0 8px 40px rgba(0,0,0,0.08);
            }
            
            h1 {
                font-family: "Playfair Display", serif;
                text-align: center;
                color: #2c3e50;
                margin-bottom: 30px;
            }
            
            .filters-container {
                display: flex;
                justify-content: space-between;
                align-items: flex-end;
                margin-bottom: 30px;
                gap: 20px;
                flex-wrap: wrap;
            }
            
            .filter-left {
                display: flex;
                align-items: center;
                gap: 15px;
                background: #f8f9fa;
                padding: 15px 20px;
                border-radius: 12px;
                box-shadow: 0 4px 12px rgba(0,0,0,0.05);
            }
            
            .filter-right {
                display: flex;
                align-items: center;
                gap: 15px;
                background: #f8f9fa;
                padding: 15px 20px;
                border-radius: 12px;
                box-shadow: 0 4px 12px rgba(0,0,0,0.05);
            }
            
            .filter-label {
                font-size: 14px;
                font-weight: 600;
                color: #495057;
                white-space: nowrap;
            }
            
            .program-select {
                padding: 10px 15px;
                border-radius: 8px;
                border: 1.5px solid #e1e8ed;
                font-size: 14px;
                width: 180px;
                background: white;
                cursor: pointer;
                transition: all 0.3s;
            }
            
            .program-select:focus {
                outline: none;
                border-color: #8b5cf6;
                box-shadow: 0 0 0 3px rgba(139, 92, 246, 0.1);
            }
            
            .search-input {
                padding: 10px 15px;
                border-radius: 8px;
                border: 1.5px solid #e1e8ed;
                font-size: 14px;
                width: 220px;
                transition: all 0.3s;
            }
            
            .search-input:focus {
                outline: none;
                border-color: #6c63ff;
                box-shadow: 0 0 0 3px rgba(108, 99, 255, 0.1);
            }
            
            .search-btn {
                padding: 10px 20px;
                background: #92c7d4;
                border: none;
                color: white;
                font-weight: 600;
                border-radius: 8px;
                cursor: pointer;
                transition: all 0.3s;
                white-space: nowrap;
                min-width: 80px;
            }
            
            .search-btn:hover {
                background: #8db7c2;
                transform: translateY(-1px);
            }
            
            .reset-btn {
                padding: 10px 20px;
                background: #a27fb0;
                border: none;
                color: white;
                font-weight: 600;
                border-radius: 8px;
                cursor: pointer;
                text-decoration: none;
                display: inline-block;
                transition: all 0.3s;
                white-space: nowrap;
                min-width: 80px;
                text-align: center;
            }
            
            .reset-btn:hover {
                background: #9781a1;
                transform: translateY(-1px);
            }
            
            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }
            
            th {
                background: #d9dbfc;
                color: black;
                padding: 16px;
                text-align: left;
                font-weight: 600;
                border-bottom: 2px solid #e1e8ed;
            }
            
            td {
                padding: 16px;
                border-bottom: 1px solid #e1e8ed;
                vertical-align: middle;
            }
            
            tr:hover {
                background-color: #f5f9fc;
            }
            
            /* Fixed Actions column styling */
            .actions-cell {
                width: 200px;
                min-width: 200px;
                white-space: nowrap;
            }
            
            .action-btns {
                display: flex;
                gap: 8px;
                justify-content: flex-start;
                align-items: center;
            }
            
            .action-btn {
                padding: 8px 14px;
                color: white;
                border: none;
                border-radius: 6px;
                cursor: pointer;
                text-decoration: none;
                font-size: 13px;
                font-weight: 500;
                transition: all 0.2s;
                text-align: center;
                min-width: 60px;
                display: inline-block;
            }
            
            .view-btn {
                background: #3498db;
            }
            
            .view-btn:hover {
                background: #2980b9;
                transform: translateY(-1px);
            }
            
            .edit-btn {
                background: #27ae60;
            }
            
            .edit-btn:hover {
                background: #219653;
                transform: translateY(-1px);
            }
            
            .delete-btn {
                background: #e74c3c;
            }
            
            .delete-btn:hover {
                background: #c0392b;
                transform: translateY(-1px);
            }
            
            .bottom-btns {
                display: flex;
                justify-content: center;
                gap: 15px;
                margin-top: 10px;
                padding-top: 20px;
            }
            
            .create-btn {
                padding: 12px 28px;
                background: linear-gradient(135deg, #d6bcfa, #fefcbf);
                color: #242322;
                box-shadow: 0 4px 15px rgba(214, 188, 250, 0.3);
                font-weight: 600;
                border-radius: 8px;
                text-decoration: none;
                transition: all 0.3s;
            }
            
            .create-btn:hover {
                transform: translateY(-1px);
            }
            
            .home-btn {
                padding: 12px 28px;
                background: linear-gradient(135deg, #cbdcf7, #b9fbc0);
                color: #242322;
                box-shadow: 0 4px 15px rgba(167, 199, 255, 0.3);
                font-weight: 600;
                border-radius: 8px;
                text-decoration: none;
                transition: all 0.3s;
            }
            
            .home-btn:hover {
                transform: translateY(-1px);
            }
            
            .empty-state {
                text-align: center;
                padding: 60px 20px;
                color: #6c757d;
                font-size: 16px;
            }
            
            /* Responsive adjustments */
            @media (max-width: 768px) {
                .filters-container {
                    flex-direction: column;
                    align-items: stretch;
                    gap: 15px;
                }
                
                .filter-left, .filter-right {
                    flex-direction: column;
                    align-items: stretch;
                    width: 100%;
                }
                
                .program-select, .search-input {
                    width: 100% !important;
                }
                
                .action-btns {
                    flex-direction: column;
                    gap: 5px;
                }
                
                .action-btn {
                    width: 100%;
                }
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>List of Student Profiles</h1>
            
            <!-- Filters Container - Left and Right -->
            <div class="filters-container">
                <!-- Left Side: Filter by Programme -->
                <form method="get" action="viewProfiles.jsp" class="filter-left">
                    <span class="filter-label">Filter by Programme:</span>
                    <select name="program" class="program-select" onchange="this.form.submit()">
                        <option value="">All Programmes</option>
                        <%
                            // Fetch unique programs from database
                            Connection connProg = null;
                            Statement stmtProg = null;
                            ResultSet rsProg = null;
                            
                            try {
                                Class.forName("org.apache.derby.jdbc.ClientDriver");
                                connProg = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentProfiles", "app", "app");
                                String progSql = "SELECT DISTINCT program FROM profile WHERE program IS NOT NULL ORDER BY program";
                                stmtProg = connProg.createStatement();
                                rsProg = stmtProg.executeQuery(progSql);
                                
                                String selectedProgram = request.getParameter("program");
                                
                                while (rsProg.next()) {
                                    String program = rsProg.getString("program");
                                    boolean isSelected = program.equals(selectedProgram);
                        %>
                        <option value="<%= program %>" <%= isSelected ? "selected" : "" %>>
                            <%= program %>
                        </option>
                        <%
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                try { if (rsProg != null) rsProg.close(); } catch (SQLException e) {}
                                try { if (stmtProg != null) stmtProg.close(); } catch (SQLException e) {}
                                try { if (connProg != null) connProg.close(); } catch (SQLException e) {}
                            }
                        %>
                    </select>
                    <input type="hidden" name="search" value="<%= request.getParameter("search") != null ? request.getParameter("search") : "" %>">
                </form>
                
                <!-- Right Side: Search by Student ID -->
                <form method="get" action="viewProfiles.jsp" class="filter-right">
                    <span class="filter-label">Search by Student ID:</span>
                    <input type="text" name="search" class="search-input"
                           value="<%= request.getParameter("search") != null ? request.getParameter("search") : "" %>">
                    <button type="submit" class="search-btn">Search</button>
                    <a href="viewProfiles.jsp" class="reset-btn">Reset</a>
                    <input type="hidden" name="program" value="<%= request.getParameter("program") != null ? request.getParameter("program") : "" %>">
                </form>
            </div>
            
            <!-- Profiles Table -->
            <table>
                <thead>
                    <tr>
                        <th>Student ID</th>
                        <th>Name</th>
                        <th>Programme</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                <%
                    Connection conn = null;
                    PreparedStatement pstmt = null;
                    ResultSet rs = null;
                    boolean hasResults = false;
                    
                    try {
                        Class.forName("org.apache.derby.jdbc.ClientDriver");
                        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentProfiles", "app", "app");
                        
                        String search = request.getParameter("search");
                        String programFilter = request.getParameter("program");
                        
                        StringBuilder sql = new StringBuilder("SELECT * FROM profile WHERE 1=1");
                        
                        if (search != null && !search.trim().isEmpty()) {
                            sql.append(" AND student_id LIKE ?");
                        }
                        
                        if (programFilter != null && !programFilter.trim().isEmpty()) {
                            sql.append(" AND program = ?");
                        }
                        
                        sql.append(" ORDER BY id DESC");
                        
                        pstmt = conn.prepareStatement(sql.toString());
                        int paramIndex = 1;
                        
                        if (search != null && !search.trim().isEmpty()) {
                            pstmt.setString(paramIndex++, "%" + search + "%");
                        }
                        
                        if (programFilter != null && !programFilter.trim().isEmpty()) {
                            pstmt.setString(paramIndex++, programFilter);
                        }
                        
                        rs = pstmt.executeQuery();
                        
                        while (rs.next()) {
                            hasResults = true;
                %>
                <tr>
                    <td><%= rs.getString("student_id") %></td>
                    <td><%= rs.getString("name") %></td>
                    <td><%= rs.getString("program") %></td>
                    <td><%= rs.getString("email") %></td>
                    <td><%= rs.getString("phone") %></td>
                    <td class="actions-cell">
                        <div class="action-btns">
                            <a href="profileDetails.jsp?id=<%= rs.getInt("id") %>" class="action-btn view-btn">View</a>
                            <a href="editProfile.jsp?id=<%= rs.getInt("id") %>" class="action-btn edit-btn">Edit</a>
                            <a href="DeleteProfileServlet?id=<%= rs.getInt("id") %>" class="action-btn delete-btn" 
                               onclick="return confirm('Are you sure you want to delete this profile?')">Delete</a>
                        </div>
                    </td>
                </tr>
                <%
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try { if (rs != null) rs.close(); } catch (SQLException e) {}
                        try { if (pstmt != null) pstmt.close(); } catch (SQLException e) {}
                        try { if (conn != null) conn.close(); } catch (SQLException e) {}
                    }
                    
                    if (!hasResults) {
                %>
                <tr>
                    <td colspan="7" class="empty-state">
                        <div>No student profiles found</div>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
            
            <!-- Bottom Action Buttons -->
            <div class="bottom-btns">
                <a href="profile_form.html" class="create-btn">Create New Profile</a>
                <a href="index.html" class="home-btn">Home</a>
            </div>
        </div>
        
        <script>
            // Add subtle animation to search input on focus
            document.addEventListener('DOMContentLoaded', function() {
                // Ensure both filters work together
                const programSelect = document.querySelector('.program-select');
                const searchForm = document.querySelector('.filter-right form');
                
                if (programSelect && searchForm) {
                    programSelect.addEventListener('change', function() {
                        // Get current search value
                        const searchValue = document.querySelector('input[name="search"]').value;
                        // Submit the form with both filters
                        this.form.submit();
                    });
                }
            });
        </script>
    </body>
</html>