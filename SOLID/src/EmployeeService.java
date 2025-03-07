class EmployeeService {
    private SalaryCalculator salaryCalculator;
    private ReportGenerator reportGenerator;

    public EmployeeService(SalaryCalculator salaryCalculator, ReportGenerator reportGenerator) {
        this.salaryCalculator = salaryCalculator;
        this.reportGenerator = reportGenerator;
    }

    public void processEmployee(Employee employee) {
        employee.displayDetails();
        System.out.println(reportGenerator.generateReport(employee));
        System.out.println("Salary: $" + salaryCalculator.calculateSalary(employee));
    }

    public void sendNotification(Employee employee) {
        System.out.println("Sending notification to: " + employee.getName());
    }
}