package com.java.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import com.java.connect.DBConnUtil;
import com.java.model.Appointment;
import com.java.myexception.PatientNumberNotFoundException;

public class HospitalServiceImpl implements IHospitalService {
    
    private Connection con;
    PreparedStatement stat;

    public HospitalServiceImpl() {
        con = DBConnUtil.getConnect();
    }

    @Override
    public boolean scheduleAppointment(Appointment appointment) {
        try {
        	
	        
            stat = con.prepareStatement("insert into Appointment(appointmentId,patientId,doctorId,appointmentDate,description) values(?,?,?,?,?)");
            stat.setInt(1, appointment.getAppointmentId());
            stat.setInt(2, appointment.getPatientId());
            stat.setInt(3, appointment.getDoctorId());
            stat.setString(4, appointment.getAppointmentDate());
            stat.setString(5, appointment.getDescription());

            stat.executeUpdate();
            System.out.println("Hospital data added successfully");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

	    @Override
	    public Appointment getAppointmentById(int appointmentId) {
	        Appointment appointment = null;
	        ResultSet rs = null;
	        PreparedStatement statement = null;
	        Connection con = null;

	        try {
	            
	            con = DBConnUtil.getConnect();
	            String exe = "SELECT * FROM Appointment WHERE appointmentId = ?";
	            statement = con.prepareStatement(exe);
	            statement.setInt(1, appointmentId);
	            rs = statement.executeQuery();

	            
	            if (rs.next()) {
	                appointment = new Appointment();
	                appointment.setAppointmentId(rs.getInt("appointmentId"));
	                appointment.setPatientId(rs.getInt("patientId"));
	                appointment.setDoctorId(rs.getInt("doctorId"));
	                appointment.setAppointmentDate(rs.getString("appointmentDate"));
	                appointment.setDescription(rs.getString("description"));

	               
	                System.out.println("Appointment ID: " + appointment.getAppointmentId());
	                System.out.println("Patient ID: " + appointment.getPatientId());
	                System.out.println("Doctor ID: " + appointment.getDoctorId());
	                System.out.println("Appointment Date: " + appointment.getAppointmentDate());
	                System.out.println("Description: " + appointment.getDescription());
	            } else {
	                System.out.println("No appointment found with ID: " + appointmentId);
	            }
	        } catch (Exception e) {
	           
	            System.out.println(e.getMessage());
	        } 
	        return appointment;
	    }
	



        

    @Override
    
    public List<Appointment> getAppointmentsForPatient(int patientId) {
        List<Appointment> appointments = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection con = null;
        
        
    	

        try {
        	
            con = DBConnUtil.getConnect();
            String exe1 = "SELECT * FROM Appointment WHERE patientId = ?";
            statement = con.prepareStatement(exe1);
            statement.setInt(1, patientId);
            rs = statement.executeQuery();

            while (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setAppointmentId(rs.getInt("appointmentId"));
                appointment.setPatientId(rs.getInt("patientId"));
                appointment.setDoctorId(rs.getInt("doctorId"));
                appointment.setAppointmentDate(rs.getString("appointmentDate"));
                appointment.setDescription(rs.getString("description"));
                appointments.add(appointment);
            }

            
            if (!appointments.isEmpty()) {
                System.out.println("Appointments for Patient ID " + patientId + ":");
                for (Appointment appointment : appointments) {
                    System.out.println("Appointment ID: " + appointment.getAppointmentId());
                    System.out.println("Doctor ID: " + appointment.getDoctorId());
                    System.out.println("Appointment Date: " + appointment.getAppointmentDate());
                    System.out.println("Description: " + appointment.getDescription());
                    System.out.println();
                }
            } else {
                System.out.println("Patient number not found" + patientId);
            }
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        
        }

        return appointments;
    }


    
    @Override
    public List<Appointment> getAppointmentsForDoctor(int doctorId) {
    	
    	    List<Appointment> appointments = new ArrayList<>();
    	    ResultSet rs = null;
    	    PreparedStatement statement = null;
    	    Connection con = null;

    	    try {
    	        con = DBConnUtil.getConnect();
    	        String sql = "SELECT * FROM Appointment WHERE doctorId = ?";
    	        statement = con.prepareStatement(sql);
    	        statement.setInt(1, doctorId);
    	        rs = statement.executeQuery();

    	        while (rs.next()) {
    	            Appointment appointment = new Appointment();
    	            appointment.setAppointmentId(rs.getInt("appointmentId"));
    	            appointment.setPatientId(rs.getInt("patientId"));
    	            appointment.setDoctorId(rs.getInt("doctorId"));
    	            appointment.setAppointmentDate(rs.getString("appointmentDate"));
    	            appointment.setDescription(rs.getString("description"));
    	            appointments.add(appointment);
    	        }

    	       
    	        if (!appointments.isEmpty()) {
    	            System.out.println("Appointments for Doctor ID " + doctorId + ":");
    	            for (Appointment appointment : appointments) {
    	                System.out.println("Appointment ID: " + appointment.getAppointmentId());
    	                System.out.println("Patient ID: " + appointment.getPatientId());
    	                System.out.println("Appointment Date: " + appointment.getAppointmentDate());
    	                System.out.println("Description: " + appointment.getDescription());
    	                System.out.println();
    	            }
    	        } else {
    	            System.out.println("No appointments found for Doctor ID " + doctorId);
    	        }
    	    } catch (Exception e) {
    	    	System.out.println(e.getMessage());
    	    } 

    	    return appointments;
    	}

        
    

    @Override
    
    	public boolean updateAppointment(Appointment appointment) {
    	    try {
    	        
    	        PreparedStatement statement = con.prepareStatement(
    	            "UPDATE appointment SET patientId = ?, doctorId = ?, appointmentDate = ?, description = ? WHERE appointmentId = ?"
    	        );
    	        
    	        
    	        statement.setInt(1, appointment.getPatientId());
    	        statement.setInt(2, appointment.getDoctorId());
    	        statement.setString(3, appointment.getAppointmentDate());
    	        statement.setString(4, appointment.getDescription());
    	        statement.setInt(5, appointment.getAppointmentId());
    	        
    	        
    	        int rowsAffected = statement.executeUpdate();

    	        
    	        if (rowsAffected > 0) {
    	            System.out.println("Appointment updated successfully.");
    	            return true; 
    	        } else {
    	            System.out.println("Failed to update appointment.");
    	            return false; 
    	        }
    	    } catch (Exception e) {
    	        System.out.println("Error updating appointment: " + e.getMessage());
    	        return false; 
    	    }
    	}


    @Override
   
    public boolean cancelAppointment(int appointmentId) {
        try {
           
            PreparedStatement statement = con.prepareStatement("DELETE FROM appointment WHERE appointmentId = ?");
            statement.setInt(1, appointmentId);
            
           
            int rowsAffected = statement.executeUpdate();
            
            
            if (rowsAffected > 0) {
                System.out.println("Appointment cancelled successfully.");
                return true;
            } else {
                System.out.println("No appointment found with ID: " + appointmentId);
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error cancelling appointment: " + e.getMessage());
            return false;
        }
    }


   
}
