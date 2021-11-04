package com.sioux.smartparkingapp.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "Appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "starting_time")
    private LocalDateTime starting_time;

    @Column(name = "duration")
    private LocalTime duration;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "visitor_name")
    private String visitorName;

    @Column(name = "manager_id")
    private String managerID;

    @Column(name = "visitor_phone")
    private String visitorPhone;

    public Appointment(LocalDateTime starting_time, LocalTime duration, String licensePlate, String visitorName, String managerID, String visitorPhone)
    {
        this.starting_time = starting_time;
        this.duration = duration;
        this.licensePlate = licensePlate;
        this.visitorName = visitorName;
        this.managerID = managerID;
        this.visitorPhone = visitorPhone;
    }

    public Appointment()
    {

    }

    //Getter and setters
    //region

    public Long getId()
    {
        return id;
    }

    public LocalDateTime getStarting_time()
    {
        return starting_time;
    }

    public void setStarting_time(LocalDateTime starting_time)
    {
        this.starting_time = starting_time;
    }

    public LocalTime getDuration()
    {
        return duration;
    }

    public void setDuration(LocalTime duration)
    {
        this.duration = duration;
    }

    public String getLicensePlate()
    {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate)
    {
        this.licensePlate = licensePlate;
    }

    public String getVisitorName()
    {
        return visitorName;
    }

    public void setVisitorName(String visitorName)
    {
        this.visitorName = visitorName;
    }

    public String getManagerID()
    {
        return managerID;
    }

    public void setManagerID(String managerID)
    {
        this.managerID = managerID;
    }

    public String getVisitorPhone()
    {
        return visitorPhone;
    }

    public void setVisitorPhone(String visitorPhone)
    {
        this.visitorPhone = visitorPhone;
    }


    //endregion


    @Override
    public String toString()
    {
        return "Appointment{" + "id=" + id + ", starting_time=" + starting_time +
                ", duration=" + duration + ", licensePlate='" + licensePlate + '\'' +
                ", visitorName='" + visitorName + '\'' + ", managerID='" + managerID + '\'' +
                ", visitorPhone='" + visitorPhone + '\'' + '}';
    }
}


