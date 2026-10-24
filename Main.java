import composition.Car;
import composition.ElectricEngine;
import composition.HybridEngine;
import composition.PetrolEngine;
import experiment.FragileBaseClassDemo;
import inheritance.ElectricCar;
import inheritance.HybridCar;
import inheritance.PetrolCar;
import inheritance.Vehicle;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   COMPOSITION VS INHERITANCE - CORE JAVA DEMO    ");
        System.out.println("==================================================\n");

        System.out.println("--- 1. Inheritance Design (is-a hierarchy) ---");
        Vehicle petrolCar = new PetrolCar();
        petrolCar.start();

        Vehicle electricCar = new ElectricCar();
        electricCar.start();

        Vehicle hybridCar = new HybridCar();
        hybridCar.start();
        System.out.println("(Observation: Rigid hierarchy; cannot change engine at runtime)\n");

        System.out.println("--- 2. Composition Design (has-a delegation) ---");
        Car car = new Car(new PetrolEngine());
        car.start();

        car.setEngine(new ElectricEngine());
        car.start();

        car.setEngine(new HybridEngine());
        car.start();
        System.out.println("(Observation: Highly flexible; zero edits needed to container class)\n");

        System.out.println("--- 3. Fragile Base Class Problem Experiment ---");
        FragileBaseClassDemo.run();

        System.out.println("\n==================================================");
        System.out.println("       DEMO EXECUTION COMPLETED SUCCESSFULLY      ");
        System.out.println("==================================================");
    }
}
