/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nurul
 */
package model;

import java.io.Serializable;

public class ProfileBean implements Serializable {
    private int id;
    private String name;
    private String studentId;
    private String program;
    private String phone;
    private String email;
    private String dob;
    private String favColour;
    private String favFood;
    private String hobbies;
    private String languages;
    private String education;
    private String skills;
    private String achievement;
    private String goals;
    private String intro;
    
    // default constructor
    public ProfileBean() {}
    
    // accessors
    public int getId() { return id; }
    public String getName() { return name; }
    public String getStudentId() { return studentId; }
    public String getProgram() { return program; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getDob() { return dob; }
    public String getFavColour() { return favColour; }
    public String getFavFood() { return favFood; }
    public String getHobbies() { return hobbies; }
    public String getLanguages() { return languages; }
    public String getEducation() { return education; }
    public String getSkills() { return skills; }
    public String getAchievement() { return achievement; }
    public String getGoals() { return goals; }
    public String getIntro() { return intro; }
    
    // mutators
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public void setProgram(String program) { this.program = program; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }
    public void setDob(String dob) { this.dob = dob; }
    public void setFavColour(String favColour) { this.favColour = favColour; }
    public void setFavFood(String favFood) { this.favFood = favFood; }
    public void setHobbies(String hobbies) { this.hobbies = hobbies; }
    public void setLanguages(String languages) { this.languages = languages; }
    public void setEducation(String education) { this.education = education; }
    public void setSkills(String skills) { this.skills = skills; }
    public void setAchievement(String achievement) { this.achievement = achievement; }
    public void setGoals(String goals) { this.goals = goals; }
    public void setIntro(String intro) { this.intro = intro; }
}
