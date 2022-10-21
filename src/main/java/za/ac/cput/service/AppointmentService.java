package za.ac.cput.service;

import za.ac.cput.domain.Appointment;
import za.ac.cput.domain.Doctor;
import za.ac.cput.domain.HospitalRoom;

import java.util.List;
import java.util.Set;

/*
    HospitalRoomService.java
    Service Interface for the Appointment
    Author: Sinazo(216076498)
    Date: 12 August 2022
*/
public interface AppointmentService extends IService<Appointment, String> {
    Set<Appointment> getAll();

}
