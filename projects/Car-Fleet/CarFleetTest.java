import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class CarFleetTest {
    @Test
    
    public void testAddCar() {
        CarFleet fleet = new CarFleet();
        Car gas = new Car(1, 1, 30f);
        Car hybrid = new Car(2, 2, 40f);
        Car electric = new Car(3, 3, 50f);
        Car invalid = new Car(4, 4, 60f);

        assertTrue(fleet.addCar(gas));
        assertTrue(fleet.addCar(hybrid));
        assertTrue(fleet.addCar(electric));
        assertFalse(fleet.addCar(invalid));
    }

    @Test
    public void testProcessRequests() {
        CarFleet fleet = new CarFleet();
        Car gas = new Car(1, 1, 30f);
        Car hybrid = new Car(2, 2, 40f);
        Car electric = new Car(3, 3, 50f);
        fleet.addCar(gas);
        fleet.addCar(hybrid);
        fleet.addCar(electric);

        Queue<Integer> requests = new Queue<>();
        requests.enqueue(1);
        requests.enqueue(2);
        requests.enqueue(3);
        requests.enqueue(2); 
        requests.enqueue(1); 

        List<Car> result = fleet.processRequests(requests);

        assertEquals(5, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals(2, result.get(1).getId());
        assertEquals(3, result.get(2).getId());
        assertEquals(0, result.get(3).getId()); 
        assertEquals(0, result.get(4).getId()); 
    }
}
