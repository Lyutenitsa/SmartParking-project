package com.sioux.smartparkingapp.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.Manager;

import javax.persistence.*;
import java.time.LocalDate;

import java.time.LocalTime;

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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate createdDate;

    private LocalTime startTime;

    @Column(name = "duration")
    private int duration;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "visitor_name")
    private String visitorName;

    @Column(name = "manager_id")
    private String managerID;


    @Column(name = "visitor_phone")
    private String visitorPhone;

//@OneToMany(targetEntity = AppointmentManager.class,cascade = CascadeType.ALL)
//@JoinColumn(name="appointment_id",referencedColumnName = "manager_id")
//private List<AppointmentManager> appointmentManagers;

    @Override
    public String toString()
    {
        return "Appointment{" + "id=" + appointment_id + ", starting_time=" + createdDate +
                ", duration=" + duration + ", licensePlate='" + licensePlate + '\'' +
                ", visitorName='" + visitorName + '\'' + ", managerID='" + managerID + '\'' +
                ", visitorPhone='" + visitorPhone + '\'' + '}';
    }
}


