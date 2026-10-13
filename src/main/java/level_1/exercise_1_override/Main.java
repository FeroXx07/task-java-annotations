package level_1.exercise_1_override;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Main {
    private BigDecimal normalWagePerHour = BigDecimal.valueOf(18.35);
    private int hoursWorked = 120;

    void main(String[] args) {
        Employee employeeA = new Employee("Juan", "Carlos", normalWagePerHour);
        Employee employeeB = new AtSiteEmployee("Miguel", "Lozano", normalWagePerHour);
        Employee employeeC = new RemoteEmployee("Lucia", "Rems", normalWagePerHour, BigDecimal.valueOf(50));

        List<Employee> employees = Arrays.asList(employeeA, employeeB, employeeC);
        employees.forEach(employee -> {
            IO.println();
            IO.print(employee);
            IO.print("worked " + hoursWorked + " hours and their salary is: " + employee.calculateSalary(120) + " €");
        });
    }
}
