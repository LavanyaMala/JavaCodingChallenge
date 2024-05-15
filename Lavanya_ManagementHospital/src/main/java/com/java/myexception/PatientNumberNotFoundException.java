package com.java.myexception;



public class PatientNumberNotFoundException extends Exception {
    public PatientNumberNotFoundException(String message) {
        super(message);
    }
}