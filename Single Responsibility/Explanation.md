`Explanation` :It states that a class should have only one reason to change, this means that a class should have only one responsibility.
----
### Single Responsibility Principle (SRP) Violation and Fix

#### SRP Violation
The original code violates SRP because the `Employee` class has **two responsibilities**: 
1. Managing employee data (`name`, `salary`).
2. Handling database persistence (`saveToDatabase()`).
```java
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
```
`Issue:` If `database` logic changes, the `Employee class` must be modified, violating SRP.
Breaks SRP: A class should have only one reason to change.
---
## The Fix: 
```java
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
```
Now, `Employee` only handles employee data.
`EmployeeRepository` is responsible for persistence.
SRP is maintained: Each class has a single responsibility.

