package database2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DoConnection.getAllEmployee();
		
		// INSERT
	    Employee emp = new Employee(7, "Sairaj", 50000, "Developer", 1);
	    DoConnection.insertEmployee(emp);
	    DoConnection.getAllEmployee();


	    // UPDATE
	    Employee updatedEmp = new Employee(7, "Kaveri Bhamre", 60000, "Senior Dev", 2);
	    DoConnection.updateEmployee(7,updatedEmp);
	    DoConnection.getAllEmployee();


	    // SEARCH
	    Employee found = DoConnection.searchEmployeeById(7);
	    if(found != null) {
	        System.out.println(found.getName());
	    }
	    DoConnection.getAllEmployee();


	    // DELETE
	    DoConnection.deleteEmployeeById(7);

	    // DISPLAY ALL
	    DoConnection.getAllEmployee();
		
		

	}

}
