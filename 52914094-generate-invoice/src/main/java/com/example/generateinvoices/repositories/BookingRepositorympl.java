package com.example.generateinvoices.repositories;

import com.example.generateinvoices.models.Booking;
import com.example.generateinvoices.models.Invoice;
import com.example.generateinvoices.services.BookingService;
import com.example.generateinvoices.services.BookingServiceImpl;

public class BookingRepositorympl implements BookingService {
	Map<Long,Booking> db = new HashMap<>();
	BookingServiceImpl bookingServiceImpl = new BookingRepositorympl();
	   
	@Override
	Booking save(Booking booking) {
		db.put(booking.getId(),booking);
		return booking;
	}

	@Override
	public Invoice generateInvoice(long userId) {
		return bookingServiceImpl.generateInvoice(userId);
	}
	

}
