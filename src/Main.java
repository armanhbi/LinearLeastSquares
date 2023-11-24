public class Main {
    public static void main(String[] args) {
        Point a = new Point(2.0, 2.0);
        Point b = new Point(0.0, 1.0);
        Point c = new Point(1.0, 3.0);

        Point[] points = {a, b, c};

        Polynom polynom = LLS.createPolynom(points);
        System.out.println(polynom);
    }
}
