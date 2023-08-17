package com.example.springboot.thymleafDemo.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mentor")
public class Mentor {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY )
    @Column(name = "mentor_id")
    private int mentor_id;
    @Column(name = "mentor_name")
    private String mentor_name;
    private int age;
    private String groupName_manage;
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "mentor" , cascade = {CascadeType.PERSIST , CascadeType.MERGE
            ,CascadeType.DETACH , CascadeType.REFRESH})
    @JsonManagedReference
    protected List<Intern> internManaged ;



    public Mentor() {
    }

    public Mentor(int mentor_id, String mentor_name, int age, String email,
                  String phoneNumber ) {
        this.mentor_id = mentor_id;
        this.mentor_name = mentor_name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Mentor(int mentor_id, String mentor_name) {
        this.mentor_id = mentor_id;
        this.mentor_name = mentor_name;
    }

    public Mentor(String mentor_name,
                  int age,
                  String groupName_manage,
                  String email,
                  String phoneNumber) {
        this.mentor_name = mentor_name;
        this.age = age;
        this.groupName_manage = groupName_manage;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getMentor_id() {
        return mentor_id;
    }

    public void setMentor_id(int mentor_id) {
        this.mentor_id = mentor_id;
    }

    public String getMentor_name() {
        return mentor_name;
    }

    public void setMentor_name(String mentor_name) {
        this.mentor_name = mentor_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGroupName_manage() {
        return groupName_manage;
    }

    public void setGroupName_manage(String groupName_manage) {
        this.groupName_manage = groupName_manage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Intern> getInternManaged() {
        return internManaged;
    }

    public void setInternManaged(List<Intern> internManaged) {
        this.internManaged = internManaged;
    }



    @Override
    public String toString() {
        return "Mentor{" +
                "mentor_id=" + mentor_id +
                ", mentor_name='" + mentor_name + '\'' +
                ", age=" + age +
                ", groupName_manage='" + groupName_manage + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }


    public void addIntern(Intern tempIntern){
        if(internManaged == null){
            internManaged = new ArrayList<>();
        }

        internManaged.add(tempIntern);
        tempIntern.setMentor(this);
    }
}
