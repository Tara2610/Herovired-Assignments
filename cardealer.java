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

