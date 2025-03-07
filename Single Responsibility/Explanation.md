# Single Responsibility Principle
`Explanation`: It States tht a class should have only one reason to change, This means that a class Should have only one responsibility.
--------
## In The Violation area:

The `Employee class` has two responsibilities:
Holding employee data `(name, salary)`.
Handling persistence `(saveToDatabase() method)`.
This violates SRP because if we change how employees are stored (e.g., switching from a database to a file system), we need to `modify` the Employee class.
----
## In the Fix Area:

__Now, the `Employee class` is only responsible for storing employee data.
The `EmployeeRepository class` is responsible for persistence, handling database operations separately.__
