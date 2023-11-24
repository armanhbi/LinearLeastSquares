import java.util.Arrays;

public class Vector {
    private Double[] values;
    private int index = 0;

    public Vector(Double[] values) {
        this.values = values;
    }

    public Vector(int dimension) {
        this.values = new Double[dimension];
    }

    public Double get(int i) {
        return values[i];
    }

    public static Vector mapToY(Point[] points) {
        return new Vector(Arrays.stream(points)
                .map(Point::getY)
                .toArray(Double[]::new));
    }

    public static Vector mapToX(Point[] points) {
        return new Vector(Arrays.stream(points)
                .map(Point::getX)
                .toArray(Double[]::new));
    }

    public int getDimension() {
        return values.length;
    }

    public Polynom toPolynom() {
        return new Polynom(this.values[1], this.values[0]);
    }

    @Override
    public String toString() {
        return "[" +
                String.join(", ", Arrays.stream(values)
                        .map(String::valueOf)
                        .toArray(String[]::new))
                + "]";
    }
}
