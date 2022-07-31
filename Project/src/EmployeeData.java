import java.util.Scanner;

public class EmployeeData {
	
	// Attributes
	public String employeeName; 
	public int employeeID = 0;
	public double annualSalary;
	public String[] employeeNames = new String[100];
	public int[] employeeIDs = new int[100];
	public double[] employeeSalaries = new double[100];
	public int numOfEmployees = 0; // Initialized the number of employees to 0.
	public static final Scanner scan = new Scanner(System.in);
	public boolean duplicate = false; // Checks for duplicate ID numbers
	public boolean match = false; // Checks for matches in employee search
	public int searchID = 0; 
	public double lowestSalary = 0; 
	public double highestSalary = 0;
	
	// Constructor with no values set
	public EmployeeData() {
	}
	
	// Constructor to set all values
	public EmployeeData(String employeeName, int employeeID, double annualSalary, int numOfEmployees) {
		this.employeeName = employeeName;
		this.employeeID = employeeID;
		this.annualSalary = annualSalary;
		this.numOfEmployees = numOfEmployees;
	}
	
	//Methods
	
	// Reads in employee data (name, ID, and salary) from a user
	public void readInEmployeeData(){
		
		
		//Prompt to enter the employee name
		System.out.println("\nEnter Employee Name: ");
		//Reads in employee name from the user
		employeeName = scan.nextLine();
		System.out.println();
		
		// Repeats loop if user does not enter a 5 digit number or the number is a duplicate.
		do {
			// Prompt the user for an Employee ID
			System.out.println("Enter Employee ID (5 digit number):");
			// Reads in the user's input for the Employee ID
			employeeID = scan.nextInt();
			System.out.println();
			
			// If the user enters a number less than or greater than 5 digits, display error message
			if((employeeID < 10000) || (employeeID > 99999)) {
				System.out.println("\t\t*Please enter a valid ID*\n");
			}
			
			/* Checks to see if the employee ID already exists in the employeeID array
			 * and displays an error message. */
			for(int i = 0; i < numOfEmployees; i++) {
				while(employeeID == employeeIDs[i]) {
					System.out.println("\t\t*Duplicate ID. Please enter a different 5 digit number.*");
					System.out.println("");
					employeeID = scan.nextInt();
					System.out.println();
				}
			}
		} while ((employeeID < 10000) || (employeeID > 99999));
		
		// Displays prompt to enter the employee's yearly salary.
		System.out.println("Enter Employee Yearly Salary:");
		annualSalary = scan.nextDouble();
		System.out.println();
		scan.nextLine();
		}
    
	// Reads in employee data based on the number of employees the user inputs
	public void loadEmployeesData() {
		
		// Repeats the loop if the user inputs an invalid number of employees.
		do {
			// Prompt for user to enter the number of employees they'd like to enter data for
			System.out.println("\nHow many employees would you like to input into the system?:");
			// Reads in the number of employees
			numOfEmployees = scan.nextInt();
			scan.nextLine();
				
			// Displays an error message if the user enters an invalid number of employees
			if((numOfEmployees < 1) || (numOfEmployees > 100)) {
				System.out.println("\n*Please enter a valid number of employees (More than 0 and less than 101)*\n");
				numOfEmployees = scan.nextInt();
			}
		} while ((numOfEmployees < 1) || (numOfEmployees > 100)) ;

		// Reads in employee data and stores them in arrays.
		for(int i = 0; i < numOfEmployees; i++) {
			readInEmployeeData();
			employeeNames[i] = employeeName;
			employeeIDs[i] = employeeID;
			employeeSalaries[i] = annualSalary;
		}	
	}
	
	
	// Add's one employee to the system based on user's input for their name, id, and salary.
	public void addEmployee() {
		
		// If the number of employees is already at 100, display an error.
		if(numOfEmployees == 100) {
			System.out.println("Your Employee Management System is full.");
		}
		else {
			// Reads in the employee's data and stores it in arrays.
			readInEmployeeData();
			employeeNames[numOfEmployees] = employeeName;
			employeeIDs[numOfEmployees] = employeeID;
			employeeSalaries[numOfEmployees] = annualSalary;
			numOfEmployees++;

			System.out.printf("\nNAME: " + employeeName + "\n\t ID: " + employeeID + "\n\t ANNUAL SALARY: $%.2f", annualSalary);
			System.out.println("\n\t\t*Employee Added*");
			System.out.println();
		}
	}
	
	// Displayes all of the employees in the system
	public void displayAllEmployees() {
		
		// If there are no employees, displays an error message
		if(numOfEmployees == 0) {
			System.out.println("\t\t*No Employees in the System*");
			System.out.println();
		}
		else {
			for (int i = 0; i < numOfEmployees; i++) {
				System.out.printf("NAME: " + employeeNames[i] + "\n\t ID: " + employeeIDs[i] + "\n\t ANNUAL SALARY: $%.2f", employeeSalaries[i]);
				System.out.println();
			}
			System.out.println();
		}
	}
	
	// Searches for an employee based on the employee ID number entered by the user.
	public void searchForEmployee() {
		
		// If there are no employees, displays an error message
		if(numOfEmployees == 0) {
			System.out.println("\t\t*No Employees in the System*");
			System.out.println();
		}
		else {
			// If the user enters an invalid ID number, repeat the loop
			do {
				// Prompt to enter the desired employee's id numnber
				System.out.println("\nPlease enter the employee's 5 digit ID number:");
				// Reads in employee ID number
				searchID = scan.nextInt();
				System.out.println();
				
				// Displays error message if the user enters an invalid ID number.
				if((searchID < 10000) || (searchID > 99999)) {
					System.out.println("\t\t*Please enter a valid ID*\n");
				}
				else {
					//Searches for the employee and displays their information
					for(int i = 0; i < numOfEmployees; i++) {
						if(searchID == employeeIDs[i]) {
							System.out.printf("\nNAME: " + employeeNames[i] + "\n\t ID: " + employeeIDs[i] + "\n\t ANNUAL SALARY: $%.2f", employeeSalaries[i]);
							System.out.println();
							System.out.println();
							
							match = true;
							// breaks from loop if the user's information is found
							break;
						}
						else {
							match = false;
						}
					}
					
					// Displays error message if employee ID not found
					if(!match) {
						System.out.println("\t\t*Employee ID number does not exist*");
						System.out.println();
					}
				}
			} while ((searchID < 10000) || (searchID > 99999));
		}
	}
	
	// Searches for employees based on the salary range entered by the user
	public void employeesBasedOnRange() {
		
		//If there are no employees, displays an error message
		if(numOfEmployees == 0) {
			System.out.println("\t\t*No Employees in the System*");
			System.out.println();
		}
		else {
			match = false;
		
			//Repeat loop if the user enters an invalid salary range
			do {
				// Displays prompt to enter the lowest salary in the range
				System.out.println("\nPlease enter the lowest salary:");
				// Reads in the user's lowest salary
				lowestSalary = scan.nextDouble();
				System.out.println();
			
				// Displays prompt to enter the highest salary in the range
				System.out.println("Please enter the highest salary:");
				// Reads in the user's highest salary
				highestSalary = scan.nextDouble();
				
				// Display an error message if the user enters an invalid range
				if(lowestSalary > highestSalary) {
					System.out.println();
					System.out.println("\t\t*Please ensure the lowest salary entered is lower than the highest salary*");
				}
			} while (lowestSalary > highestSalary);
			
			// Searches for employees within the provided salary range and displays their information
			for(int i = 0; i < numOfEmployees; i++) {
				if((employeeSalaries[i] >= lowestSalary) && (employeeSalaries[i] <= highestSalary)) {
					System.out.printf("\nNAME: " + employeeNames[i] + "\n\t ID: " + employeeIDs[i] + "\n\t ANNUAL SALARY: $%.2f", employeeSalaries[i]);
					System.out.println();
					System.out.println();
					match = true;
				}
			}
			// If there are no employees within the provided range, display message
			if(!match) {
				System.out.println("\n\t\t*No salaries are within that range*");
				System.out.println();
			}
		}
	}
		
}
	
			


	
	



