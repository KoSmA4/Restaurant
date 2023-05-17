package org.example.service;

import org.example.model.Booking;
import org.example.model.Table;
import org.example.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class BookingService {
    @Autowired
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Transactional
    public Booking createBooking(String name, String phone, Table table) {
        if (name == null || phone == null || table == null)  {
            return null;
        }
        Booking booking = new Booking();
        booking.setName(name);
        booking.setPhone(phone);
        booking.setTable(table);
        return bookingRepository.save(booking);
    }
}



