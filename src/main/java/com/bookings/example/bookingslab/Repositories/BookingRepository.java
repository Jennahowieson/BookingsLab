package com.bookings.example.bookingslab.Repositories;


import com.bookings.example.bookingslab.Models.Booking;
import com.bookings.example.bookingslab.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findBookingByDate (String date);
}