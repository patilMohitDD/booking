package com.showstopper.booking.model;
import java.util.ArrayList;


public class Call {

    public ArrayList getALLBookings(){
        ArrayList<Object> bookingObjects = new ArrayList<>();

        Booking Obj1 = new Booking(10, "AB-10", "MI:6", " 3pm", "6pm");
        Booking Obj2 = new Booking(12, "AB-11", "MI:7", " 9am", "12pm");

        bookingObjects.add(Obj1);
        bookingObjects.add(Obj2);

        return bookingObjects;
    }

    public Object getBookingById(int id) {
        ArrayList<Object> temp = new ArrayList<>();
        temp = this.getALLBookings();

        for(int i = 0; i < temp.size(); i++)
        {
            System.out.println(temp.get(i));
        }
        return null;
        }
    }

