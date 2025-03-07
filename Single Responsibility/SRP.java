// Violates SRP: Handles both employee data and persistence
class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void saveToDatabase() {
        System.out.println("Saving employee to database...");
    }
}

// Corrected SRP: Separate classes for responsibility
class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

class EmployeeRepository {
    public void saveToDatabase(Employee employee) {
        System.out.println("Saving employee to database...");
    }
}
