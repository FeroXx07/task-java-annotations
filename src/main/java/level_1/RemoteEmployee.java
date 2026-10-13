package level_1;

import java.math.BigDecimal;

public class RemoteEmployee extends Employee {
    private final BigDecimal internetCosts;

    public RemoteEmployee(String name, String surname, BigDecimal wagePerHour, BigDecimal internetCosts) {
        super(name, surname, wagePerHour);
        this.internetCosts = internetCosts;
    }

    @Override
    public BigDecimal calculateSalary(int hoursWorked) {
        return getWagePerHour()
                .multiply(BigDecimal.valueOf(hoursWorked))
                .add(internetCosts);
    }

    @Deprecated
    public BigDecimal getExtraCovidInternetCosts() {
        return internetCosts.multiply(BigDecimal.valueOf(1.5));
    }
}
