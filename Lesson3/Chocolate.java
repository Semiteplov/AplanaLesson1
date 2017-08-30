public class Chocolate extends Sweet {
    private double percentageOfCocoa;

    public Chocolate(String name, double weight, double price, double percentageOfCocoa) {
        super(name, weight, price);
        this.percentageOfCocoa = percentageOfCocoa;
    }

    public double getPercentageOfCocoa() {
        return percentageOfCocoa;
    }

    public void setPercentageOfCocoa(double percentageOfCocoa) {
        this.percentageOfCocoa = percentageOfCocoa;
    }

    @Override
    public String toString() {
        return super.toString() + ", percentage of cocoa = " + getPercentageOfCocoa() + ".";
    }
}
