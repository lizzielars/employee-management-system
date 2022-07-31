/*
 * 
 * @author: Elizabeth Larson
 * Date: 03/07/2021
 * Description: This program acts as an employee data management system. It displays a menu and
 * provides the user with options to load multiple employees information, add a new employee, 
 * display all the employees, retrieve specific employee's data, retrieve employees' data base on 
 * a salary range, and exit the program.
 * 
 */
public class EmployeeDataManagement {
	
	public static void main(String[] args) {
		
		//  Creating an instance of Employee		
		Employee emp = new Employee();

		//Display program title
		Employee.welcomeMessage();
		
		System.out.println();

		//Display Menu
		emp.menuOptions();
		
	}
}
