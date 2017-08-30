public class Marshmallow extends Sweet {
    private String colour;

    public Marshmallow(String name, double weight, double price, String colour) {
        super(name, weight, price);
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return super.toString() + " , colour = " + getColour() + ".";
    }
}
