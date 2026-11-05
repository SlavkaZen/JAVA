public class Report {

    public static void generateReport(Employee[] employees) {
        for (Employee emp : employees) {
            System.out.printf("%-15s |%10.2f%n", emp.fullname, emp.salary);
        }
    }
}
