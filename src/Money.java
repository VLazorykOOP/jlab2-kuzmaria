import java.util.Objects;

public class Money {
    private final int ones, twos, fives, tens, twenties, fifties, hundreds, twoHundreds, fiveHundreds;

    // Конструктор з 9 параметрами
    public Money(int ones, int twos, int fives, int tens, int twenties, int fifties, int hundreds, int twoHundreds, int fiveHundreds) {
        this.ones = ones;
        this.twos = twos;
        this.fives = fives;
        this.tens = tens;
        this.twenties = twenties;
        this.fifties = fifties;
        this.hundreds = hundreds;
        this.twoHundreds = twoHundreds;
        this.fiveHundreds = fiveHundreds;
    }

    // Метод додавання двох об'єктів Money
    public Money add(Money other) {
        return new Money(
            this.ones + other.ones,
            this.twos + other.twos,
            this.fives + other.fives,
            this.tens + other.tens,
            this.twenties + other.twenties,
            this.fifties + other.fifties,
            this.hundreds + other.hundreds,
            this.twoHundreds + other.twoHundreds,
            this.fiveHundreds + other.fiveHundreds
        );
    }

    // Метод віднімання двох об'єктів Money
    public Money subtract(Money other) {
        return new Money(
            this.ones - other.ones,
            this.twos - other.twos,
            this.fives - other.fives,
            this.tens - other.tens,
            this.twenties - other.twenties,
            this.fifties - other.fifties,
            this.hundreds - other.hundreds,
            this.twoHundreds - other.twoHundreds,
            this.fiveHundreds - other.fiveHundreds
        );
    }

    // Метод ділення суми на дробове число
    public Money divide(double divisor) {
        return new Money(
            (int)(this.ones / divisor),
            (int)(this.twos / divisor),
            (int)(this.fives / divisor),
            (int)(this.tens / divisor),
            (int)(this.twenties / divisor),
            (int)(this.fifties / divisor),
            (int)(this.hundreds / divisor),
            (int)(this.twoHundreds / divisor),
            (int)(this.fiveHundreds / divisor)
        );
    }

    // Перевантажений метод toString для форматованого виведення суми
    @Override
    public String toString() {
        int totalUah = ones + 2 * twos + 5 * fives + 10 * tens + 20 * twenties + 50 * fifties + 100 * hundreds + 200 * twoHundreds + 500 * fiveHundreds;
        return totalUah + " грн";
    }

    // Перевантажений метод equals для порівняння двох об'єктів Money
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return ones == money.ones &&
               twos == money.twos &&
               fives == money.fives &&
               tens == money.tens &&
               twenties == money.twenties &&
               fifties == money.fifties &&
               hundreds == money.hundreds &&
               twoHundreds == money.twoHundreds &&
               fiveHundreds == money.fiveHundreds;
    }

    // Перевантажений метод hashCode для коректної роботи з хеш-колекціями
    @Override
    public int hashCode() {
        return Objects.hash(ones, twos, fives, tens, twenties, fifties, hundreds, twoHundreds, fiveHundreds);
    }
}
