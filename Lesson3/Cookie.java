public class Cookie extends Sweet {
    private String shape;

    public Cookie(String name, double weight, double price, String shape) {
        super(name, weight, price);
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        return super.toString() + " , shape = " + getShape() + ".";
    }
}
