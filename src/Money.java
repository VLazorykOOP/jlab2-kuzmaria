import java.util.Objects; // Імпорт класу Objects для роботи з методами equals і hashCode

// Оголошення класу Money
public class Money {
    
    // Приватні поля для зберігання кількості купюр різного номіналу
    private final int ones;          // Кількість купюр по 1 грн
    private final int twos;          // Кількість купюр по 2 грн
    private final int fives;         // Кількість купюр по 5 грн
    private final int tens;          // Кількість купюр по 10 грн
    private final int twenties;      // Кількість купюр по 20 грн
    private final int fifties;       // Кількість купюр по 50 грн
    private final int hundreds;      // Кількість купюр по 100 грн
    private final int twoHundreds;   // Кількість купюр по 200 грн
    private final int fiveHundreds;  // Кількість купюр по 500 грн

    // Конструктор класу Money
    // Приймає 9 параметрів для 9 видів купюр
    public Money(int ones, int twos, int fives, int tens, 
                 int twenties, int fifties, int hundreds, 
                 int twoHundreds, int fiveHundreds) {
        // Ініціалізація полів класу значеннями, які передані в конструктор
        this.ones = ones;         //  this використовується для розрізнення полів класу від параметрів конструктора.        
        this.twos = twos;                 
        this.fives = fives;               
        this.tens = tens;                
        this.twenties = twenties;        
        this.fifties = fifties;          
        this.hundreds = hundreds;         
        this.twoHundreds = twoHundreds;   
        this.fiveHundreds = fiveHundreds; 
    }

    // Метод для додавання двох об'єктів Money
    public Money add(Money other) {
        // Створення нового об'єкта Money, де значення купюр будуть сумою
        return new Money(
            this.ones + other.ones,           //Метод, що додає гроші з іншого об'єкта Money до поточного.
            this.twos + other.twos,          
            this.fives + other.fives,         // Додаємо кількість купюр по 5 грн
            this.tens + other.tens,           // Додаємо кількість купюр по 10 грн
            this.twenties + other.twenties,   // Додаємо кількість купюр по 20 грн
            this.fifties + other.fifties,     // Додаємо кількість купюр по 50 грн
            this.hundreds + other.hundreds,   // Додаємо кількість купюр по 100 грн
            this.twoHundreds + other.twoHundreds, // Додаємо кількість купюр по 200 грн
            this.fiveHundreds + other.fiveHundreds // Додаємо кількість купюр по 500 грн
        );
    }

    // Метод для віднімання одного об'єкта Money від іншого
    public Money subtract(Money other) {
        // Створення нового об'єкта Money, де значення купюр будуть різницею
        return new Money(
            this.ones - other.ones,           //Метод, що від subtract один об'єкт Money від іншого.
            this.twos - other.twos,           
            this.fives - other.fives,         // Віднімемо кількість купюр по 5 грн
            this.tens - other.tens,           // Віднімемо кількість купюр по 10 грн
            this.twenties - other.twenties,   // Віднімемо кількість купюр по 20 грн
            this.fifties - other.fifties,     // Віднімемо кількість купюр по 50 грн
            this.hundreds - other.hundreds,   // Віднімемо кількість купюр по 100 грн
            this.twoHundreds - other.twoHundreds, // Віднімемо кількість купюр по 200 грн
            this.fiveHundreds - other.fiveHundreds // Віднімемо кількість купюр по 500 грн
        );
    }

    // Метод для ділення кількості грошей на дробове число
    public Money divide(double divisor) {
        // Створення нового об'єкта Money, ділячи кількість купюр на divisor
        return new Money(
            (int)(this.ones / divisor),       //Метод, що ділить кількість грошей у кожному номіналі на дробове число divisor.    
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

    // Перевантажений метод toString для виведення суми в гривнях
@Override
    public String toString() {
        // Обчислення загальної суми в гривнях
        int totalUah = ones + 
                       2 * twos +             // Загальна сума визначається як сума кількостей купюр, помножених на їх номінали.
                       5 * fives + 
                       10 * tens + 
                       20 * twenties + 
                       50 * fifties + 
                       100 * hundreds + 
                       200 * twoHundreds + 
                       500 * fiveHundreds; // Загальна сума

        // Повертаємо рядок у форматі "X грн"
        return totalUah + " грн"; 
    }

    // Перевантажений метод equals для порівняння двох об'єктів Money
    @Override
    public boolean equals(Object o) {
        // Перевіряємо, чи два об'єкти є однаковими
        if (this == o) return true; // Якщо це один і той самий об'єкт
        // Перевіряємо, чи o є об'єктом класу Money
        if (o == null || getClass() != o.getClass()) return false;
        
        // Приводимо o до типу Money
        Money money = (Money) o;

        // Порівнюємо всі поля об'єкта Money
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
        // Обчислюємо хеш-код на основі значень полів. Метод hashCode() в Java генерує цілочисельне значення.
        // Це значення є унікальним для конкретного об'єкта, і використовується для ідентифікації цього об'єкта в різних структурах даних.
        return Objects.hash(ones, twos, fives, tens,   //Це необхідно для коректної роботи об'єктів у хеш-колекціях, оскільки вони використовують хеш-коди для організації даних.
                            twenties, fifties, hundreds, 
                            twoHundreds, fiveHundreds);
    }
}
