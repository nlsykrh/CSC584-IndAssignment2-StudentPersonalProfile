<%-- 
    Document   : profile
    Created on : Dec 23, 2025, 7:01:17 PM
    Author     : nurul
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.ProfileBean" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Your Profile</title>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&family=Playfair+Display:wght@600&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&display=swap" rel="stylesheet">

        <style>
            body {
                font-family: "Inter", sans-serif;
                background: white;
                margin: 0;
                padding: 0;
                min-height: 100vh;
            }

            /* Header Section */
            .profile-header {
                background: linear-gradient(135deg, #ffe6f2, #e3f2ff, #fff8cc);
                background-size: 300% 300%;
                animation: pastelFlow 10s ease infinite;
                padding: 60px 40px;
                color: #2c3e50;
                text-align: center;
                border-bottom: 3px solid rgba(255, 107, 149, 0.3);
            }

            @keyframes pastelFlow {
                0% { background-position: 0% 50%; }
                50% { background-position: 100% 50%; }
                100% { background-position: 0% 50%; }
            }

            .header-name {
                font-family: 'Playfair Display', serif;
                font-size: 48px;
                margin-bottom: 10px;
                font-weight: 600;
                letter-spacing: 1px;
            }

            .header-contact {
                font-family: "Inter", sans-serif;
                font-size: 20px;
                margin-bottom: 15px;
                color: #666;
                line-height: 1.5;
            }

            .header-intro {
                font-family: 'Dancing Script', cursive;
                font-size: 30px;
                max-width: 800px;
                margin: 0 auto;
                line-height: 1.4;
                color: #555;
            }
            
            /* Content Section */
            .profile-content {
                background: white;
                padding: 50px;
                max-width: 1200px;
                margin: 0 auto;
            }

            h1 {
                font-family: "Playfair Display", serif;
                text-align: center;
                color: #2c3e50;
                font-size: 36px;
                margin-bottom: 10px;
                font-weight: 600;
            }

            .subtitle {
                text-align: center;
                color: #7f8c8d;
                font-size: 16px;
                margin-bottom: 50px;
                font-weight: 400;
            }

            .section-title {
                font-family: "Inter", sans-serif;
                color: #3498db;
                border-bottom: 2px solid #ff6b95;
                padding-bottom: 12px;
                margin-top: 50px;
                font-size: 24px;
                font-weight: 600;
                margin-bottom: 25px;
            }

            .info-grid {
                display: grid;
                grid-template-columns: 1fr 1fr;
                gap: 25px;
            }

            .info-box {
                background: #edf5fc;
                padding: 25px;
                border-radius: 12px;
                border-left: 4px solid #3498db;
                transition: transform 0.2s ease, box-shadow 0.2s ease;
            }

            .info-box:hover {
                transform: translateY(-2px);
                box-shadow: 0 4px 12px rgba(52, 152, 219, 0.15);
            }

            .info-box.full-width {
                grid-column: 1 / -1;
            }

            .label {
                font-weight: 600;
                color: #2c3e50;
                font-size: 14px;
                text-transform: uppercase;
                letter-spacing: 0.5px;
                display: block;
                margin-bottom: 10px;
            }

            .value {
                color: #34495e;
                font-size: 16px;
                line-height: 1.6;
            }
            
            .action-buttons {
                text-align: center;
                margin-top: 40px;
            }
            
            .btn {
                padding: 12px 24px;
                background: linear-gradient(135deg, #d6bcfa, #fefcbf);
                border: none;
                color: #242322;
                font-size: 16px;
                font-weight: 600;
                border-radius: 10px;
                cursor: pointer;
                margin: 0 10px;
                text-decoration: none;
                display: inline-block;
            }
            
            .btn:hover {
                transform: translateY(-2px);
                box-shadow: 0 6px 20px rgba(214, 188, 250, 0.4);
            }
            
            .btn-secondary {
                padding: 12px 24px;
                background: linear-gradient(135deg, #cbdcf7, #b9fbc0);;
                border: none;
                color: #242322;
                font-size: 16px;
                font-weight: 600;
                border-radius: 10px;
                cursor: pointer;
                margin: 0 10px;
                text-decoration: none;
                display: inline-block;
            }
            
            .btn-secondary:hover {
                transform: translateY(-2px);
                box-shadow: 0 6px 20px rgba(214, 188, 250, 0.4);
            }
        </style>
    </head>

    <body>
        <!-- Header Section -->
        <div class="profile-header">
            <div class="header-name">${profile.name}</div>
            <div class="header-contact">
                Student ID: ${profile.studentId}
            </div>
            <div class="header-intro">${profile.intro}</div>
        </div>
        
        <!-- Content Section -->
        <div class="profile-content">
            <h1>Personal Profile Summary</h1>
            <div class="subtitle">Profile successfully saved to database!</div>

            <!-- PERSONAL INFORMATION -->
            <h2 class="section-title">Personal Information</h2>
            <div class="info-grid">
                <div class="info-box">
                    <span class="label">Program</span>
                    <span class="value">${profile.program}</span>
                </div>
                <div class="info-box">
                    <span class="label">Phone Number</span>
                    <span class="value">+6${profile.phone}</span>
                </div>
                <div class="info-box">
                    <span class="label">Email</span>
                    <span class="value">${profile.email}</span>
                </div>
                <div class="info-box">
                    <span class="label">Date of Birth</span>
                    <span class="value">${profile.dob}</span>
                </div>
            </div>

            <!-- ADDITIONAL INFORMATION -->
            <h2 class="section-title">Additional Information</h2>
            <div class="info-grid">
                <div class="info-box">
                    <span class="label">Favourite Colour</span>
                    <span class="value">${profile.favColour}</span>
                </div>
                <div class="info-box">
                    <span class="label">Favourite Food</span>
                    <span class="value">${profile.favFood}</span>
                </div>
                <div class="info-box">
                    <span class="label">Hobbies</span>
                    <span class="value">${profile.hobbies}</span>
                </div>
                <div class="info-box">
                    <span class="label">Languages</span>
                    <span class="value">${profile.languages}</span>
                </div>
                <div class="info-box full-width">
                    <span class="label">Highest Education</span>
                    <span class="value">${profile.education}</span>
                </div>
                <div class="info-box full-width">
                    <span class="label">Skills</span>
                    <span class="value">${profile.skills}</span>
                </div>
                <div class="info-box full-width">
                    <span class="label">Biggest Achievement</span>
                    <span class="value">${profile.achievement}</span>
                </div>
                <div class="info-box full-width">
                    <span class="label">Major Dream or Goals</span>
                    <span class="value">${profile.goals}</span>
                </div>
            </div>
            
            <div class="action-buttons">
                <a href="profile_form.html" class="btn">Create New Profile</a>
                <a href="viewProfiles.jsp" class="btn-secondary">View All Profiles</a>
            </div>
        </div>
    </body>
</html>