package com.bookings.example.bookingslab.components;


import com.bookings.example.bookingslab.Models.Booking;
import com.bookings.example.bookingslab.Models.Course;
import com.bookings.example.bookingslab.Models.Customer;
import com.bookings.example.bookingslab.Repositories.BookingRepository;
import com.bookings.example.bookingslab.Repositories.CourseRepository;
import com.bookings.example.bookingslab.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CourseRepository courseRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        Customer customer1 = new Customer("Bob", "Edinburgh", 38);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Bill", "Glasgow", 32);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Sophie", "Edinburgh", 18);
        customerRepository.save(customer3);

        Course courseE = new Course("Prof Software Dev", "Edinburgh",5);
        Course courseG = new Course("Data", "Glasgow",4);
        courseRepository.save(courseG);
        courseRepository.save(courseE);

        Booking booking1 = new Booking("02-02-2023",customer1,courseE);
        Booking booking2 = new Booking("02-02-2023",customer2,courseG);
        Booking booking3 = new Booking("02-02-2023",customer3,courseE);
        Booking booking4 = new Booking("02-09-2023",customer1,courseG);

        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);
        bookingRepository.save(booking4);


    }
}
