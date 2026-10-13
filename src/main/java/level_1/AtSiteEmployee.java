package level_1;

import java.math.BigDecimal;

public class AtSiteEmployee extends Employee {
    private static BigDecimal transportCosts = BigDecimal.valueOf(100.00);

    public AtSiteEmployee(String name, String surname, BigDecimal wagePerHour) {
        super(name, surname, wagePerHour);
    }

    @Override
    public BigDecimal calculateSalary(int hoursWorked) {
        return this.getWagePerHour()
                .multiply(BigDecimal.valueOf(hoursWorked))
                .add(transportCosts);
    }
}
