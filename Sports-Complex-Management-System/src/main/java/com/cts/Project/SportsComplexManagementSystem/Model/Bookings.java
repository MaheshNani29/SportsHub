    package com.cts.Project.SportsComplexManagementSystem.Model;


    import jakarta.persistence.*;
    import lombok.Data;
    import lombok.RequiredArgsConstructor;

    import java.time.LocalDate;
    import java.time.LocalTime;

    @Entity
    @RequiredArgsConstructor
    @Data
    public class Bookings
    {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long bookingId;
        private int noOfPlayers;
        private int totalHours;
        private double totalCost;
        private LocalDate bookingDate;
        private LocalTime bookingTime;
        private LocalTime endTime;

        private String status;

        public Bookings(int noOfPlayers,LocalDate bookingDate, LocalTime bookingTime, LocalTime endTime, User user, SportsInfo sportsInfo) {
            this.noOfPlayers = noOfPlayers;
            this.bookingDate = bookingDate;
            this.bookingTime = bookingTime;
            this.endTime = endTime;
            this.user = user;
            this.sportsInfo = sportsInfo;
        }

        @ManyToOne
        @JoinColumn(name = "userId", nullable = false)
        private User user;

        // Relationship with SportsInfo
        @ManyToOne
        @JoinColumn(name = "sportId", nullable = false)
        private SportsInfo sportsInfo;
    }


