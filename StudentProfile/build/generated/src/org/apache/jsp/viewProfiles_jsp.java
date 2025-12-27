package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class viewProfiles_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>View All Profiles</title>\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&family=Playfair+Display:wght@600&display=swap\" rel=\"stylesheet\">\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                font-family: \"Inter\", sans-serif;\n");
      out.write("                background: linear-gradient(135deg, #ffe6f2, #e3f2ff, #fff8cc);\n");
      out.write("                background-size: 300% 300%;\n");
      out.write("                animation: pastelFlow 10s ease infinite;\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 20px;\n");
      out.write("                min-height: 100vh;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            @keyframes pastelFlow {\n");
      out.write("                0% { background-position: 0% 50%; }\n");
      out.write("                50% { background-position: 100% 50%; }\n");
      out.write("                100% { background-position: 0% 50%; }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .container {\n");
      out.write("                max-width: 1200px;\n");
      out.write("                margin: 0 auto;\n");
      out.write("                background: white;\n");
      out.write("                padding: 30px;\n");
      out.write("                border-radius: 16px;\n");
      out.write("                box-shadow: 0 8px 40px rgba(0,0,0,0.08);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            h1 {\n");
      out.write("                font-family: \"Playfair Display\", serif;\n");
      out.write("                text-align: center;\n");
      out.write("                color: #2c3e50;\n");
      out.write("                margin-bottom: 30px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .filters-container {\n");
      out.write("                display: flex;\n");
      out.write("                justify-content: space-between;\n");
      out.write("                align-items: flex-end;\n");
      out.write("                margin-bottom: 30px;\n");
      out.write("                gap: 20px;\n");
      out.write("                flex-wrap: wrap;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .filter-left {\n");
      out.write("                display: flex;\n");
      out.write("                align-items: center;\n");
      out.write("                gap: 15px;\n");
      out.write("                background: #f8f9fa;\n");
      out.write("                padding: 15px 20px;\n");
      out.write("                border-radius: 12px;\n");
      out.write("                box-shadow: 0 4px 12px rgba(0,0,0,0.05);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .filter-right {\n");
      out.write("                display: flex;\n");
      out.write("                align-items: center;\n");
      out.write("                gap: 15px;\n");
      out.write("                background: #f8f9fa;\n");
      out.write("                padding: 15px 20px;\n");
      out.write("                border-radius: 12px;\n");
      out.write("                box-shadow: 0 4px 12px rgba(0,0,0,0.05);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .filter-label {\n");
      out.write("                font-size: 14px;\n");
      out.write("                font-weight: 600;\n");
      out.write("                color: #495057;\n");
      out.write("                white-space: nowrap;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .program-select {\n");
      out.write("                padding: 10px 15px;\n");
      out.write("                border-radius: 8px;\n");
      out.write("                border: 1.5px solid #e1e8ed;\n");
      out.write("                font-size: 14px;\n");
      out.write("                width: 180px;\n");
      out.write("                background: white;\n");
      out.write("                cursor: pointer;\n");
      out.write("                transition: all 0.3s;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .program-select:focus {\n");
      out.write("                outline: none;\n");
      out.write("                border-color: #8b5cf6;\n");
      out.write("                box-shadow: 0 0 0 3px rgba(139, 92, 246, 0.1);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .search-input {\n");
      out.write("                padding: 10px 15px;\n");
      out.write("                border-radius: 8px;\n");
      out.write("                border: 1.5px solid #e1e8ed;\n");
      out.write("                font-size: 14px;\n");
      out.write("                width: 220px;\n");
      out.write("                transition: all 0.3s;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .search-input:focus {\n");
      out.write("                outline: none;\n");
      out.write("                border-color: #6c63ff;\n");
      out.write("                box-shadow: 0 0 0 3px rgba(108, 99, 255, 0.1);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .search-btn {\n");
      out.write("                padding: 10px 20px;\n");
      out.write("                background: #92c7d4;\n");
      out.write("                border: none;\n");
      out.write("                color: white;\n");
      out.write("                font-weight: 600;\n");
      out.write("                border-radius: 8px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                transition: all 0.3s;\n");
      out.write("                white-space: nowrap;\n");
      out.write("                min-width: 80px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .search-btn:hover {\n");
      out.write("                background: #8db7c2;\n");
      out.write("                transform: translateY(-1px);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .reset-btn {\n");
      out.write("                padding: 10px 20px;\n");
      out.write("                background: #a27fb0;\n");
      out.write("                border: none;\n");
      out.write("                color: white;\n");
      out.write("                font-weight: 600;\n");
      out.write("                border-radius: 8px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                text-decoration: none;\n");
      out.write("                display: inline-block;\n");
      out.write("                transition: all 0.3s;\n");
      out.write("                white-space: nowrap;\n");
      out.write("                min-width: 80px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .reset-btn:hover {\n");
      out.write("                background: #9781a1;\n");
      out.write("                transform: translateY(-1px);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            table {\n");
      out.write("                width: 100%;\n");
      out.write("                border-collapse: collapse;\n");
      out.write("                margin-top: 20px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            th {\n");
      out.write("                background: #d9dbfc;\n");
      out.write("                color: black;\n");
      out.write("                padding: 16px;\n");
      out.write("                text-align: left;\n");
      out.write("                font-weight: 600;\n");
      out.write("                border-bottom: 2px solid #e1e8ed;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            td {\n");
      out.write("                padding: 16px;\n");
      out.write("                border-bottom: 1px solid #e1e8ed;\n");
      out.write("                vertical-align: middle;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            tr:hover {\n");
      out.write("                background-color: #f5f9fc;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            /* Fixed Actions column styling */\n");
      out.write("            .actions-cell {\n");
      out.write("                width: 200px;\n");
      out.write("                min-width: 200px;\n");
      out.write("                white-space: nowrap;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .action-btns {\n");
      out.write("                display: flex;\n");
      out.write("                gap: 8px;\n");
      out.write("                justify-content: flex-start;\n");
      out.write("                align-items: center;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .action-btn {\n");
      out.write("                padding: 8px 14px;\n");
      out.write("                color: white;\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 6px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                text-decoration: none;\n");
      out.write("                font-size: 13px;\n");
      out.write("                font-weight: 500;\n");
      out.write("                transition: all 0.2s;\n");
      out.write("                text-align: center;\n");
      out.write("                min-width: 60px;\n");
      out.write("                display: inline-block;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .view-btn {\n");
      out.write("                background: #3498db;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .view-btn:hover {\n");
      out.write("                background: #2980b9;\n");
      out.write("                transform: translateY(-1px);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .edit-btn {\n");
      out.write("                background: #27ae60;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .edit-btn:hover {\n");
      out.write("                background: #219653;\n");
      out.write("                transform: translateY(-1px);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .delete-btn {\n");
      out.write("                background: #e74c3c;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .delete-btn:hover {\n");
      out.write("                background: #c0392b;\n");
      out.write("                transform: translateY(-1px);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .bottom-btns {\n");
      out.write("                display: flex;\n");
      out.write("                justify-content: center;\n");
      out.write("                gap: 15px;\n");
      out.write("                margin-top: 10px;\n");
      out.write("                padding-top: 20px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .create-btn {\n");
      out.write("                padding: 12px 28px;\n");
      out.write("                background: linear-gradient(135deg, #d6bcfa, #fefcbf);\n");
      out.write("                color: #242322;\n");
      out.write("                box-shadow: 0 4px 15px rgba(214, 188, 250, 0.3);\n");
      out.write("                font-weight: 600;\n");
      out.write("                border-radius: 8px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                transition: all 0.3s;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .create-btn:hover {\n");
      out.write("                transform: translateY(-1px);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .home-btn {\n");
      out.write("                padding: 12px 28px;\n");
      out.write("                background: linear-gradient(135deg, #cbdcf7, #b9fbc0);\n");
      out.write("                color: #242322;\n");
      out.write("                box-shadow: 0 4px 15px rgba(167, 199, 255, 0.3);\n");
      out.write("                font-weight: 600;\n");
      out.write("                border-radius: 8px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                transition: all 0.3s;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .home-btn:hover {\n");
      out.write("                transform: translateY(-1px);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .empty-state {\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 60px 20px;\n");
      out.write("                color: #6c757d;\n");
      out.write("                font-size: 16px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            /* Responsive adjustments */\n");
      out.write("            @media (max-width: 768px) {\n");
      out.write("                .filters-container {\n");
      out.write("                    flex-direction: column;\n");
      out.write("                    align-items: stretch;\n");
      out.write("                    gap: 15px;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                .filter-left, .filter-right {\n");
      out.write("                    flex-direction: column;\n");
      out.write("                    align-items: stretch;\n");
      out.write("                    width: 100%;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                .program-select, .search-input {\n");
      out.write("                    width: 100% !important;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                .action-btns {\n");
      out.write("                    flex-direction: column;\n");
      out.write("                    gap: 5px;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                .action-btn {\n");
      out.write("                    width: 100%;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h1>List of Student Profiles</h1>\n");
      out.write("            \n");
      out.write("            <!-- Filters Container - Left and Right -->\n");
      out.write("            <div class=\"filters-container\">\n");
      out.write("                <!-- Left Side: Filter by Programme -->\n");
      out.write("                <form method=\"get\" action=\"viewProfiles.jsp\" class=\"filter-left\">\n");
      out.write("                    <span class=\"filter-label\">Filter by Programme:</span>\n");
      out.write("                    <select name=\"program\" class=\"program-select\" onchange=\"this.form.submit()\">\n");
      out.write("                        <option value=\"\">All Programmes</option>\n");
      out.write("                        ");

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
                        
      out.write("\n");
      out.write("                        <option value=\"");
      out.print( program );
      out.write('"');
      out.write(' ');
      out.print( isSelected ? "selected" : "" );
      out.write(">\n");
      out.write("                            ");
      out.print( program );
      out.write("\n");
      out.write("                        </option>\n");
      out.write("                        ");

                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                try { if (rsProg != null) rsProg.close(); } catch (SQLException e) {}
                                try { if (stmtProg != null) stmtProg.close(); } catch (SQLException e) {}
                                try { if (connProg != null) connProg.close(); } catch (SQLException e) {}
                            }
                        
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                    <input type=\"hidden\" name=\"search\" value=\"");
      out.print( request.getParameter("search") != null ? request.getParameter("search") : "" );
      out.write("\">\n");
      out.write("                </form>\n");
      out.write("                \n");
      out.write("                <!-- Right Side: Search by Student ID -->\n");
      out.write("                <form method=\"get\" action=\"viewProfiles.jsp\" class=\"filter-right\">\n");
      out.write("                    <span class=\"filter-label\">Search by Student ID:</span>\n");
      out.write("                    <input type=\"text\" name=\"search\" class=\"search-input\"\n");
      out.write("                           value=\"");
      out.print( request.getParameter("search") != null ? request.getParameter("search") : "" );
      out.write("\">\n");
      out.write("                    <button type=\"submit\" class=\"search-btn\">Search</button>\n");
      out.write("                    <a href=\"viewProfiles.jsp\" class=\"reset-btn\">Reset</a>\n");
      out.write("                    <input type=\"hidden\" name=\"program\" value=\"");
      out.print( request.getParameter("program") != null ? request.getParameter("program") : "" );
      out.write("\">\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <!-- Profiles Table -->\n");
      out.write("            <table>\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Student ID</th>\n");
      out.write("                        <th>Name</th>\n");
      out.write("                        <th>Programme</th>\n");
      out.write("                        <th>Email</th>\n");
      out.write("                        <th>Phone</th>\n");
      out.write("                        <th>Actions</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                ");

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
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( rs.getString("student_id") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getString("name") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getString("program") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getString("email") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getString("phone") );
      out.write("</td>\n");
      out.write("                    <td class=\"actions-cell\">\n");
      out.write("                        <div class=\"action-btns\">\n");
      out.write("                            <a href=\"profileDetails.jsp?id=");
      out.print( rs.getInt("id") );
      out.write("\" class=\"action-btn view-btn\">View</a>\n");
      out.write("                            <a href=\"editProfile.jsp?id=");
      out.print( rs.getInt("id") );
      out.write("\" class=\"action-btn edit-btn\">Edit</a>\n");
      out.write("                            <a href=\"DeleteProfileServlet?id=");
      out.print( rs.getInt("id") );
      out.write("\" class=\"action-btn delete-btn\" \n");
      out.write("                               onclick=\"return confirm('Are you sure you want to delete this profile?')\">Delete</a>\n");
      out.write("                        </div>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try { if (rs != null) rs.close(); } catch (SQLException e) {}
                        try { if (pstmt != null) pstmt.close(); } catch (SQLException e) {}
                        try { if (conn != null) conn.close(); } catch (SQLException e) {}
                    }
                    
                    if (!hasResults) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"7\" class=\"empty-state\">\n");
      out.write("                        <div>No student profiles found</div>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            \n");
      out.write("            <!-- Bottom Action Buttons -->\n");
      out.write("            <div class=\"bottom-btns\">\n");
      out.write("                <a href=\"profile_form.html\" class=\"create-btn\">Create New Profile</a>\n");
      out.write("                <a href=\"index.html\" class=\"home-btn\">Home</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            // Add subtle animation to search input on focus\n");
      out.write("            document.addEventListener('DOMContentLoaded', function() {\n");
      out.write("                // Ensure both filters work together\n");
      out.write("                const programSelect = document.querySelector('.program-select');\n");
      out.write("                const searchForm = document.querySelector('.filter-right form');\n");
      out.write("                \n");
      out.write("                if (programSelect && searchForm) {\n");
      out.write("                    programSelect.addEventListener('change', function() {\n");
      out.write("                        // Get current search value\n");
      out.write("                        const searchValue = document.querySelector('input[name=\"search\"]').value;\n");
      out.write("                        // Submit the form with both filters\n");
      out.write("                        this.form.submit();\n");
      out.write("                    });\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
