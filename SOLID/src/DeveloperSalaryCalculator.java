class DeveloperSalaryCalculator implements SalaryCalculator {
    public double calculateSalary(Employee employee) {
        return 8000.0;
    }

    public void calculateOvertimePay() {
        System.out.println("Calculating overtime pay for a developer.");
    }
}
