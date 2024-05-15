package com.java.model;
import java.util.List;
import java.util.ArrayList;

import com.java.myexception.PatientNumberNotFoundException;

public class Patient {
	int patientId;
	String firstName;
	String lastName;
	String dateOfBirth;
	String gender;
	int contactNumber;
	String address;
	
	
	public Patient() {
    }
	public Patient(int patientId, String firstName, String lastName, String dateOfBirth, String gender,
			String address) {
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.address = address;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", contactNumber=" + contactNumber
				+ ", address=" + address + "]";
	}
	public List<Appointment> getAppointmentsForPatient(int patientId) throws PatientNumberNotFoundException {
        
        if (patientId != this.patientId) {
            throw new PatientNumberNotFoundException("Patient with ID " + patientId + " not found in the database.");
        }

       
        List<Appointment> appointments = new ArrayList<>();
       
        return appointments;
    }

}

