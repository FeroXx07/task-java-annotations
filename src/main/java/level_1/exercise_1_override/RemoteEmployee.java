package level_1.exercise_1_override;

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
}
