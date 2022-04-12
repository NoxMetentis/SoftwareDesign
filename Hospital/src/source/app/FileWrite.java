package source.app;

import java.io.*;
import java.util.*;

public class FileWrite {

	//ObjectOutputStream oosu;
	//ObjectInputStream oisu;
	//ListIterator liu;
	ObjectOutputStream oosb;
	ObjectInputStream oisb;
	ListIterator lib;
	
	public FileWrite() {
	}

	File userfile = new File("User.txt");
	File latestbookingfile = new File("LatestBooking.txt");
	File pastbookingfile = new File("PastBooking.txt");
	File adminfile= new File("Admin.txt");

	Scanner read;

	public void writeUsertoFile(User user) {

		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(userfile, true));
		} catch (IOException e) {
			System.out.println("File not found!!");
		}

		pw.println(user.getName() + "---" + user.getEmail() + "---" + user.getIC() + "---" + user.getPhNum()+ "---" + user.getPass());

		pw.close();
		
		/*
		DataLists userList = null;
		
		if(userfile.isFile()) {
			try {
				oosu = new ObjectOutputStream(new FileOutputStream(userfile));
				oosu.writeObject(userList);
				oosu.close();
			} catch (IOException i) {
				System.out.println("IOException");
			}
		}
		else {
			System.out.println("File not found!!");
		}
		*/
		

	}

	public ArrayList<User> readUserFile() {

		ArrayList<User> userList = new ArrayList<User>();
		
		try {
			read = new Scanner(userfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found!!");
		}

		while (read.hasNext()) {

			String[] info = read.nextLine().split("---");

			User user = new User(info[0], info[1], info[2], info[3], info[4]);
			userList.add(user);
		}
		
		return userList;
		
		/*
		if(userfile.isFile()) {
			try {
				oisu = new ObjectInputStream(new FileInputStream(userfile));
				userList = (ArrayList<User>)oisu.readObject();
				oisu.close();
			} catch (ClassNotFoundException | IOException i) {
				System.out.println("IOException");
			}
		}
		else {
			System.out.println("File not found!!");
		}
		*/
		
	}
	public ArrayList<Admin> readAdminFile() {

		ArrayList<Admin> AdminList = new ArrayList<Admin>();
		
		try {
			read = new Scanner(userfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found!!");
		}

		while (read.hasNext()) {

			String[] info = read.nextLine().split("---");

			Admin admin = new Admin(info[0], info[1], info[2], info[3], info[4]);
			AdminList.add(admin);
		}
		
		return AdminList;
		
		
		
	}
	
	public void writeBookingtoFile(Booking booking) {
		
		DataLists latestbookingList = null;
		
		if(latestbookingfile.isFile()) {
			try {
				oosb = new ObjectOutputStream(new FileOutputStream(latestbookingfile));
				oosb.writeObject(latestbookingList);
				oosb.close();
			} catch (IOException i) {
				System.out.println("IOException");
			}
		}
		else {
			System.out.println("File not found!!");
		}
		
		/*
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(latestbookingfile, true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found!!");
		}

		pw.println(booking.getpIc() + "---" + booking.getdocName() + "---" + 
		booking.getBookDate() + "---" + booking.getBookTime() + "---" + booking.getBookingDesc() );

		pw.close();
		*/
		
	}
	
	public ArrayList<Booking> readLatestBookingFile() {
		
		
		ArrayList<Booking> latestBookingList = new ArrayList<Booking>();
		
		if(latestbookingfile.isFile()) {
			try {
				oisb = new ObjectInputStream(new FileInputStream(latestbookingfile));
				latestBookingList = (ArrayList<Booking>)oisb.readObject();
				oisb.close();
			} catch (ClassNotFoundException | IOException i) {
				System.out.println("IOException");
			}
		}
		else {
			System.out.println("File not found!!");
		}
		
		/*
		try {
			read = new Scanner(latestbookingfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found!!");
		}

		while (read.hasNext()) {

			String[] info = read.nextLine().split("---");

			Booking booking = new Booking(info[0], info[1], info[2], info[3], info[4], info[5]);
			latestBookingList.add(booking);
		}
		*/
		
		return latestBookingList;
	}
	
	public void writePastBookingtoFile(Booking booking) {
		
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(pastbookingfile, true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found!!");
		}

		pw.println(booking.getpIc() + "---" + booking.getdocName() + "---" + 
		booking.getBookDate() + "---" + booking.getBookTime() + "---" + booking.getBookingDesc() );

		pw.close();
		
	}
	
	
	public void updateLatestBookingtoFile(Booking booking, String ic, String newDate, String newTime) {
		
		ArrayList<Booking> latestbookingList = new ArrayList<Booking>();
		
		if(latestbookingfile.isFile()) {
			try {
				oisb = new ObjectInputStream(new FileInputStream(latestbookingfile));
				latestbookingList = (ArrayList<Booking>)oisb.readObject();
				oisb.close();
			} catch (ClassNotFoundException | IOException i) {
				System.out.println("IOException");
			}
			
			boolean found = false;
			lib = latestbookingList.listIterator();
			while (lib.hasNext()) {
				booking = (Booking)lib.next();
				if(booking.getpIc().equals(ic)) {
					lib.set(new Booking(booking.getpIc(), booking.getdocDepartment(), booking.getdocName(), newDate, newTime, booking.getBookingDesc()));
					found = true;
				}
			}
			if(found) {
				try {
					oosb = new ObjectOutputStream(new FileOutputStream(latestbookingfile));
					oosb.writeObject(latestbookingList);
					oosb.close();
				} catch (IOException i) {
					System.out.println("IOException");
				}
			}
			else {
				System.out.println("Record not found");
			}
		}
		else {
			System.out.println("File not found!!");
		}
	}
}
