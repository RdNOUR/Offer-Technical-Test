package com.offertechnicaltest.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDate;


@Table(name="userAf")
@Entity(name="userAf")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Basic
    @Column(name = "countryOfResidence", nullable = false)
    private String countryOfResidence;

    @Basic
    @Column (name ="phoneNumber", nullable = true)
    private long phoneNumber;

    @Basic
    @Column (name ="gender", nullable = true)
    private String gender;

    public User(String name, LocalDate birthdate, String countryOfResidence, long phoneNumber, String gender) {
        this.name = name;
        this.birthdate = birthdate;
        this.countryOfResidence = countryOfResidence;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
}