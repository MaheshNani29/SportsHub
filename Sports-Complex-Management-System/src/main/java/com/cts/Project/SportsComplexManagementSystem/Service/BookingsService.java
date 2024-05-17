package com.cts.Project.SportsComplexManagementSystem.Service;

import com.cts.Project.SportsComplexManagementSystem.DTO.SlotBooking;
import com.cts.Project.SportsComplexManagementSystem.Model.Bookings;
import com.cts.Project.SportsComplexManagementSystem.Model.SportsInfo;
import com.cts.Project.SportsComplexManagementSystem.Model.User;
import com.cts.Project.SportsComplexManagementSystem.Repository.BookingsRepository;
import com.cts.Project.SportsComplexManagementSystem.Repository.SportsInfoRepository;
import com.cts.Project.SportsComplexManagementSystem.Repository.UserRepository;
import com.cts.Project.SportsComplexManagementSystem.UserDefinedExceptions.NotExistInDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BookingsService {

    @Autowired
    private final BookingsRepository bookingsRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final SportsInfoRepository sportsInfoRepository;


    @Autowired
    public BookingsService(BookingsRepository bookingsRepository, UserRepository userRepository, SportsInfoRepository sportsInfoRepository) {
        this.bookingsRepository = bookingsRepository;
        this.userRepository = userRepository;
        this.sportsInfoRepository = sportsInfoRepository;
    }

    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static DateTimeFormatter dtft = DateTimeFormatter.ofPattern("HH:mm");

    public List<Bookings> getAllBookings() {

        List<Bookings> bookings = bookingsRepository.findAll();
        if (bookings.isEmpty()) {
            throw new NotExistInDatabase("No Bookings found in Database");
        }
        return bookings;
    }

    public Bookings getBookingById(Long bookingId) {
        return bookingsRepository.findById(bookingId)
                .orElseThrow(() -> new NotExistInDatabase("booking Id not found in Database: " + bookingId));
    }


    //slot availability check without any overlap
    public int checkSlotAvailable(Bookings bookings) {
        List<Bookings> bookingsList = bookingsRepository.findAll();
        for (Bookings e : bookingsList) {

            if (e.getBookingId() != bookings.getBookingId() && e.getBookingDate().equals(bookings.getBookingDate()) && e.getSportsInfo().getSportId() == bookings.getSportsInfo().getSportId()) {
                if ((e.getBookingTime().isAfter(bookings.getEndTime()) && e.getEndTime().isBefore(bookings.getEndTime())) ||
                        (e.getBookingTime().isBefore(bookings.getBookingTime()) && e.getEndTime().isAfter(bookings.getBookingTime())) ||
                        (e.getBookingTime().equals(bookings.getBookingTime()) && e.getEndTime().equals(bookings.getEndTime()))) {
                    return 0;
                }
            }
        }
        return 1;
    }


    //slotBooking
    public String saveBooking(SlotBooking slotBooking) {

        User user = userRepository.findById(slotBooking.getUserId()).get();
        SportsInfo sportsInfo = sportsInfoRepository.findById(slotBooking.getSportID()).get();
        LocalDate bookingDate = LocalDate.parse(slotBooking.getDate(), dtf);
        LocalTime startTime = LocalTime.parse(slotBooking.getStartTime(), dtft);
        LocalTime endTime = LocalTime.parse(slotBooking.getEndTime(), dtft);
        List<Bookings> bookingsList = bookingsRepository.findAll();
        Bookings newBooking = new Bookings(slotBooking.getTeamSize(), bookingDate, startTime, endTime, user, sportsInfo);

        if (bookingsList.isEmpty()) {
            bookSlot(newBooking);
            return "booked";
        }

        if (checkSlotAvailable(newBooking) == 0) {
            return "the slot is already booked";
        } else {
            bookSlot(newBooking);
            return "booked";
        }
    }


    public void bookSlot(Bookings booking) {
        Bookings book = new Bookings();
        book.setUser(booking.getUser());
        book.setSportsInfo(booking.getSportsInfo());
        book.setBookingDate(booking.getBookingDate());
        book.setBookingTime(booking.getBookingTime());
        book.setTotalHours(booking.getEndTime().minusHours(booking.getBookingTime().getHour()).getHour());
        book.setNoOfPlayers(booking.getNoOfPlayers());
        book.setEndTime(booking.getEndTime());
        int totalHours = booking.getEndTime().minusHours(booking.getBookingTime().getHour()).getHour();
        double costPerHour = booking.getSportsInfo().getCostPerHour();
        book.setTotalCost(totalHours * costPerHour);
        book.setStatus("SlotBooked");
        bookingsRepository.save(book);
    }


    //cancel the booking
    public String cancelBooking(long bookingId) {
        Bookings cancel = getBookingById(bookingId);
        cancel.setStatus("Canceled");
        bookingsRepository.save(cancel);
        return "Your slot has been Canceled";
    }

    public List<Bookings> getBookingsByUserId(Long userId) {
        return bookingsRepository.findByUserId(userId);
    }

}




















    //update date
//    public String updateDate(Long bookingId,String newDate){
//        Bookings booking = getBookingById(bookingId);
//        LocalDate newBookingDate = LocalDate.parse(newDate,dtf);
//        LocalDate oldBookingDate = booking.getBookingDate();
//        booking.setBookingDate(newBookingDate);
//        if(checkSlotAvailable(booking) ==0){
//            booking.setBookingDate(oldBookingDate);
//            bookingsRepository.save(booking);
//            return "The booking date with the given time slot is already booked";
//        }else{
//            bookingsRepository.save(booking);
//            return "The booking date is changed";
//        }
//    }



    //update time
//    public String updateTime(Long bookingId,String newStartTime,String newEndTime){
//        Bookings booking = getBookingById(bookingId);
//        LocalTime startTime = LocalTime.parse(newStartTime, dtft);
//        LocalTime oldStartTime = LocalTime.parse(newStartTime, dtft);
//        LocalTime endTime = LocalTime.parse(newEndTime,dtft);
//        LocalTime oldEndTime = LocalTime.parse(newEndTime,dtft);
//        booking.setBookingTime(startTime);
//        booking.setEndTime(endTime);
//        bookingsRepository.save(booking);
//        if(checkSlotAvailable(booking)==0){
//            booking.setBookingTime(oldStartTime);
//            booking.setEndTime(oldEndTime);
//            return "The time slot is not available";
//        }
//        return "Time Slot is changed";
//    }




    //update sport
//    public String updateSport(Long bookingId,Long sportId){
//        Bookings bookings = getBookingById(bookingId);
//        SportsInfo sportsInfo = bookings.getSportsInfo();
//        bookings.setSportsInfo(sportsInfoRepository.findById(sportId).get());
//        bookingsRepository.save(bookings);
//        if(checkSlotAvailable(bookings) == 0){
//            bookings.setSportsInfo(sportsInfo);
//            bookingsRepository.save(bookings);
//            return "Cannot book this sport that the given time and date.Slot already booked";
//        }else{
//
//        return "Sport change";
//        }
//
//    }





