/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class RenterModel{
    String RenterName, Id, Contact, Status, Room;
    Integer Duration, Bill;

    public String getRenterName() {
        return RenterName;
    }

    public void setRenterName(String RenterName) {
        this.RenterName = RenterName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getRoom() {
        return Room;
    }

    public void setRoom(String Room) {
        this.Room = Room;
    }

    public Integer getDuration() {
        return Duration;
    }

    public void setDuration(Integer Duration) {
        this.Duration = Duration;
    }

    public Integer getBill() {
        return Bill;
    }

    public void setBill(Integer Bill) {
        this.Bill = Bill;
    }

}
