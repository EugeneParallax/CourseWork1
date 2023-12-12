public class EmployeeBook {

    private Employee[] employeeList;
    private final int branchNumber;

    // Constructor
    public EmployeeBook(int size, int branches) {
        employeeList = new Employee[size];
        branchNumber = branches;
    }

    public void addEmployee(String lastName, String firstName, String patronymic, int branch, int salary) {
        if (branch < 1 || branch > branchNumber) {
            throw new RuntimeException("Номер отдела нового сотрудника задан неверно");
        }
        for (int i = 0; i < this.employeeList.length; i++) {
            Employee checkSlot = this.employeeList[i];
            if (checkSlot == null) {
                this.employeeList[i] = new Employee(lastName, firstName, patronymic, branch, salary);
                return;
            }

        }
        throw new RuntimeException("Невозможно добавить нового сотрудника - книга заполнена");
    }

    public void removeEmployeeByID(int id) {
        int length = this.employeeList.length;

        for (int i = 0; i < length; i++) {
            Employee employee = this.employeeList[i];

            if (employee == null) {
                break;
            } else if (employee.getEmployeeID() == id) {
                for (int s = i; s < length; s++) {
                    employeeList[s] = null;
                    if (s < length - 1) {
                        employeeList[s] = employeeList[s + 1];
                    }
                }
                return;
            }
        }
        System.out.println("Сотрудник с указанным ID не найден");
    }

    public void removeEmployeeByName(String lastName, String firstName, String patronymic) {
        int length = this.employeeList.length;

        for (int i = 0; i < length; i++) {
            Employee employee = this.employeeList[i];

            if (employee == null) {
                break;
            } else if (employee.getLastName().equals(lastName)) {
                if (employee.getFirstName().equals(firstName)) {
                    if (employee.getPatronymic().equals(patronymic)) {
                        for (int s = i; s < length; s++) {
                            employeeList[s] = null;
                            if (s < length - 1) {
                                employeeList[s] = employeeList[s + 1];
                            }
                        }
                    }
                }
                return;
            }
        }
        System.out.println("Сотрудник с указанным ФИО не найден");
    }

    public void printEmployeesFull() {
        printEmployeesFull(0);
    }
    public void printEmployeesFull(int branch) {
        for (Employee employee : this.employeeList) {
            if (employee == null) {
                break;
            } else if (employee.isCorrectBranch(branch)) {
                System.out.println(employee);
            }
        }
    }

    public int findSalaryTotal() {
        return findSalaryTotal(0);
    }

    public int findSalaryTotal(int branch) {
        int salaryTotal = 0;
        for (Employee employee : this.employeeList) {
            if (employee == null) {
                break;
            } else if (employee.isCorrectBranch(branch)) {
                salaryTotal += employee.getSalary();
            }
        }
        return salaryTotal;
    }

    public double findSalaryAverage() {
        return findSalaryAverage(0);
    }

    public double findSalaryAverage(int branch) {
        int salaryTotal = 0;
        int members = 0;
        for (Employee employee : this.employeeList) {
            if (employee == null) {
                break;
            } else if (employee.isCorrectBranch(branch)) {
                salaryTotal += employee.getSalary();
                members += 1;
            }
        }
        return (double) salaryTotal / members;
    }

    public Employee findSalaryMin() {
        return findSalaryMin(0);
    }

    public Employee findSalaryMin(int branch) {
        int salaryMin = Integer.MAX_VALUE;
        int salaryMinEmployee = -1;

        for (int i = 0; i < this.employeeList.length; i++) {
            Employee employee = this.employeeList[i];

            if (employee == null) {
                break;
            } else if (employee.isCorrectBranch(branch)) {
                if (employee.getSalary() < salaryMin) {
                    salaryMin = employee.getSalary();
                    salaryMinEmployee = i;
                }
            }
        }
        if(salaryMinEmployee == -1){
            throw new RuntimeException("Данная книга сотрудников пуста, либо нет записей сотрудников в указанном отделе");
        }
        return this.employeeList[salaryMinEmployee];
    }

    public Employee findSalaryMax() {
        return findSalaryMax(0);
    }
    public Employee findSalaryMax(int branch) {
        int salaryMax = Integer.MIN_VALUE;
        int salaryMaxEmployee = -1;

        for (int i = 0; i < this.employeeList.length; i++) {
            Employee employee = this.employeeList[i];

            if (employee == null) {
                break;
            } else if (employee.isCorrectBranch(branch)) {
                if (employee.getSalary() > salaryMax) {
                    salaryMax = employee.getSalary();
                    salaryMaxEmployee = i;
                }
            }
        }
        if(salaryMaxEmployee == -1){
            throw new RuntimeException("Данная книга сотрудников пуста, либо нет записей сотрудников в указанном отделе");
        }
        return this.employeeList[salaryMaxEmployee];
    }

    public void findEmployeesBySalaryBelow(int sample){
        for (int i = 0; i < this.employeeList.length; i++) {
            Employee employee = this.employeeList[i];

            if (employee == null) {
                break;
            } else if (employee.getSalary() < sample) {
                System.out.println(employee);
            }
        }
    }

    public void findEmployeesBySalaryAbove(int sample){
        for (int i = 0; i < this.employeeList.length; i++) {
            Employee employee = this.employeeList[i];

            if (employee == null) {
                break;
            } else if (employee.getSalary() >= sample) {
                System.out.println(employee);
            }
        }
    }

    public void setEmployeeSalary(String lastName, String firstName, String patronymic, int salary) {

        for (Employee employee : this.employeeList) {
            if (employee == null) {
                break;
            } else if (employee.getLastName().equals(lastName)) {
                if (employee.getFirstName().equals(firstName)) {
                    if (employee.getPatronymic().equals(patronymic)) {
                        employee.setSalary(salary);
                        return;
                    }
                }
            }
            System.out.println("Сотрудник с указанным ФИО не найден");
        }
    }

    public void setEmployeeBranch(String lastName, String firstName, String patronymic, int branch) {
        if (branch < 1 || branch > branchNumber) {
            throw new RuntimeException("Новый номер отдела задан неверно");
        }

        for (Employee employee : this.employeeList) {
            if (employee == null) {
                break;
            } else if (employee.getLastName().equals(lastName)) {
                if (employee.getFirstName().equals(firstName)) {
                    if (employee.getPatronymic().equals(patronymic)) {
                        employee.setBranch(branch);
                        return;
                    }
                }
            }
            System.out.println("Сотрудник с указанным ФИО не найден");
        }
    }

    public void modifySalariesBy(int percent) {
        modifySalariesBy(0, percent);
    }

    public void modifySalariesBy(int branch, int percent) {
        for (Employee employee : this.employeeList) {
            if (employee == null) {
                break;
            } else if (employee.isCorrectBranch(branch)) {
                int newSalary = employee.getSalary() * (100 + percent) / 100;
                employee.setSalary(newSalary);
            }
        }
    }

    public void printEmployeesByBranch(){
        for (int i = 0; i <= branchNumber; i++) {
            System.out.println("===== Отдел номер " + i + " =====");

            for (int e = 0; e < this.employeeList.length; e++) {
                Employee employee = this.employeeList[e];

                if (employee == null) {
                    break;
                } else if (employee.isCorrectBranch(i)) {
                    System.out.println(employee.getFullNameString());
                }
            }
        }
    }
}
