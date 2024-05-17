package com.cts.Project.SportsComplexManagementSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@RequiredArgsConstructor
@Data
public class SportsInfo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sportId;
    private String sportName;
    private int minimumPlayers;
    private double costPerHour;



    @OneToMany(mappedBy = "sportsInfo")
    @JsonIgnore
    private List<Bookings> bookings;
}
