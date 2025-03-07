class SimpleReportGenerator implements ReportGenerator {
    public String generateReport(Employee employee) {
        return "Report for Employee: " + employee.getName() + " (ID: " + employee.getId() + ")";
    }

    public void generateSummary() {
        System.out.println("Generating a simple summary report.");
    }
}