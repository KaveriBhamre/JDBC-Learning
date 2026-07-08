package database2;



public class Employee {

    private int id;
    private String name;
    private double salary;
    private String designation;
    private int department_id;

    // Default Constructor
    public Employee() {
    }

    // Parameterized Constructor
    public Employee(int id, String name, double salary, String designation, int department_id) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.designation = designation;
        this.department_id = department_id;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDesignation() {
        return designation;
    }

    public int getDepartment_id() {
        return department_id;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    // toString() (for easy printing)
    @Override
    public String toString() {
        return "Employee [id=" + id +
               ", name=" + name +
               ", salary=" + salary +
               ", designation=" + designation +
               ", department_id=" + department_id + "]";
    }
}