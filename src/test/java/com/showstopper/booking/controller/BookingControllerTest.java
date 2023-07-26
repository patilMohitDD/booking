package com.showstopper.booking.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.showstopper.booking.service.BookingService;
import com.showstopper.booking.model.Booking;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    @Test
    public void testCreateBooking() throws Exception {
        Integer testingId = 2;
        String customerBookingID = "AB-20";
        String movieName = "MI-20";
        String startTime = "2018-03-29T13:34";
        String endTime = "2018-03-29T16:34";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime testStartTime = LocalDateTime.parse(startTime, formatter);
        LocalDateTime testEndTime = LocalDateTime.parse(endTime, formatter);

        Booking testBooking = Booking.builder().
                customerBookingID(customerBookingID).
                movieName(movieName).build();
//                .startTime(testStartTime).
//               endTime(testEndTime).
//                build();

        ObjectMapper objectMapper = new ObjectMapper();
        String testJsonBooking = objectMapper.writeValueAsString(testBooking);

        when(this.bookingService.saveBooking(testBooking)).thenReturn(testingId);

        this.mockMvc.perform(post("/bookings/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(testJsonBooking))
                .andExpect(status().isCreated());
    }

//    @Test
//    public void testupdateBookingIdPresent() throws Exception{
//        Integer testingId = 2;
//        String customerBookingID = "Ab:21";
//        Booking testBooking = Booking.builder().customerBookingID(customerBookingID).build();
//
//        when(this.bookingService.updateBooking(testingId, testBooking)).thenReturn(testBooking);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String testJsonBooking = objectMapper.writeValueAsString(testBooking);
//
//        this.mockMvc.perform(put("/bookings/" + testingId)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(testJsonBooking))
//                .andExpect(status().isOk());
//    }
}
