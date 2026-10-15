package level_2_and_3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedClass;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

//@ParameterizedClass
//@CsvSource("BMW, Black, 4, 150")
class SimpleJsonSerializerTest {

    @ParameterizedTest
    @CsvSource({"BMW, Black, 4, 150, '{\"horsePower\":\"150\",\"color\":\"Black\",\"numTyres\":\"4\",\"model\":\"BMW\"}'",
            "Ferrari, '\"Red\"', 4, 296, '{\"horsePower\":\"296\",\"color\":\"\"Red\"\",\"numTyres\":\"4\",\"model\":\"Ferrari\"}'"})
    void serialize(ArgumentsAccessor arguments) throws IllegalAccessException {
        Vehicle vehicle = new Vehicle(
                arguments.getString(0),
                arguments.getString(1),
                arguments.getInteger(2),
                arguments.getInteger(3));

        String actualResult = SimpleJsonSerializer.serialize(vehicle);
        String expectedResult = arguments.getString(4);
        assertThat(actualResult).isNotNull();
        assertThat(actualResult).isNotBlank();
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}