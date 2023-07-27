package com.showstopper.booking.controller;
import com.showstopper.booking.service.BookingService;
import com.showstopper.booking.model.Booking;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
@WebMvcTest(value = BookingController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class, useDefaultFilters = false)
@Import(BookingController.class)
public class BookingControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BookingService bookingService;
    @Test
    public void testGetBookingIdNotFound() throws Exception {
        Integer testingId = 1;
        when(this.bookingService.getBookingById(testingId)).thenReturn(null);

        this.mockMvc.perform(get("/bookings/" + testingId))
                .andExpect(status().isNotFound());
    }
    @Test
    public void testGetBookingIdFound() throws Exception {
        Integer testingId = 2;
        String customerBookingID = "Ab:20";

        Optional<Booking> testBooking = Optional.of(Booking.builder().id(testingId).customerBookingID(customerBookingID).build());

        when(this.bookingService.getBookingById(testingId)).thenReturn(testBooking);

        this.mockMvc.perform(get("/bookings/" + testingId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(testingId))
                .andExpect(jsonPath("$.customerBookingID").value(customerBookingID));
    }
}
