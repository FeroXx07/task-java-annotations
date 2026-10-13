package level_1;

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

    protected BigDecimal getWagePerHour() {return wagePerHour;}

    public BigDecimal calculateSalary(int hoursWorked) {
        return wagePerHour.multiply(BigDecimal.valueOf(hoursWorked));
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", wagePerHour=" + wagePerHour +
                '}';
    }
}
