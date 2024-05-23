import java.util.HashMap;
import java.util.Map;

enum VehicleType {
    CAR,
    TRUCK,
    MOTORCYCLE,
    BICYCLE
}

class TollPayment {
    private final Map<VehicleType, Double> tollRates;

    public TollPayment() {
        tollRates = new HashMap<>();
        // Initialize toll rates for different vehicle types
        tollRates.put(VehicleType.CAR, 2.0);
        tollRates.put(VehicleType.TRUCK, 5.0);
        tollRates.put(VehicleType.MOTORCYCLE, 1.0);
    }

    public double calculateToll(VehicleType vehicleType) {
        // Check if the vehicle type exists in the tollRates map
        if (tollRates.containsKey(vehicleType)) {
            return tollRates.get(vehicleType);
        } else {
            System.out.println("Invalid vehicle type. Cannot calculate toll.");
            return 0.0;
        }
    }
}

public class TollPaymentSystem {
    public static void main(String[] args) {
        TollPayment tollPayment = new TollPayment();

        // Test the toll calculation for different vehicles
        double carToll = tollPayment.calculateToll(VehicleType.CAR);
        System.out.println("Toll for a car: $" + carToll);

        double truckToll = tollPayment.calculateToll(VehicleType.TRUCK);
        System.out.println("Toll for a truck: $" + truckToll);

        double motorcycleToll = tollPayment.calculateToll(VehicleType.MOTORCYCLE);
        System.out.println("Toll for a motorcycle: $" + motorcycleToll);

        // Test with an invalid vehicle type
        double invalidToll = tollPayment.calculateToll(VehicleType.BICYCLE);
        System.out.println("Toll for a bicycle: $" + invalidToll);
    }
}
