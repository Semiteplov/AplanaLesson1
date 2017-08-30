public class Gift {
    private double totalWeight;
    private double totalPrice;
    private Sweet[] sweets;

    public Gift(Sweet... sweet) {
        for(Sweet sw : sweet) {
            this.sweets = sweet;
        }
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void calculateTotalWeight() {
        for (int i = 0; i < sweets.length; i++) {
            this.totalWeight += sweets[i].getWeight();
        }
    }

    public void calculateTotalPrice() {
        for (int i = 0; i < sweets.length; i++) {
            this.totalPrice += sweets[i].getPrice();
        }
    }

    public void printSweetsInfo() {
        System.out.println("Info about the gift: ");
        for (int i = 0; i < sweets.length; i++) {
            System.out.println(sweets[i].toString());
        }
        System.out.println("_____________________________________________________________________________");
    }
}
