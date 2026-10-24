package inheritance;

public class ElectricCar extends Vehicle {
    @Override
    public void start() {
        System.out.println("ElectricCar -> Electric motor started");
    }
}
