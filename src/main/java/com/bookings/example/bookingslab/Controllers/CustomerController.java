package com.bookings.example.bookingslab.Controllers;

import com.bookings.example.bookingslab.Models.Course;
import com.bookings.example.bookingslab.Models.Customer;
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
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;


    @GetMapping(value="/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(name = "courseName") String courseName) {
        if (courseName != null) {
            return new ResponseEntity<>(customerRepository.findCustomerByBookingsCourseName(courseName), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }


    @GetMapping(value="/customers/{id}")
    public ResponseEntity getCustomerById(@PathVariable Long id){
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }




}
