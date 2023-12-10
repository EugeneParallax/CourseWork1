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
                this.employeeList[i] = Employee.createEmployee(lastName, firstName, patronymic, branch, salary);
                return;
            }

        }
        throw new RuntimeException("Невозможно добавить нового сотрудника - книга заполнена");
    }

    public void removeEmployeeByID(int id) {
        int length = this.employeeList.length - 1;

        for (int i = 0; i < length; i++) {
            Employee employee = this.employeeList[i];

            if (employee == null) {
                break;
            } else if (employee.getEmployeeID() == id) {
                for (int s = i; s <= length; s++) {
                    employeeList[s] = null;
                    if (s < length) {
                        employeeList[s] = employeeList[s + 1];
                    }
                }
                return;
            }
        }
        System.out.println("Сотруднник с указанным ID не найден");
    }

    public void removeEmployeeByName(String lastName, String firstName, String patronymic) {
        String keyword = lastName + ' ' + firstName + ' ' + patronymic;
        int length = this.employeeList.length - 1;

        for (int i = 0; i < length; i++) {
            Employee employee = this.employeeList[i];

            if (employee == null) {
                break;
            } else if (employee.getFullNameString().equals(keyword)) {
                for (int s = i; s <= length; s++) {
                    employeeList[s] = null;
                    if (s < length) {
                        employeeList[s] = employeeList[s + 1];
                    }
                }
                return;
            }
        }
        System.out.println("Сотруднник с указанным ФИО не найден");
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

    public int findSalaryTotal(int branch) {
        int salaryTotal = 0;
        for (int i = 0; i < this.employeeList.length - 1; i++) {
            Employee employee = this.employeeList[i];
            if (employee == null) {
                break;
            } else if (employee.isCorrectBranch(branch)) {
                salaryTotal += employee.getSalary();
            }
        }
        return salaryTotal;
    }

    public int findSalaryAverage(int branch) {
        int salaryTotal = 0;
        int members = 0;
        for (int i = 0; i < this.employeeList.length - 1; i++) {
            Employee employee = this.employeeList[i];
            if (employee == null) {
                break;
            } else if (employee.isCorrectBranch(branch)) {
                salaryTotal += employee.getSalary();
                members += 1;
            }
        }
        return salaryTotal / members;
    }

    public Employee findSalaryMin(int branch) {
        int salaryMin = this.employeeList[0].getSalary();
        int salaryMinEmployee = 0;

        for (int i = 1; i < this.employeeList.length - 1; i++) {
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
        return this.employeeList[salaryMinEmployee];
    }

    public Employee findSalaryMax(int branch) {
        int salaryMax = this.employeeList[0].getSalary();
        int salaryMaxEmployee = 0;

        for (int i = 1; i < this.employeeList.length - 1; i++) {
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
        return this.employeeList[salaryMaxEmployee];
    }

    public void findEmployeesBySalaryBelow(int sample){
        for (int i = 1; i < this.employeeList.length - 1; i++) {
            Employee employee = this.employeeList[i];

            if (employee == null) {
                break;
            } else if (employee.getSalary() < sample) {
                System.out.println(employee);
            }
        }
    }

    public void findEmployeesBySalaryAbove(int sample){
        for (int i = 1; i < this.employeeList.length - 1; i++) {
            Employee employee = this.employeeList[i];

            if (employee == null) {
                break;
            } else if (employee.getSalary() >= sample) {
                System.out.println(employee);
            }
        }
    }

    public void setEmployeeSalary(String lastName, String firstName, String patronymic, int salary) {
        String keyword = lastName + ' ' + firstName + ' ' + patronymic;
        int length = this.employeeList.length - 1;

        for (int i = 0; i < length; i++) {
            Employee employee = this.employeeList[i];

            if (employee == null) {
                break;
            } else if (employee.getFullNameString().equals(keyword)) {
                employee.setSalary(salary);
                return;
            }
        }
    }

    public void setEmployeeBranch(String lastName, String firstName, String patronymic, int branch) {
        if (branch < 1 || branch > branchNumber) {
            throw new RuntimeException("Новый номер отдела задан неверно");
        }
            String keyword = lastName + ' ' + firstName + ' ' + patronymic;
            int length = this.employeeList.length - 1;

            for (int i = 0; i < length; i++) {
                Employee employee = this.employeeList[i];

                if (employee == null) {
                    break;
                } else if (employee.getFullNameString().equals(keyword)) {
                    employee.setBranch(branch);
                    return;
                }
            }
    }

    public void modifySalariesBy(int branch, int percent) {
        for (int i = 1; i < this.employeeList.length - 1; i++) {
            Employee employee = this.employeeList[i];

            if (employee == null) {
                break;
            } else if (employee.isCorrectBranch(branch)) {
                int newSalary = employee.getSalary() * percent / 100;
                employee.setSalary(newSalary);
            }
        }
    }

    public void printEmployeesByBranch(){
        for (int i = 1; i <= branchNumber; i++) {
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
