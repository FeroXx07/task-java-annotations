package level_1;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Main {
    private BigDecimal normalWagePerHour = BigDecimal.valueOf(18.35);
    private int hoursWorked = 120;
    Employee employeeA = new Employee("Juan", "Carlos", normalWagePerHour);
    Employee employeeB = new AtSiteEmployee("Miguel", "Lozano", normalWagePerHour);
    Employee employeeC = new RemoteEmployee("Lucia", "Rems", normalWagePerHour, BigDecimal.valueOf(50));

    void main(String[] args) {
        showEmployeeSample();
        showCovidExtraCosts();
    }

    private void showEmployeeSample() {
        List<Employee> employees = Arrays.asList(employeeA, employeeB, employeeC);
        employees.forEach(employee -> {
            IO.print(employee);
            IO.print("worked " + hoursWorked + " hours and their salary is: " + employee.calculateSalary(120) + " €");
            IO.println();
        });
    }

    private void showCovidExtraCosts() {
        if (employeeC instanceof RemoteEmployee) {
            @SuppressWarnings("deprecation") BigDecimal extraCosts = ((RemoteEmployee) employeeC).getExtraCovidInternetCosts();
            IO.println("Covid extra costs are: " + extraCosts + " €");
        }
    }
}
