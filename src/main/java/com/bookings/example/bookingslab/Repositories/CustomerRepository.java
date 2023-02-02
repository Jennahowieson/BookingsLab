package com.bookings.example.bookingslab.Repositories;


import com.bookings.example.bookingslab.Models.Course;
import com.bookings.example.bookingslab.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomerByBookingsCourseName (String courseName);

}