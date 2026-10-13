package level_1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeTest {
    @ParameterizedTest
    @CsvSource({
            "Luis, Alberto, 19.60, 120, 2352," +
            "Juan, Jose, 19.60, 120, 2452," +
            "Maria, Pilar, 19.60, 120, 2427, 75.00,"
            ,
            "Luis, Alberto, 12.22, 88, 1075.36," +
            "Juan, Jose, 12.22, 88, 1175.36," +
            "Maria, Pilar, 10.60, 100, 1135, 75.00,"

    })
    void calculateSalary(
            String name1, String surName1, double wage1, int hoursWorked1, double expectedSalary1,
            String name2, String surName2, double wage2, int hoursWorked2, double expectedSalary2,
            String name3, String surName3, double wage3, int hoursWorked3, double expectedSalary3,
            double internetCosts
    ) {
        Employee employee1 = new Employee(name1, surName1, BigDecimal.valueOf(wage1));
        Employee employee2 = new AtSiteEmployee(name2, surName2, BigDecimal.valueOf(wage2));
        Employee employee3 = new RemoteEmployee(name3, surName3, BigDecimal.valueOf(wage3), BigDecimal.valueOf(internetCosts));

        assertThat(employee1.calculateSalary(hoursWorked1)).isEqualTo(BigDecimal.valueOf(expectedSalary1));
        assertThat(employee2.calculateSalary(hoursWorked2)).isEqualTo(BigDecimal.valueOf(expectedSalary2));
        assertThat(employee3.calculateSalary(hoursWorked3)).isEqualTo(BigDecimal.valueOf(expectedSalary3));
    }
}