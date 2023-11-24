public class Polynom {
    private Double[] values;

    public Polynom(double a0, double a1) {
        this.values = new Double[2];
        values[0] = a0;
        values[1] = a1;
    }

    @Override
    public String toString() {
        String operator;
        if (values[0] < 0) {
            operator = "-";
            values[0] = -values[0];
        } else {
            operator = "+";
        }
        return "y = " + values[1] + "m " + operator + " " + values[0];
    }
}
