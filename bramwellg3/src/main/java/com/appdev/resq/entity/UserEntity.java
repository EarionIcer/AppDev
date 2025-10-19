package com.appdev.resq.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long userID;

    private String fName;
    private String lName;
    private LocalDate birthdate;
    private String email;
    private String allergies;
    private String username;
    private String password;
    private String phoneNumber;
    private String address;
    private String bloodType;

    public UserEntity(){}
    public UserEntity(Long userID, String fName, String lName ,LocalDate birthdate, String email, String allergies, String username, String password,  String phoneNumber, String address, String bloodType){
        super();
        this.userID=userID;
        this.fName=fName;
        this.lName=lName;
        this.birthdate=birthdate;
        this.email=email;
        this.allergies=allergies;
        this.username=username;
        this.password=password;
        this.phoneNumber=phoneNumber;
        this.address=address;
        this.bloodType=bloodType;
    }

    public Long getUserID(){ 
        return userID; 
    }
    public void setUserID(Long userID){ 
        this.userID = userID; 
    }

    public String getFName(){
        return fName; 
    }
    public void setFName(String fName){ 
        this.fName = fName; 
    }

    public String getLName(){ 
        return lName; 
    }
    public void setLName(String lName){ 
        this.lName = lName; 
    }

    public LocalDate getBirthdate(){ 
        return birthdate; 
    }
    public void setBirthdate(LocalDate birthdate){ 
        this.birthdate = birthdate; 
    }

    public String getEmail(){ 
        return email; 
    }
    public void setEmail(String email){ 
        this.email = email; 
    }

    public String getAllergies(){ 
        return allergies; 
    }
    public void setAllergies(String allergies){ 
        this.allergies = allergies; 
    }

    public String getUsername(){ 
        return username; 
    }
    public void setUsername(String username){ 
        this.username = username; 
    }

    public String getPassword(){ 
        return password; 
    }
    public void setPassword(String password){ 
        this.password = password; 
    }

    public String getPhoneNumber(){ 
        return phoneNumber; 
    }
    public void setPhoneNumber(String phoneNumber){ 
        this.phoneNumber = phoneNumber; 
    }

    public String getAddress(){ 
        return address; 
    }
    public void setAddress(String address){ 
        this.address = address; 
    }

    public String getBloodType(){ 
        return bloodType; 
    }
    public void setBloodType(String bloodType){ 
        this.bloodType = bloodType; 
    }
}
