package inheritance;

public class PetrolCar extends Vehicle {
    @Override
    public void start() {
        System.out.println("PetrolCar -> Petrol engine started");
    }
}
