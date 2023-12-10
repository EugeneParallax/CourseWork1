import java.io.OptionalDataException;

public class Main {
    public static void main(String[] args) {

        // ===== EmployeeBook methods:
        // Calling constructor to create a new Book:
        EmployeeBook backendTeam1 = new EmployeeBook(10,5);

        // Method to add new Employees to the Book (full array for debug):
        backendTeam1.addEmployee("Алексеев", "Алексей", "Алексеевич", 1, 118000);
        backendTeam1.addEmployee("Борисов", "Борис", "Борисович", 2, 126000);
        backendTeam1.addEmployee("Викторова", "Виктория", "Викторовна", 3, 155000);
        backendTeam1.addEmployee("Григорьев", "Григорий", "Григорьевич", 4, 118000);
        backendTeam1.addEmployee("Денисова", "Дарья", "Денисовна", 5, 145000);
        backendTeam1.addEmployee("Егоров", "Егор", "Егорьевич", 1, 152000);
        backendTeam1.addEmployee("Игорева", "Ирина", "Игоревна", 2, 128000);
        backendTeam1.addEmployee("Львов", "Лев", "Львович", 3, 180000);
        backendTeam1.addEmployee("Михайлов", "Михаил", "Михайлович", 4, 154000);
        backendTeam1.addEmployee("Николаева", "Наталья", "Николаевна", 5, 165000);

        //      IF a method takes branch as an argument, input of 0 does not filter by branch.
        //      Branch input arguments are not checked for validity.

        //      Prints Employee objects data as list in console (void):
        //backendTeam1.printEmployeesFull(0);

        //      Removes an Employee from the Book by ID (void):
        //backendTeam1.removeEmployeeByID(3);

        //      Removes an Employee from the Book by full name (void):
        //backendTeam1.removeEmployeeByName("Львов", "Лев", "Львович");

        //      Calculates the total salary expenditure (returns Int value):
        //backendTeam1.findSalaryTotal(0);

        //      Calculates the average salary (returns Int value):
        //backendTeam1.findSalaryAverage(0);

        //      Finds an Employee with the lowest salary (returns Employee object):
        //backendTeam1.findSalaryMin(0);

        //      Finds an Employee with the highest salary (returns Employee object):
        //backendTeam1.findSalaryMax(0);

        //      Finds and prints all Employees with salary below sample to console (void):
        //backendTeam1.findEmployeesBySalaryBelow(150000);

        //      Finds and prints all Employees with salary equal or above sample to console (void):
        //backendTeam1.findEmployeesBySalaryAbove(120000);

        //      Finds an Employee by full name and sets its salary to a new value (void):
        //backendTeam1.setEmployeeSalary("Алексеев", "Алексей", "Алексеевич", 123456);

        //      Finds an Employee by full name and sets its branch to a new value (void):
        //backendTeam1.setEmployeeBranch("Алексеев", "Алексей", "Алексеевич", 4);

        //      Modifies salaries for Employees by a percent multiplier (void):
        //backendTeam1.modifySalariesBy(0,111);

        //      Prints a list of all branches and associated Employees to console (void):
        //backendTeam1.printEmployeesByBranch();
    }
}