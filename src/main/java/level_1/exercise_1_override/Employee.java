package level_1.exercise_1_override;

import java.math.BigDecimal;

public class Employee {
    private final String name;
    private final String surname;
    private BigDecimal wagePerHour;

    public Employee(String name, String surname, BigDecimal wagePerHour) {
        this.name = name;
        this.surname = surname;
        this.wagePerHour = wagePerHour;
    }

    public BigDecimal calculateSalary(int hoursWorked) {
        return wagePerHour.multiply(BigDecimal.valueOf(hoursWorked));
    }

    protected BigDecimal getWagePerHour() {return wagePerHour;}
}
