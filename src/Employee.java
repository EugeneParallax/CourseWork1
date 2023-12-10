public class Employee {
    static int employeeIDCounter;

    private int employeeID;
    private String firstName;
    private String lastName;
    private String patronymic;
    private Byte branch;
    private int salary;

    // Class Constructor
    public static Employee createEmployee(String lastName, String firstName, String patronymic, int branch, int salary) {
        Employee employee = new Employee();
        employee.employeeID = employeeIDCounter;
        employeeIDCounter += 1;

        employee.firstName = firstName;
        employee.lastName = lastName;
        employee.patronymic = patronymic;
        employee.branch = (byte) branch;
        employee.salary = salary;

        return employee;
    }
    // Getters and Setters
    public int getEmployeeID() {
        return this.employeeID;
    }

    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Byte getBranch() {
        return branch;
    }
    public void setBranch(int branch) {
        this.branch = (byte) branch;
    }

    public int getSalary(){ return salary; }
    public void setSalary(int salary) { this.salary = salary; }

    @Override
    public String toString(){
        return employeeID + " " + lastName + " " + firstName + " " + patronymic + " " + salary;
    }

    public boolean isCorrectBranch(int branch){
        return (branch == 0 || this.branch == branch);
    }

    public String getFullNameString(){
        return this.lastName + ' ' + this.firstName + ' ' + this.patronymic;
    }
}
