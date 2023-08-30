package com.example.contactmanagerapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.UUID;

public class Contact implements Comparable<Contact>, Serializable {
    private UUID id; //pour avoir un truc unique
    @NonNull
    private String Name;
    private String Surname;
    private String Tel;
    private String email;
    private String  birthday;

    public Contact(
            @JsonProperty("id") UUID id,
            @JsonProperty("name") String name,
            @JsonProperty("surname") String surname,
            @JsonProperty("tel") String tel,
            @JsonProperty("email") String email,
            @JsonProperty("birthday") String birthday) {
        this.id = id;
        Name = name;
        Surname = surname;
        Tel = tel;
        this.email = email;
        if(!birthday.equals((""))){
            var currentDate = LocalDate.now();
            LocalDate date = LocalDate.parse(birthday);
            this.birthday = date.getDayOfMonth()+" "+date.getMonth().getDisplayName(TextStyle.FULL, Locale.FRANCE)
                    +" ("+ Period.between(date, currentDate).getYears()+") ans";
        }
        else this.birthday = birthday;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
