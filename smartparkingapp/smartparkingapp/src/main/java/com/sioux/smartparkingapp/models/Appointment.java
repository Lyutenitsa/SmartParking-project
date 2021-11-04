package com.sioux.smartparkingapp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.Manager;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Appointment")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long appointment_id;

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

@OneToMany(targetEntity = AppointmentManager.class,cascade = CascadeType.ALL)
@JoinColumn(name="appointment_id",referencedColumnName = "manager_id")
private List<AppointmentManager> appointmentManagers;

    public Appointment(LocalDateTime starting_time, LocalTime duration, String licensePlate, String visitorName, String managerID, String visitorPhone)
    {
        this.starting_time = starting_time;
        this.duration = duration;
        this.licensePlate = licensePlate;
        this.visitorName = visitorName;
        this.managerID = managerID;
        this.visitorPhone = visitorPhone;
    }



    @Override
    public String toString()
    {
        return "Appointment{" + "id=" + appointment_id + ", starting_time=" + starting_time +
                ", duration=" + duration + ", licensePlate='" + licensePlate + '\'' +
                ", visitorName='" + visitorName + '\'' + ", managerID='" + managerID + '\'' +
                ", visitorPhone='" + visitorPhone + '\'' + '}';
    }
}


