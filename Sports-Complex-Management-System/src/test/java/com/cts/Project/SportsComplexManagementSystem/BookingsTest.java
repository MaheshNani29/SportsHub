package com.cts.Project.SportsComplexManagementSystem;


import com.cts.Project.SportsComplexManagementSystem.DTO.SlotBooking;
import com.cts.Project.SportsComplexManagementSystem.Model.Bookings;
import com.cts.Project.SportsComplexManagementSystem.Model.SportsInfo;
import com.cts.Project.SportsComplexManagementSystem.Model.User;
import com.cts.Project.SportsComplexManagementSystem.Repository.BookingsRepository;
import com.cts.Project.SportsComplexManagementSystem.Repository.SportsInfoRepository;
import com.cts.Project.SportsComplexManagementSystem.Repository.UserRepository;
import com.cts.Project.SportsComplexManagementSystem.Service.BookingsService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Collections;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
public class BookingsTest {
    @Mock
    private BookingsRepository bookingsRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private SportsInfoRepository sportsInfoRepository;

    @InjectMocks
    private BookingsService bookingsService;


    @Test
    public void saveBookingTest() {
        SlotBooking slotBooking = new SlotBooking();
        slotBooking.setUserId(1L);
        slotBooking.setSportID(1L);
        slotBooking.setDate("2024-04-24");
        slotBooking.setStartTime("10:00");
        slotBooking.setEndTime("11:00");

        User user = new User();
        SportsInfo sportsInfo = new SportsInfo();

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(sportsInfoRepository.findById(1L)).thenReturn(Optional.of(sportsInfo));
        when(bookingsRepository.findAll()).thenReturn(Collections.emptyList());

        String result = bookingsService.saveBooking(slotBooking);

        assertEquals("booked", result);
        verify(bookingsRepository, times(1)).save(any(Bookings.class));
    }
}

