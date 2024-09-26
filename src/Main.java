public class Main {
    public static void main(String[] args) {
        System.out.println("--- Working with Money ---");
        Money m1 = new Money(3, 2, 1, 1, 1, 1, 1, 0, 0); // 3 купюри по 1 грн, 2 по 2 грн і т.д.
        Money m2 = new Money(1, 0, 0, 0, 0, 1, 0, 1, 0); // 1 купюра по 1 грн, 1 по 50 грн, 1 по 200 грн
        System.out.println("Money m1: " + m1);
        System.out.println("Money m2: " + m2);
        System.out.println("m1 + m2: " + m1.add(m2));
        System.out.println("m1 - m2: " + m1.subtract(m2));
        System.out.println("m1 / 2: " + m1.divide(2));
        System.out.println("m1 equals m2? " + m1.equals(m2));

        System.out.println("\n--- Working with Parallelograms ---");
        Parallelogram p1 = new Parallelogram(5, 10, 45);
        Parallelogram p2 = new Parallelogram(6, 12, 45);
        Parallelogram p3 = new Parallelogram(5, 10, 45);
        System.out.println("Parallelogram p1: " + p1);
        System.out.println("Parallelogram p2: " + p2);
        System.out.println("Perimeter of p1: " + p1.calculatePerimeter());
        System.out.println("Area of p1: " + p1.calculateArea());
        System.out.println("p1 equals p3? " + p1.equals(p3));
        System.out.println("p1 is similar to p2? " + p1.isSimilar(p2));
    }
}
