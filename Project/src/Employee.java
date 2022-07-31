import java.util.Scanner;

public class Employee {
	
	// Attributes
	private int menuOption = 0; // Initializes the menu option
	public static final Scanner scan = new Scanner(System.in);
	EmployeeData ed = new EmployeeData(); // Creates an instance of EmployeeData
	
	// Methods
	
	// Displays program title
	public static void welcomeMessage() {
		System.out.println("\t\tEmployee Data Management System");
		System.out.println("\t\t-------------------------------");
		
	}
	
	// Displays menu options
	public static void displayMenuOptions() {
		System.out.println("1. Load Initial Employees' Data");
		System.out.println("2. Add New Employee");
		System.out.println("3. Display All Employees");
		System.out.println("4. Retrieve Specific Employee Data");
		System.out.println("5. Retrieve Employees (with salaries based on range)");
		System.out.println("6. Exit Program");
		
	}
	
	// Runs the menu options
	public void menuOptions() {
		
		do {
			
			// Display menu options
			displayMenuOptions();
			
			//Display prompt for user to select menu option
			System.out.println("\nPlease enter a menu option (1-6):");
			
			// Read in user's menu choice
			menuOption = scan.nextInt();
			
			//If the user's choice is invalid, repeat loop
			switch (menuOption) {
			case 1:
				// Calls method for user to enter multiple employee's data
				ed.loadEmployeesData();
				menuOptions(); // Displays menu after running method
				break;
			case 2:
				// Calls method for user to add an Employee 
				ed.addEmployee();
				menuOptions(); // Displays menu after running method
				break;
			case 3:
				// Calls method for user to add an Employee 
				ed.displayAllEmployees();
				menuOptions(); // Displays menu after running method
				break;
			case 4:
				// Calls method for user to search for a specific employee
				ed.searchForEmployee();
				menuOptions(); // Displays menu after running method
				break;
			case 5:
				// Calls method for user to search for employees based nm a salary range
				ed.employeesBasedOnRange();
				menuOptions(); // Displays menu after running method
				break;
			case 6:
				//Display exit message
				System.out.println("\n   Thank you for using the Employee Data Management System");
				System.out.println("\n\t\t\t  Good-bye!");
				break;
			default:
				//Display error message
				System.out.println("\n*Please select a valid menu option (1-6)*\n");
				break;
				
			}

		} while ((menuOption < 1) || (menuOption > 6)); //Repeat loop if user enters invalid number


}
	

}