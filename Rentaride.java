

class Driver {
    private String carModel;
    private double rating;
    private int distance;
    private String predestination;

    public Driver(String carModel, double rating, int distance, String predestination) {
        this.carModel = carModel;
        this.rating = rating;
        this.distance = distance;
        this.predestination = predestination;
    }

    public String getCarModel() {
        return carModel;
    }

    public double getRating() {
        return rating;
    }

    public int getDistance() {
        return distance;
    }

    public String getPredestination() {
        return predestination;
    }
}