package com.bookings.example.bookingslab.Controllers;

import com.bookings.example.bookingslab.Models.Course;
import com.bookings.example.bookingslab.Models.Customer;
import com.bookings.example.bookingslab.Repositories.CourseRepository;
import com.bookings.example.bookingslab.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;


    @GetMapping(value="/courses")
    public ResponseEntity<List<Course>> getAllCourses(
        @RequestParam(name = "starRating", required = false) Integer starRating,
        @RequestParam(name = "customerName", required = false) String customerName) {
            if (starRating != null  && customerName == null) {
                return new ResponseEntity<>(courseRepository.findCourseByStarRating(starRating), HttpStatus.OK);
            } else if (customerName != null && starRating == null){
                return new ResponseEntity<>(courseRepository.findCourseByBookingsCustomerName(customerName), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }


    @GetMapping(value="/courses/{id}")
    public ResponseEntity getCourseById(@PathVariable Long id){
        return new ResponseEntity<>(courseRepository.findById(id), HttpStatus.OK);
    }


}
