package com.cts.Project.SportsComplexManagementSystem.DTO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class SlotBooking {
    private Long userId;
    private Long sportID;
    private int teamSize;
    private String date;
    private String startTime;
    private String endTime;

}