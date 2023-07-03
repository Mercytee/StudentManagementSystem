package com.basics.studentmanagementsystem.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Data
@Builder
@ToString
@Table (name = "students")
public class Student {
    public Student() {
    }

    //@Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column ( nullable = false)
    private String identificationNumber;

    @Column (name= "firstName", nullable = false)
   private String firstName;

    @Column (name= "lastName", nullable = false)
    private String lastName;

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
