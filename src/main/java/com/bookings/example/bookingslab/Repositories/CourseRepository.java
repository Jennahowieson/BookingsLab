package com.bookings.example.bookingslab.Repositories;

import com.bookings.example.bookingslab.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository <Course, Long> {

    List<Course> findCourseByStarRating (int starRating);

    List<Course> findCourseByBookingsCustomerName (String name);
}
