package source.app;

import java.io.*;

public class Booking implements Serializable{
	
	private String patient_ic;
	private String doc_department;
	private String doc_name;
	private String booking_date;
	private String booking_time;
	private String booking_desc;
	
	public Booking() {}
	
	public Booking (String patient_ic, String doc_name, String doc_department, String booking_date, String booking_time, String booking_desc) {
		this.patient_ic=patient_ic;
		this.doc_department=doc_department;
		this.doc_name=doc_name;
		this.booking_date=booking_date;
		this.booking_time=booking_time;
		this.booking_desc=booking_desc;
		
	}
	
	public String getpIc() {
		return patient_ic;
	}
	
	public String getdocDepartment() {
		return doc_department;
	}
	
	public String getdocName() {
		return doc_name;
	}
	
	public String getBookDate() {
		return booking_date;
	}
	
	public String getBookTime() {
		return booking_time;
	}
	
	public String getBookingDesc() {
		return booking_desc;
	}
	
	public String toString() {
		String str;

		str="Patient IC: " + this.patient_ic + "\n Department: " + this.doc_department + "\n Doctor Name: " + this.doc_name + "\n Booking Date: " 
				+this.booking_date + "\n Booking Time: " + this.booking_time + "\n Booking Description: " 
				+ this.booking_desc;
		
		return str;
	}
	

}
