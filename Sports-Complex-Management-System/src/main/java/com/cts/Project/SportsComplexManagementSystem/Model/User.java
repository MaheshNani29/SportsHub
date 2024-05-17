package com.cts.Project.SportsComplexManagementSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;


@Entity
@RequiredArgsConstructor
@Data
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userId")
    private Long userId;
    private String name;
    private String phoneNo;
    @Column(unique = true)
    private String mailId;
    private String password;
//    private String role;

    public User(Long userId, String name, String phoneNo, String mailId, String password) {
        this.userId = userId;
        this.name = name;
        this.phoneNo = phoneNo;
        this.mailId = mailId;
        this.password = password;
//        this.role = role;
    }

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Bookings> bookings;
}


