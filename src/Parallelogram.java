import java.util.Objects;

public class Parallelogram {
    // Поля для довжин сторін та кута
    private double sideA;
    private double sideB;
    private double angle; // у градусах

    // Статичне поле для підрахунку кількості створених паралелограмів
    private static int instanceCount = 0;

    // Конструктор за замовчуванням
    public Parallelogram() {
        this(1, 1, 90); // прямокутник
    }

    // Конструктор з параметрами
    public Parallelogram(double sideA, double sideB, double angle) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.angle = angle;
        instanceCount++;
    }

    // Статичний метод для отримання кількості створених об'єктів
    public static int getInstanceCount() {
        return instanceCount;
    }

    // Метод для обчислення периметра паралелограма
    public double calculatePerimeter() {
        return 2 * (sideA + sideB);
    }

    // Метод для обчислення площі паралелограма
    public double calculateArea() {
        return sideA * sideB * Math.sin(Math.toRadians(angle));
    }

    // Метод для порівняння з іншим паралелограмом за площею
    public int compareArea(Parallelogram other) {
        return Double.compare(this.calculateArea(), other.calculateArea());
    }

    // Метод для перевірки подібності до іншого паралелограма
    public boolean isSimilar(Parallelogram other) {
        double ratioA = this.sideA / other.sideA;
        double ratioB = this.sideB / other.sideB;
        return Double.compare(ratioA, ratioB) == 0 && Double.compare(this.angle, other.angle) == 0;
    }

    // Перевантажений метод toString для форматованого виводу
    @Override
    public String toString() {
        return String.format("Паралелограм [Сторона A: %.2f, Сторона B: %.2f, Кут: %.2f градусів]", sideA, sideB, angle);
    }

    // Перевантажений метод equals для порівняння об'єктів
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parallelogram that = (Parallelogram) o;
        return Double.compare(that.sideA, sideA) == 0 &&
                Double.compare(that.sideB, sideB) == 0 &&
                Double.compare(that.angle, angle) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideA, sideB, angle);
    }

    // Основний метод для демонстрації функціоналу
    public static void main(String[] args) {
        // Створення паралелограмів
        Parallelogram p1 = new Parallelogram(5, 10, 45);
        Parallelogram p2 = new Parallelogram(6, 12, 45);
        Parallelogram p3 = new Parallelogram(5, 10, 45);

        // Демонстрація роботи методів
        System.out.println(p1);
        System.out.println("Периметр: " + p1.calculatePerimeter());
        System.out.println("Площа: " + p1.calculateArea());

        // Порівняння площі паралелограмів
        int comparison = p1.compareArea(p2);
        if (comparison > 0) {
            System.out.println("Площа першого паралелограма більша");
        } else if (comparison < 0) {
            System.out.println("Площа другого паралелограма більша");
        } else {
            System.out.println("Площі паралелограмів рівні");
        }

        // Перевірка подібності
        System.out.println("Чи схожі p1 і p2? " + p1.isSimilar(p2));
        System.out.println("Чи схожі p1 і p3? " + p1.isSimilar(p3));

        // Порівняння об'єктів на рівність
        System.out.println("Чи рівні p1 і p3? " + p1.equals(p3));

        // Статичне поле
        System.out.println("Кількість створених паралелограмів: " + Parallelogram.getInstanceCount());
    }
}
