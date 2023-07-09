import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Rentaridemaincode {
    private static double ratePerKm = 8.0;

    public static void main(String[] args) {
        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver("Sedan", 4.0, 500, "Gurgaon, Noida, Delhi"));
        drivers.add(new Driver("Hatchback", 4.3, 1000, "Gurgaon"));
        drivers.add(new Driver("5-Seater", 4.8, 200, "Noida"));
        drivers.add(new Driver("Sedan", 4.1, 700, "Noida"));
        drivers.add(new Driver("5-Seater", 4.7, 430, "Delhi"));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer ride distance (in km): ");
        double rideDistance = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("Enter requested car model: ");
        String requestedCarModel = scanner.nextLine();

        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();

        Driver selectedDriver = null;
        int minDistance = Integer.MAX_VALUE;

        for (Driver driver : drivers) {
            if (driver.getRating() >= 4.0 && driver.getCarModel().equals(requestedCarModel)) {
                if (driver.getDistance() < minDistance && driver.getPredestination().contains(destination)) {
                    minDistance = driver.getDistance();
                    selectedDriver = driver;
                }
            }
        }

        if (selectedDriver != null) {
            double totalCharge = rideDistance * ratePerKm;
            System.out.println("Driver " + selectedDriver.getCarModel() + " will get you to the destination.");
            System.out.println("Your charge will be Rs " + totalCharge + ".");
        } else {
            System.out.println("No available driver for the requested car model or destination.");
        }
    }
}
