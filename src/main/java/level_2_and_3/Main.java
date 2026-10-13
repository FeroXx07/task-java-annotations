package level_2_and_3;


public class Main {
    Vehicle vehicle = new Vehicle("BMW", "Black", 4, 150);
    void main(String[] args) throws IllegalAccessException {
        String resultJson = SimpleJsonSerializer.serialize(vehicle);
        IO.println(resultJson);
    }
}
