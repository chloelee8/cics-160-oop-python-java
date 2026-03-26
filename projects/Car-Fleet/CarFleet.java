import java.util.ArrayList;
import java.util.List;

public class CarFleet {

    private Queue<Car> gasolineCars;
    private Queue<Car> hybridCars;
    private Queue<Car> electricCars;

    public CarFleet() {
        gasolineCars = new Queue<>();
        hybridCars = new Queue<>();
        electricCars = new Queue<>();
    }

    public boolean addCar(Car car) {
        int type = car.getPowerSource();
        switch (type) {
            case 1:
                gasolineCars.enqueue(car);
                return true;
            case 2:
                hybridCars.enqueue(car);
                return true;
            case 3:
                electricCars.enqueue(car);
                return true;
            default:
                return false;
        }
    }

    public List<Car> processRequests(Queue<Integer> requests) {
        List<Car> result = new ArrayList<>();
        while (!requests.isEmpty()) {
            int req = requests.dequeue();
            Car car;
            switch (req) {
                case 1:
                    car = gasolineCars.isEmpty() ? new Car(0, 1, 0f) : gasolineCars.dequeue();
                    break;
                case 2:
                    car = hybridCars.isEmpty() ? new Car(0, 2, 0f) : hybridCars.dequeue();
                    break;
                case 3:
                    car = electricCars.isEmpty() ? new Car(0, 3, 0f) : electricCars.dequeue();
                    break;
                default:
                    car = new Car(0, 0, 0f);
            }
            result.add(car);
        }
        return result;
    }
}