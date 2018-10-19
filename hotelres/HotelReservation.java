package com.example.student.hotelres;

public class HotelReservation {
    private int adults;
    private int children;
    private int rooms;
    private String checkIn;
    private String checkOut;
    private String roomType;
    private String name;
    private String street;
    private String city;
    private String state;
    private String phone;
    private String eMail;

    public HotelReservation(){
        adults = 0;
        children = 0;
        rooms = 0;
        checkIn = "";
        checkOut = "";
        roomType = "";
        name = "";
        street = "";
        city = "";
        state = "";
        phone = "";
        eMail = "";
    }

    //getters
    public int getAdults(){
        return this.adults;
    }
    public int getChildren(){
        return this.children;
    }
    public int getRooms(){
        return this.rooms;
    }
    public String getCheckIn(){
        return this.checkIn;
    }
    public String getCheckOut(){
        return this.checkOut;
    }
    public String getRoomType() { return this.roomType; }
    public String getName() { return this.name; }
    public String getStreet() { return this.street; }
    public String getCity() { return this.city; }
    public String getState() { return this.state; }
    public String getPhone() { return this.phone; }
    public String geteMail() {return this.eMail; }

    //setters
    public void setAdults(int adults) {
        this.adults = adults;
    }
    public void setChildren(int children) {
        this.children = children;
    }
    public void setRooms(int rooms) {
        this.rooms = rooms;
    }
    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }
    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String toString(){
        String hotelString = "Your Reservation:\n" + this.adults + " adults and " + this.children + " children in " + this.rooms + " rooms.\n"
                + "Check-in Date: " + this.checkIn + "\nCheck-out Date: " + this.checkOut + "\nRoom Type(s):" + roomType +
                "\n\nGuest Info: " + this.name +
                "\n     Address: " + street + " " + city + " " + state +
                "\n     Contact Info: " + phone + " " + eMail;

        return hotelString;
    }
}
