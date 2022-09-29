package com.spring.boot.jdbc.SpringBootJDBC.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity                         //Row Mapping(Crate database schema)
@NamedQuery(name = "get_all_players", query = "SELECT p FROM Player p")
@Table(name = "Player")         //gives the table name

public class Player {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Age")
    private int age;

    @Column(name = "Nationality")
    private String nationality;

    @Column(name = "DOB")
    private Date dob;

    @Column(name = "Designation")
    private int designation;

    public Player(){}

    public Player(int id, String name, int age, String nationality, Date dob, int designation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.dob = dob;
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public Date getDob() {
        return dob;
    }

    public int getDesignation() {
        return designation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setDesignation(int designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Player{" +
                "pid=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", dob=" + dob +
                ", designation=" + designation +
                '}';
    }
}
