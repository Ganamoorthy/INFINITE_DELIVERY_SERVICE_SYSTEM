class Charge {
    public static final double BASE_CHARGE = 30.00;
    public static final double MINIMUM_WEIGHT_CHARGE = 50.00;
    public static final double WEIGHT_CHARGE_PER_KG = 1.00;
    public static final double BASE_DISTANCE_CHARGE = 10.00;
    public static final double EXTRA_DISTANCE_CHARGE_PER_KM = 5.00;

    private double[] distances = { 4.4, 7, 5, 4, 7.2 }; // Distances for each town in km

    public double[] getDistances() {
        return distances;
    }

    public double calculateCharge(double netWeight, int selectedTown) {
        double weightCharge = (netWeight < 1) ? MINIMUM_WEIGHT_CHARGE
                : MINIMUM_WEIGHT_CHARGE + ((netWeight - 1) * WEIGHT_CHARGE_PER_KG);
        double distanceToColpetty = distances[selectedTown - 1];
        double extraDistanceCharge = (distanceToColpetty > 5)
                ? ((distanceToColpetty - 5) * EXTRA_DISTANCE_CHARGE_PER_KM)
                : 0;
        return BASE_CHARGE + weightCharge + BASE_DISTANCE_CHARGE + extraDistanceCharge;
    }
}