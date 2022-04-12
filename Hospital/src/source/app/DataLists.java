package source.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class DataLists implements IDataList {
	
	FileWrite fw = new FileWrite();
	private List<User> userList = fw.readUserFile();
	private List<Booking> latestbookingList;
	private List<Booking> pastbookingList;
	private List<Booking> onespastbook;
	private List<Admin> adminList=fw.readAdminFile();
	
	
	ListIterator lib;

	public DataLists() {

		userList = new ArrayList<User>();
		latestbookingList = new ArrayList<Booking>();
		userList = fw.readUserFile();
		latestbookingList = fw.readLatestBookingFile();
	
		onespastbook = new ArrayList<Booking>();

	}

	@Override
	public List<Booking> getAllLatestBooking() {
		return latestbookingList;
	}
	
	@Override
	public void newBooking(Booking aBooking) {
		latestbookingList.add(aBooking);
	}

	@Override
	public void registerAccount(User aUser) {
		userList.add(aUser);
	}

	
	@Override
	public User searchUser(String email) {
		
		for (int i = 0; i < userList.size(); i++) {
			User user = (User) userList.get(i);
			if (user.getEmail().equals(email)) {
				return user;
			}
		}

		return null;
		
		/*
		boolean found = false;
		liu = userList.listIterator();
		while (lib.hasNext()) {
			User u = (User)liu.next();
			if(u.getEmail().equals(email)) {
				found = true;
				return u;
			}
		}
		if(!found)
			return null;
		
		return null;
		*/

	}
public User searchUseric(String ic) {
		
		for (int i = 0; i < userList.size(); i++) {
			User user = (User) userList.get(i);
			if (user.getIC().equals(ic)) {
				return user;
			}
		}
      	return null;
	}
public Admin searchAdminic(String ic) {
	
	for (int i = 0; i < userList.size(); i++) {
		Admin admin = (Admin) adminList.get(i);
		if (admin.getIC().equals(ic)) {
			return admin;
		}
	}
  	return null;
}
public Admin searchAdminpass(String pass) {
	
	for (int i = 0; i < userList.size(); i++) {
		Admin admin = (Admin) adminList.get(i);
		if (admin.getPass().equals(pass)) {
			return admin;
		}
	}
  	return null;
}



public User searchUserpass(String pass) {
	
	for (int i = 0; i < userList.size(); i++) {
		User user = (User) userList.get(i);
		if (user.getPass().equals(pass)) {
			return user;
		}
	}
  	return null;
}

	@Override
	public int getAllNumberofBookings() {
		return latestbookingList.size();
	}

	@Override
	public Booking getOnePersonBooking(String ic) {

		boolean found = false;
		lib = latestbookingList.listIterator();
		while (lib.hasNext()) {
			Booking b = (Booking)lib.next();
			if(b.getpIc().equals(ic)) {
				found = true;
				return b;
			}
		}
		if(!found)
			return null;
		
		return null;
		/*
		for (int i = 0; i < latestbookingList.size(); i++) {

			Booking booking = latestbookingList.get(i);
			if (booking.getpIc().equals(ic)) {
				return booking;
			}
		}

		return null;
		*/
	}
	
	@Override
	public List<Booking> getOnesPastBooking(String ic) {

		for (int i = 0; i < pastbookingList.size(); i++) {

			Booking booking = pastbookingList.get(i);
			if (booking.getpIc().equals(ic)) {
				onespastbook.add(booking);
			}
		}
		return onespastbook;
	}

	@Override
	public void updateLatestBooking(Booking aBooking, String ic, String newDate, String newTime) {
		
		boolean found = false;
		lib = latestbookingList.listIterator();
		while (lib.hasNext()) {
			aBooking = (Booking)lib.next();
			if(aBooking.getpIc().equals(ic)) {
				lib.set(new Booking(aBooking.getpIc(), aBooking.getdocDepartment(), aBooking.getdocName(), newDate, newTime, aBooking.getBookingDesc()));
				found = true;
			}
		}
		
		if(!found)
			System.out.println("Record not found");
		
	}
	

}
