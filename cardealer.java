// import java.util.Scanner;

class Car {
    private String model;
    private double showroomPrice;

    public Car(String model, double showroomPrice) {
        this.model = model;
        this.showroomPrice = showroomPrice;
    }

    public String getModel() {
        return model;
    }

    public double getShowroomPrice() {
        return showroomPrice;
    }
}

class Billing {
    private static final double RTO_CHARGES = 113990.0;
    private static final double INSURANCE_CHARGES = 47300.0;
    private static final double TCS_CHARGES = 11000.0;
    private static final double ADDITIONAL_ACCESSORIES_CHARGES = 15000.0;
    private static final double MAX_DISCOUNT = 30000.0;

    private Car car;
    private boolean needInsurance;
    private boolean needAdditionalAccessories;
    private double dealerDiscount;

    public Billing(Car car, boolean needInsurance, boolean needAdditionalAccessories, double dealerDiscount) {
        this.car = car;
        this.needInsurance = needInsurance;
        this.needAdditionalAccessories = needAdditionalAccessories;
        this.dealerDiscount = dealerDiscount;
    }

    public double calculateTotalCost() {
        double totalCost = car.getShowroomPrice() + RTO_CHARGES + TCS_CHARGES;
        if (needInsurance) {
            totalCost += INSURANCE_CHARGES;
        }
        if (needAdditionalAccessories) {
            totalCost += ADDITIONAL_ACCESSORIES_CHARGES;
        }

        if (dealerDiscount > 0 && (needInsurance || needAdditionalAccessories)) {
            dealerDiscount = Math.min(dealerDiscount, MAX_DISCOUNT);
            totalCost -= dealerDiscount;
        } else if (dealerDiscount > 0) {
            System.out.println("Error: Any one of the additional features has to be added and 0 discount has to be applied.");
            return 0.0;
        }

        return totalCost;
    }
}

// public class CarDealerBilling {
//     public static void main(String[] args) {
//         Car[] cars = {
//                 new Car("Polo Trendline", 870000.0),
//                 new Car("Polo Highline", 1009000.0),
//                 new Car("Virtus Trendline", 1105000.0),
//                 new Car("Virtus Highline", 1308000.0),
//                 new Car("Taigun Trendline", 1489000.0),
//                 new Car("Taigun Highline", 1542000.0),
//                 new Car("Taigun Topline", 1771000.0)
//         };

//         Scanner scanner = new Scanner(System.in);
//         System.out.print("Select car model: ");
//         String selectedModel = scanner.nextLine();

//         Car selectedCar = null;
//         for (Car car : cars) {
//             if (car.getModel().equalsIgnoreCase(selectedModel)) {
//                 selectedCar = car;
//                 break;
//             }
//         }

//         if (selectedCar == null) {
//             System.out.println("Invalid car model selected.");
//             return;
//         }

//         System.out.print("Do you need Insurance (yes/no): ");
//         String insuranceOption = scanner.nextLine();
//         boolean needInsurance = insuranceOption.equalsIgnoreCase("yes");

//         System.out.print("Do you need Additional Accessories (yes/no): ");
//         String accessoriesOption = scanner.nextLine();
//         boolean needAdditionalAccessories = accessoriesOption.equalsIgnoreCase("yes");

//         double dealerDiscount = 0.0;
//         if (needInsurance || needAdditionalAccessories) {
//             System.out.print("Dealer discount (in percentage or rupees, max 30000): ");
//             dealerDiscount = scanner.nextDouble();
//         }

//         Billing billing = new Billing(selectedCar, needInsurance, needAdditionalAccessories, dealerDiscount);
//         double totalCost = billing.calculateTotalCost();

//         if (totalCost > 0) {
//             System.out.println("Total cost: Rs " + totalCost);
//         }
//     }
// }
