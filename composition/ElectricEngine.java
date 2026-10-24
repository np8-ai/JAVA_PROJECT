package composition;

public class ElectricEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Electric motor started");
    }
}
