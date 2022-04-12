package source.app;

import java.util.List;

public class Controller {

	
	private IDataList dataLists;

	public Controller(IDataList dataLists) {

			this.dataLists = dataLists;
	}

	public void addnewUser(String name, String email, String ic, String phnum,String pass) {

		User aUser = new User(name,email,ic,phnum,pass);
		dataLists.registerAccount(aUser);
	}

	public void writenewUsertoFile(String name, String email, String ic, String phnum,String pass) {
		User aUser = new User(name,email,ic,phnum,pass);
		FileWrite fw = new FileWrite();
		fw.writeUsertoFile(aUser);
	}

	public User searchforUser(String email) {
		// TODO Auto-generated method stub
		User user = dataLists.searchUser(email);
		return user;
	}
	public User searchforUseric(String ic) {
		// TODO Auto-generated method stub
		User usercheck = dataLists.searchUseric(ic);
		return usercheck;
	}
	public Admin searchforAdminic(String ic) {
		// TODO Auto-generated method stub
		Admin admincheck = dataLists.searchAdminic(ic);
		return admincheck;
	}
	public Admin searchforAdminpass(String pass) {
		// TODO Auto-generated method stub
		Admin admincheck2 = dataLists.searchAdminpass(pass);
		return admincheck2;
	}

	public User searchforUserpass(String pass) {
		// TODO Auto-generated method stub
		User usercheck2 = dataLists.searchUserpass(pass);
		return usercheck2;
	}
	public void addnewBooking(String patient_ic, String department, String doc_name, String date, String time, String desc) {
		Booking aBooking = new Booking(patient_ic, department, doc_name, date, time, desc);
		dataLists.newBooking(aBooking);
	}
	
	public void writenewBookingtoFile(String patient_ic, String department, String doc_name, String date, String time, String desc) {
		Booking aBooking = new Booking(patient_ic, department, doc_name, date, time, desc);
		FileWrite fw = new FileWrite();
		fw.writeBookingtoFile(aBooking);
	}

	public List<Booking> getAllLatestBooking() {

		return dataLists.getAllLatestBooking();
	}
	
	public int getNumberofBookings() {
		return dataLists.getAllNumberofBookings();
	}

	public Booking getOnesLatestBooking(String ic) {

		Booking booking  = dataLists.getOnePersonBooking(ic);
		return booking;
	}

	public List<Booking> getOnesPastBooking(String ic) {
		return dataLists.getOnesPastBooking(ic);
	}


	public void updateBooking(Booking aBooking, String ic, String newDate, String newTime) {
		dataLists.updateLatestBooking(aBooking, ic, newDate, newTime);
		FileWrite fw = new FileWrite();
		fw.updateLatestBookingtoFile(aBooking, ic, newDate, newTime);
	}
	
}
