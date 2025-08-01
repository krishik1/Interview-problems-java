package com.example.generateinvoices.services;

import com.example.generateinvoices.models.Booking;
import com.example.generateinvoices.models.Integer;
import com.example.generateinvoices.models.Invoice;
import com.example.generateinvoices.models.Map;
import com.example.generateinvoices.models.Room;
import java.util.*;

public class BookingServiceImpl implements BookingService {

	@Override
	public Invoice generateInvoice(long userId) {
		Invoice invoice = new Invoice();
	    Map<Room, Integer> bookedRoomsInfo = new HashMap();
	    Booking booking = new Booking();
	    double totalAmt = 0.0;
	    Map<Room, Integer> bookedRooms = booking.getBookedRooms();
	    
	    for (Map.Entry<Room, Integer> entry : bookedRooms.entrySet()) {
            bookedRoomsInfo.put(entry.getKey(), entry.getValue());
            Room room =entry.getKey();
            totalAmt += (entry.getValue()*room.getPrice());
        }
	    double gst = totalAmt*(0.18);
	    double serviceTax = totalAmt*(0.1);
	    invoice.setId(userId);
	    invoice.setBookedRooms(bookedRoomsInfo);
	    invoice.setTotalAmount(totalAmt);
	    invoice.setGst(gst);
	    invoice.setServiceCharge(serviceTax);
	    return invoice; 
	    
	    
	}

}
