public class LLS {
    public static Polynom createPolynom(Point[] points) {
        // A^T A x = A^T b -> calculate for x
        Vector b = Vector.mapToY(points);// Create vector b
        Vector bX = Vector.mapToX(points);// Create vector b

        Matrix A = Matrix.createA(bX); // Create Matrix A
        Matrix AT = A.transpose(); // Create Matrix A transposed

        Matrix left = AT.multiply(A); // Calculate left
        Vector right = AT.multiply(b); // Calculate right

        Vector calculate = left.calculate(right); // Calculate left=right to get {m, t}

        return calculate.toPolynom(); // Turn to Polynom
    }
}
