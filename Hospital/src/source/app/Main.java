package source.app;

import java.util.List;
import java.util.Scanner;

import Index.Database;
import Index.User;

public class Main {
	private static Scanner scanner;
	private static Controller controller;

	public Main(Controller controller) {
		scanner = new Scanner(System.in);
		Main.controller = controller;
	}

	public void start() {
		int choice;
		
		choice=loginAcc();
	
	
		if (choice==1) {
			int option;
			System.out.println("You Are Logged In As User");
			System.out.println("----------------------");
			System.out.println("1. Register Account");
			System.out.println("2. User View Latest Booking");
			System.out.println("3. User View Past Booking Records");
			System.out.println("4. Make Booking");
			System.out.println("5. Update Latest Booking");
			System.out.println("6. View Doctor's Details");		
			

			System.out.print("Input your option:");
			option = scanner.nextInt();

			switch (option) {

			case 1:
				registerAcc();
				break;
			case 2:
				userViewLatestBooking();
				break;
			case 3:
				userViewPastBookings();
				break;
			case 4:
				makeBooking();
				break;
			case 5:
				updateLatestBooking();
				break;
			case 6:
				viewDocDetails();
				break;	

			}
			
		}
		else if (choice==2) {
			int option;
			System.out.println("You Are Logged In As Admin");
			System.out.println("----------------------");
			System.out.println("1. Admin View Latest Booking");
			System.out.println("2. Update Doctor's Details");
			

			System.out.print("Input your option:");
			option = scanner.nextInt();

			switch (option) {

			case 1:
				adminViewLatestbooking();
				break;
			case 2:
				updateDocDetails();
				break;

			}
		}
	
	}
	

	public static void registerAcc() {
		User user;

		do {
			System.out.println("=====Register New user=====");
			System.out.println("Enter name:");
			scanner.nextLine();
			String name = scanner.nextLine();
			System.out.println("Enter Email:");
			String email = scanner.nextLine();
			System.out.println("Enter Contact No:");
			String phnum = scanner.nextLine();
			System.out.println("Enter IC:");
			String ic = scanner.next();
			System.out.println("Enter password:");
			String pass = scanner.next();

			user = searchUser(email);

			if (user == null) {
				controller.addnewUser(name, email, ic, phnum,pass);
				controller.writenewUsertoFile(name, email, ic, phnum, pass);
				System.out.println("Account has been registered!!");
			} else {
				System.out.println("Account has already been registered previously !!");
			}
		} while (user != null);
	
	}

	public static User searchUser(String email) {
		User user = controller.searchforUser(email);
		return user;
	}
	public static User searchUseric(String ic) {
		User usercheck = controller.searchforUseric(ic);
		return usercheck;
	}
	public static Admin searchAdminic(String ic) {
		Admin admincheck = controller.searchforAdminic(ic);
		return admincheck;
	}
	public static Admin searchAdminpass(String pass) {
		Admin admincheck = controller.searchforAdminpass(pass);
		return admincheck;
	}
	
public static User searchUserpass(String pass) {
	User usercheck = controller.searchforUserpass(pass);
	return usercheck;
}

	public static void adminViewLatestbooking() {
		int count = controller.getNumberofBookings();
		if (count == 0) {
			System.out.println("No latest booking records found!!");
		} else {

			List<Booking> bookList = controller.getAllLatestBooking();
			System.out.println("All Latest Bookings\n");
			for (int i = 0; i < count; i++) {

				Booking booking = bookList.get(i);
				System.out.println(booking.toString());
				System.out.println("");

			}
		}

	}

	public static void userViewLatestBooking() {
		System.out.println("Input IC to view:");
		String ic = scanner.next();
		Booking book = controller.getOnesLatestBooking(ic);
		
		if(book!=null) {
		System.out.println("Your Bookings\n");
		System.out.println(book.toString());
		System.out.println("");

		}
		else {
			System.out.println("No latest booking records found!!");

		}

	}
	
	public static void userViewPastBookings() {
		System.out.println("Input IC to view:");
		String ic = scanner.next();
		
		List<Booking> pastbook = controller.getOnesPastBooking(ic);
		
		if(pastbook!=null) {
			System.out.println("Your Past Booking Records\n");
			for(int i=0; i<pastbook.size();i++) {
				Booking pastbooking = (Booking) pastbook.get(i);
				System.out.println(pastbooking.toString());
				System.out.println("");
			}
		}
	}
	
	public static void makeBooking() {
		
		Booking booking;
		User user = null;
		String ic;
		
		viewDocDetails();
		System.out.println();
		
		System.out.print("Enter department: ");
		String department = scanner.nextLine();
		System.out.print("Enter Doctor's name: ");
		String doc_name = scanner.nextLine();
		System.out.print("Enter date of booking: ");
		String date = scanner.nextLine();
		System.out.print("Enter time slot selected: ");
		String time = scanner.nextLine();
		System.out.print("Booking description: ");
		String desc = scanner.nextLine();
		System.out.println();
			
		System.out.print("Are you a new user? [Y/N]: ");
		String exist = scanner.next();
		if (exist.equals("Y") || exist.equals("y")) {
			registerAcc();
			System.out.println();
			System.out.print("Enter your NRIC: ");
			ic = scanner.nextLine();
		}
		else {
			System.out.print("Enter email address to retrieve user profile: ");
			String email = scanner.nextLine();
			user = searchUser(email);
			ic = user.getIC();
		}
			
		controller.addnewBooking(ic, department, doc_name, date, time, desc);
		controller.writenewBookingtoFile(ic, department, doc_name, date, time, desc);
		
	}
	
	public static void updateLatestBooking() {
		
		Booking booking;
		User user = null;
		
		do {
			
			System.out.print("Enter email address to retrieve user profile: ");
			String email = scanner.nextLine();
			user = searchUser(email);
			System.out.println("Input IC to view:");
			String ic = scanner.next();
			booking = controller.getOnesLatestBooking(ic);
			
			if(booking!=null) {
				System.out.println("Your Bookings\n");
				System.out.println(booking.toString());
				System.out.println("");

			}
			else {
				System.out.println("No latest booking records found!!");

			}
			
			System.out.print("Enter new date of booking: ");
			String newdate = scanner.nextLine();
			System.out.print("Enter new time slot selected: ");
			String newtime = scanner.nextLine();
			System.out.println();
			
			controller.updateBooking(booking, ic, newdate, newtime);
			
		} while (user != null);
	}
	public static int loginAcc() {
		String password,ic;
		User usercheck,usercheck2;
		Admin admincheck = null,admincheck2 = null;
	int check;
	int status=1;
		int choice;
		
	
			System.out.println("Welcome To The Login Page");
			System.out.println("--------------------------");
			System.out.println("1:User Login |  2:Admin Login");
			check=scanner.nextInt();
			if (check==2) {
				do {
					
					System.out.print("Admin IC: ");
					ic = scanner.next();
					ic += scanner.nextLine();
					System.out.print("Admin Password: ");
					password = scanner.next();
					password += scanner.nextLine();
					
					admincheck=searchAdminic(ic);
	
	admincheck2=searchAdminpass(password);
					if ((admincheck == null) | (admincheck2 == null) )
						System.out.println("Invalid Username/Password");
						System.out.println("--------------------------");
						if ((admincheck != null) && (admincheck2 != null)) {
							status=2;
							
						}
					
				
			}while((admincheck == null) | (admincheck2 == null));
				
				
			}
			
			
			else if (check==1) {
				System.out.println("Press 1: Login, Press 2:Register");
				choice=scanner.nextInt();
				
					if (choice==1) {
						do {
							System.out.print("IC: ");
							ic = scanner.next();
							ic += scanner.nextLine();
							System.out.print("Password: ");
							password = scanner.next();
							password += scanner.nextLine();
							
							usercheck=searchUseric(ic);
							usercheck2=searchUserpass(password);
							
							
							if ((usercheck == null) | (usercheck2 == null) )
							System.out.println("Invalid Username/Password");
							System.out.println("--------------------------");
							
						}while  ((usercheck == null) | (usercheck2 == null) );
						
						}
						
						else if (choice==2) {
							registerAcc();
							System.out.println("--------------------------");	
							choice=1;
						}
						else {
							System.out.print("Invalid Choice");
						}
			}
			
			
				
			
		return status;	
		
	}
	public static void viewDocDetails() {}

	public static void updateDocDetails() {
		
	}
	
}
