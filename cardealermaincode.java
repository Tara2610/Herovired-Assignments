import java.util.Scanner;

public class cardealermaincode {
    public static void main(String[] args) {
        Car[] cars = {
                new Car("Polo Trendline", 870000.0),
                new Car("Polo Highline", 1009000.0),
                new Car("Virtus Trendline", 1105000.0),
                new Car("Virtus Highline", 1308000.0),
                new Car("Taigun Trendline", 1489000.0),
                new Car("Taigun Highline", 1542000.0),
                new Car("Taigun Topline", 1771000.0)
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Select car model: ");
        String selectedModel = scanner.nextLine();

        Car selectedCar = null;
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(selectedModel)) {
                selectedCar = car;
                break;
            }
        }

        if (selectedCar == null) {
            System.out.println("Invalid car model selected.");
            return;
        }

        System.out.print("Do you need Insurance (yes/no): ");
        String insuranceOption = scanner.nextLine();
        boolean needInsurance = insuranceOption.equalsIgnoreCase("yes");

        System.out.print("Do you need Additional Accessories (yes/no): ");
        String accessoriesOption = scanner.nextLine();
        boolean needAdditionalAccessories = accessoriesOption.equalsIgnoreCase("yes");

        double dealerDiscount = 0.0;
        if (needInsurance || needAdditionalAccessories) {
            System.out.print("Dealer discount (in percentage or rupees, max 30000): ");
            dealerDiscount = scanner.nextDouble();
        }

        Billing billing = new Billing(selectedCar, needInsurance, needAdditionalAccessories, dealerDiscount);
        double totalCost = billing.calculateTotalCost();

        if (totalCost > 0) {
            System.out.println("Total cost: Rs " + totalCost);
        }
    }
}
