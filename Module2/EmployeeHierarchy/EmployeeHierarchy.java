// Create:
// Parent Employee: name, baseSalary, calculatePay() returns baseSalary
// Child Manager extends Employee:
// attribute: bonus (double)
// overrides calculatePay() → baseSalary + bonus
// uses super.calculatePay() inside
// Child Contractor extends Employee:
// attributes: hoursWorked (int), hourlyRate (double)
// overrides calculatePay() → hoursWorked × hourlyRate
// In main: create all 3, print each person's pay


class Employee {
    String name = "unknown";
    double baseSalary = 0.0;

    Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    double calculatePay() {
        return baseSalary;
    }
    
    void displayInfo() {
        System.out.println("Name: "+ name);
        System.out.println("Salary: "+calculatePay());
        System.out.println();

    }
    
}

class Manager extends Employee {
    double bonus;

    Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
        // this.baseSalary+=bonus;
    }

    @Override
    double calculatePay() {
        return super.calculatePay() + bonus;
    }
}

class Contractor extends Employee {
    
    int hoursWorked;
    double hourlyRate;

    Contractor (String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(name,baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    
    double calculatePay() {
        return hoursWorked*hourlyRate;
    }
}


public class EmployeeHierarchy {
    public static void main(String[] args) {

        Employee e = new Employee("Resh",10000.0);
        Manager m = new Manager("Vish",50000.0,25000.0);
        Contractor c = new Contractor("Raja",5000.0,30,750.0);

        e.displayInfo();
        m.displayInfo();
        c.displayInfo();
    }
}