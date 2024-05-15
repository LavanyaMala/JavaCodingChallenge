package com.java.demo.service;

import java.util.Scanner;
import com.java.model.Appointment;
import com.java.myexception.PatientNumberNotFoundException;
import com.java.demo.dao.HospitalServiceImpl;
import com.java.demo.dao.IHospitalService;

public class ServiceHospital {
    private Scanner sc;
    private HospitalServiceImpl ser;

    public ServiceHospital(HospitalServiceImpl ser) {  
        this.ser = ser;
        this.sc = new Scanner(System.in);
    }
    

	public void Schedule()
	{
        Appointment as = new Appointment();
        System.out.println("Enter the Appointment ID:");
        as.setAppointmentId(sc.nextInt());
        System.out.println("Enter the Patient ID:");
        as.setPatientId(sc.nextInt());
        
        System.out.println("Enter the Doctor ID:");
        as.setDoctorId(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter the appointmentDate: ");
        as.setAppointmentDate(sc.nextLine());
        
        System.out.println("Enter the description: ");
        as.setDescription(sc.nextLine());
        
       ser.scheduleAppointment(as);
       
       
       
        	
        
       
    }
	public void updateSchedule() {
        Appointment as = new Appointment();
        System.out.println("Enter the Appointment ID to be updated :");
        as.setAppointmentId(sc.nextInt());
        System.out.println("Enter the Patient ID:");
        as.setPatientId(sc.nextInt());
        
        System.out.println("Enter the Doctor ID:");
        as.setDoctorId(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter the appointmentDate: ");
        as.setAppointmentDate(sc.nextLine());
        
        System.out.println("Enter the description: ");
        as.setDescription(sc.nextLine());
        
        ser.updateAppointment(as); 
    }
	public void cancelSchedule() {
	    System.out.println("Enter the Appointment ID to cancel:");
	    int appointmentId = sc.nextInt();
	    sc.nextLine(); 
	    ser.cancelAppointment(appointmentId); 
	}
	public void getAppointment() {
	    System.out.println("Enter the Appointment ID to display:");
	    int appointmentId = sc.nextInt();
	     // Consume newline
	        
	    ser.getAppointmentById(appointmentId); 
	}

	public void getAppointmentsForPatients() {
	    System.out.println("Enter the Patient ID to display:");
	    int patientId = sc.nextInt();
	    
	        
	    ser.getAppointmentsForPatient(patientId); 
	}
	public void getAppointmentsForDoctors() {
	    System.out.println("Enter the DoctorID to display:");
	    int doctorId = sc.nextInt();
	    
	        
	    ser.getAppointmentsForDoctor(doctorId); 
	}

}
