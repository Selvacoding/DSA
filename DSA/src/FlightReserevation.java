import java.util.ArrayList;
import java.util.List;

// Enum for flight class
enum FlightClass {
    ECONOMY,
    BUSINESS,
    FIRST_CLASS
}

// Class to represent a flight
class Flight {
    private final String flightNumber;
    private final String departureAirport;
    private final  String destinationAirport;
    private final  String departureTime;
    private final  String arrivalTime;
    private final  double price;
    private  int availableSeatsEconomy;
    private  int availableSeatsBusiness;
    private  int availableSeatsFirstClass;

    // Constructor
    public Flight(String flightNumber, String departureAirport, String destinationAirport, String departureTime,
                  String arrivalTime, double price, int availableSeatsEconomy, int availableSeatsBusiness,
                  int availableSeatsFirstClass) {
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.availableSeatsEconomy = availableSeatsEconomy;
        this.availableSeatsBusiness = availableSeatsBusiness;
        this.availableSeatsFirstClass = availableSeatsFirstClass;
    }

    // Getters
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public double getPrice() {
        return price;
    }

    // Method to check seat availability
    public boolean hasAvailableSeats(FlightClass flightClass, int numSeats) {
        return switch (flightClass) {
            case ECONOMY -> availableSeatsEconomy >= numSeats;
            case BUSINESS -> availableSeatsBusiness >= numSeats;
            case FIRST_CLASS -> availableSeatsFirstClass >= numSeats;
            default -> false;
        };
    }

    // Method to book seats
    public boolean bookSeats(FlightClass flightClass, int numSeats) {
        switch (flightClass) {
            case ECONOMY -> {
                if (availableSeatsEconomy >= numSeats) {
                    availableSeatsEconomy -= numSeats;
                    return true;
                }
            }
            case BUSINESS -> {
                if (availableSeatsBusiness >= numSeats) {
                    availableSeatsBusiness -= numSeats;
                    return true;
                }
            }
            case FIRST_CLASS -> {
                if (availableSeatsFirstClass >= numSeats) {
                    availableSeatsFirstClass -= numSeats;
                    return true;
                }
            }
        }
        return false;
    }
}

// Class to represent a flight reservation system
class FlightReservationSystem {
    private final List<Flight> flights;

    // Constructor
    public FlightReservationSystem() {
        this.flights = new ArrayList<>();
    }

    // Method to add a flight
    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    // Method to search for flights
    public List<Flight> searchFlights(String departureAirport, String destinationAirport, String departureDate,
                                      FlightClass flightClass, int numPassengers) {
        List<Flight> availableFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDepartureAirport().equalsIgnoreCase(departureAirport)
                    && flight.getDestinationAirport().equalsIgnoreCase(destinationAirport)
                    && flight.hasAvailableSeats(flightClass, numPassengers)) {
                availableFlights.add(flight);
            }
        }
        return availableFlights;
    }

    // Method to book a flight
    public boolean bookFlight(Flight flight, FlightClass flightClass, int numPassengers) {
        if (flight.bookSeats(flightClass, numPassengers)) {
            System.out.println("Booking successful! Your flight number is: " + flight.getFlightNumber());
            return true;
        } else {
            System.out.println("Booking failed. No available seats in the selected class.");
            return false;
        }
    }
}

public class FlightReserevation{
    public static void main(String[] args) {
        // Create a flight reservation system
        FlightReservationSystem reservationSystem = new FlightReservationSystem();

        // Add some sample flights
        Flight flight1 = new Flight("F1234", "JFK", "LAX", "2024-05-05 08:00", "2024-05-05 11:00", 250.0, 50, 20, 10);
        Flight flight2 = new Flight("F5678", "LAX", "JFK", "2024-05-06 09:00", "2024-05-06 12:00", 300.0, 40, 15, 8);
        reservationSystem.addFlight(flight1);
        reservationSystem.addFlight(flight2);

        // Test flight search
        List<Flight> availableFlights = reservationSystem.searchFlights("JFK", "LAX", "2024-05-05", FlightClass.ECONOMY, 2);
        for (Flight flight : availableFlights) {
            System.out.println("Flight: " + flight.getFlightNumber() + ", Price: " + flight.getPrice());
        }

        // Test flight booking
        if (!availableFlights.isEmpty()) {
            reservationSystem.bookFlight(availableFlights.get(0), FlightClass.ECONOMY, 2);
        }
    }
}
