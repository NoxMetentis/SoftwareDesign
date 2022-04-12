package source.app;

import java.util.List;

public interface IDataList {

	public List<Booking> getAllLatestBooking();
	public void newBooking(Booking aBooking);
	public void registerAccount(User aUser);
	public User searchUser(String email);
	public int getAllNumberofBookings();
	public Booking getOnePersonBooking(String ic);
	public List<Booking> getOnesPastBooking(String ic);
	public void updateLatestBooking(Booking aBooking, String ic, String newDate, String newTime);
	public User searchUseric(String ic);
	public User searchUserpass(String pass);
	public Admin searchAdminic(String ic);
	public Admin searchAdminpass(String pass);
	
	
}
