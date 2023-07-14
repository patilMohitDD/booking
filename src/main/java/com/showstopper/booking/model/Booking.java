package com.showstopper.booking.model;

//package com.showstopper.booking.model;
public class Booking {
    private int id;
    private String customerBookingID;
    private String movieName;
    private String startTime;
    private String endTime;

    public Booking(int id,String customerBookingID, String movieName, String startTime, String endTime){
        this.id = id;
        this.customerBookingID = customerBookingID;
        this.movieName = movieName;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public int get_id(){
        return this.id;
    }
    public String getCustomerBookingID(){
        return this.customerBookingID;
    }

    public String getMovieName(){
        return this.movieName;
    }
    public String getstartTime(){
        return this.startTime;
    }

//    public Object get_AllObjects(){
//        Booking obj1 = new Booking(10, "AB-10", "MI:6", " 3pm", "6pm");
//        return obj1;
//    }

//    public static void main(String[] args) {
//        System.out.println("Hello");
//
//        Booking obj1 = new Booking(10, "AB-10", "MI:6", " 3pm", "6pm");
////        Booking obj2 = new Booking(12, "AB-11", "MI:7", " 9am", "12pm");
////        Booking obj3 = new Booking(13, "AB-12", "MI:8", " 4pm", "7pm");
//
//        System.out.println(obj1);
//
//    }

}
