package com.cts.Project.SportsComplexManagementSystem.Controller;

import com.cts.Project.SportsComplexManagementSystem.DTO.SlotBooking;
import com.cts.Project.SportsComplexManagementSystem.Model.Bookings;
import com.cts.Project.SportsComplexManagementSystem.Service.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/api")
public class BookingsController {

    @Autowired
    private BookingsService bookingsService;


    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/viewBookings")
    public List<Bookings> getAllBookings() {
        return bookingsService.getAllBookings();
    }


    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/{bookingId}")
    public Bookings getBookingById(@PathVariable Long bookingId) {
        return bookingsService.getBookingById(bookingId);
    }


    @CrossOrigin("http://localhost:4200/")
    @PostMapping("/slotBooking")
    public String slotbook(@RequestBody SlotBooking slotBooking) {
        return bookingsService.saveBooking(slotBooking);
    }


    @CrossOrigin("http://localhost:4200/")
    @DeleteMapping("delete/{bookingId}")
    public String delete(@PathVariable Long bookingId) {
        return bookingsService.cancelBooking(bookingId);
    }

    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/bookings/{userId}")
    public List<Bookings> BookingByUserId(@PathVariable Long userId) {
        return bookingsService.getBookingsByUserId(userId);

    }
}



























//    @CrossOrigin("http://localhost:4200/")
//    @PutMapping("/updateSportId/{bookingId}/{sportId}")
//    public String updateSportId(@PathVariable Long bookingId, @PathVariable Long sportId) {
//        return bookingsService.updateSport(bookingId, sportId);
//    }

//    @CrossOrigin("http://localhost:4200/")
//    @PutMapping("/updateDate/{bookingId}/{date}")
//    public String updateDate(@PathVariable Long bookingId, @PathVariable String date) {
//        return bookingsService.updateDate(bookingId, date);
//    }

//    @CrossOrigin("http://localhost:4200/")
//    @PutMapping("/updateTime/{bookingId}/{startTime}/{endTime}")
//    public String updateTime(@PathVariable Long bookingId, @PathVariable String startTime, @PathVariable String endTime) {
//        return bookingsService.updateTime(bookingId, startTime, endTime);
//    }