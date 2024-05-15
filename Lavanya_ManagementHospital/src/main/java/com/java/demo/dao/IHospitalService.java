package com.java.demo.dao;

import com.java.model.Appointment;
import com.java.myexception.PatientNumberNotFoundException;

import java.util.List;

public interface IHospitalService {
    Appointment getAppointmentById(int appointmentId);
    List<Appointment> getAppointmentsForPatient(int patientId);
    List<Appointment> getAppointmentsForDoctor(int doctorId);
    boolean scheduleAppointment(Appointment appointment);
    boolean updateAppointment(Appointment appointment);
    boolean cancelAppointment(int appointmentId);
}
