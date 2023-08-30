package com.example.contactmanagerapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.UUID;
@Entity
@Table(name = "contacts")
public class Contact implements Comparable<Contact>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long id; //pour avoir un truc unique
    @NonNull
    @Column(name = "name", nullable = false)
    private String Name;
    @Column(name = "surname")
    private String Surname;
    @Column(name = "tel")
    private String Tel;
    @Column(name = "email")
    private String email;
    @Column(name = "birthday")
    private String  birthday;
    @Column(name = "age")
    private String age;

    public Contact(){}
    public Contact(
            @JsonProperty("id") long id,
            @JsonProperty("name") String name,
            @JsonProperty("surname") String surname,
            @JsonProperty("tel") String tel,
            @JsonProperty("email") String email,
            @JsonProperty("age") String age,
            @JsonProperty("birthday") String birthday)
            {
        this.id = id;
        Name = name;
        Surname = surname;
        Tel = tel;
        this.email = email;
        this.birthday = birthday;
        if(!birthday.equals((""))){
            var currentDate = LocalDate.now();
            LocalDate date = LocalDate.parse(birthday);
            this.age =Integer.toString(Period.between(date, currentDate).getYears());
        }
        else{ this.age = age;}
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public int compareTo(Contact c) {
        if(this.getName().toLowerCase().equals(c.getName().toLowerCase())){
            if(this.getSurname()==null)return -1;
            if(c.getSurname()==null)return 1;
            return this.getSurname().toLowerCase().compareTo(c.getSurname().toLowerCase());
        }
        return this.getName().toLowerCase().compareTo(c.getName().toLowerCase());
    }
}
