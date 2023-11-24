public class Matrix {
    private Double[][] values;

    public Matrix(Double[][] values) {
        this.values = values;
    }

    public static Matrix createA(Vector b) {
        Double[][] values = new Double[b.getDimension()][2];

        for (int i = 0; i < b.getDimension(); i++) {
            values[i][0] = 1.0;
            values[i][1] = b.get(i);
        }

        return new Matrix(values);
    }

    public Matrix transpose() {
        Double[][] values = new Double[2][this.values.length];
        for (int i = 0; i < this.values.length; i++) {
            values[0][i] = 1.0;
            values[1][i] = this.values[i][1];
        }
        return new Matrix(values);
    }

    public Matrix multiply(Matrix B) {
        Double[][] returner = new Double[2][2];

        double A00 = this.values[0][0];
        double A10 = this.values[1][0];
        double A01 = this.values[0][1];
        double A11 = this.values[1][1];
        double A02 = this.values[0][2];
        double A12 = this.values[1][2];

        double B00 = B.values[0][0];
        double B01 = B.values[0][1];
        double B10 = B.values[1][0];
        double B11 = B.values[1][1];
        double B20 = B.values[2][0];
        double B21 = B.values[2][1];

        returner[0][0] = A00 * B00 + A01 * B10 + A02 * B20;
        returner[0][1] = A00 * B01 + A01 * B11 + A02 * B21;
        returner[1][0] = returner[0][1];
        returner[1][1] = A10 * B01 + A11 * B11 + A12 * B21;
        return new Matrix(returner);
    }


    public Vector multiply(Vector V) {
        double A00 = this.values[0][0];
        double A10 = this.values[1][0];
        double A01 = this.values[0][1];
        double A11 = this.values[1][1];
        double A02 = this.values[0][2];
        double A12 = this.values[1][2];

        double V0 = V.get(0);
        double V1 = V.get(1);
        double V2 = V.get(2);

        double v0 = A00 * V0 + A01 * V1 + A02 * V2;
        double v1 = A10 * V0 + A11 * V1 + A12 * V2;

        return new Vector(new Double[]{v0, v1});
    }

    @Override
    public String toString() {
        String returner = "";
        for (Double[] rows : values) {
            returner += new Vector(rows) + "\n";
        }
        return returner;
    }

    public Vector calculate(Vector right) {
        // Calculate m
        double v0 = right.get(0);
        double v1 = right.get(1);
        double m00 = values[0][0];
        double m01 = values[0][1];
        double m10 = values[1][0];
        double m11 = values[1][1];

        double numerator = (v1 - m10 * v0 / m00) * m00;
        double denominator = -(m10 * m01) + (m11 * m00);

        double m = numerator / denominator;

        //Calculate t
        double t = (v0 - m01 * m) / m00;

        return new Vector(new Double[]{m, t});
    }
}
