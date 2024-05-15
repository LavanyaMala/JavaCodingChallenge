package com.java.mainmod;

import java.util.List;
import java.util.Scanner;
import com.java.demo.service.ServiceHospital;
import com.java.model.Appointment;
import com.java.model.Patient;
import com.java.myexception.PatientNumberNotFoundException;
import com.java.demo.dao.HospitalServiceImpl;
import com.java.demo.dao.IHospitalService;

public class MainModule {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        
        
        HospitalServiceImpl hospitalService = new HospitalServiceImpl();
        ServiceHospital serviceHospital = new ServiceHospital(hospitalService);
        
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Get Appointment by ID");
            System.out.println("2. Get Appointments for Patient");
            System.out.println("3. Get Appointments for Doctor");
            System.out.println("4. Schedule Appointment");
            System.out.println("5. Update Appointment");
            System.out.println("6. Cancel Appointment");
            System.out.println("7. Exit");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            try {
            	
         
            
            switch (choice) {
                case 1:
                    
                    serviceHospital.getAppointment();
                    break;
                   
                case 2:
                    
                    serviceHospital.getAppointmentsForPatients();
                    break;
                    
                case 3:
                    
                    serviceHospital.getAppointmentsForDoctors();
                    break;
                    
                case 4:
                    
                    serviceHospital.Schedule();
                    break;
                case 5:
                    
                    serviceHospital.updateSchedule();
                    break;
                    
                case 6:
                	serviceHospital.cancelSchedule();
                	break;
                    
                case 7:
                    
                    exit = true;
                    break;
                    
                default:
                    System.out.println("Invalid try again.");
            }
            }
            catch(Exception e)
            {
            	System.out.println("Exception occurred" + e.getMessage());
            }
        
        
            Patient patient = new Patient(123, "Lava", "A", "1990-01-01", "Female", "1234567890");

            
            int PatientId = 123; // Example patient ID

            try {
                
                List<Appointment> appointments = patient.getAppointmentsForPatient(PatientId);
                
              
                
                }
             catch (PatientNumberNotFoundException e) {
                System.out.println("Patient number not found: " + e.getMessage());
            }
        }
        }
    }


        

    