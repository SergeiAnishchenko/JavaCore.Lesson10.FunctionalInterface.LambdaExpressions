import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Main {
    public static void main(String[] args) {

        task1();
        System.out.println(" ");
        task2();
        System.out.println(" ");
        task3();
        System.out.println(" ");
        task4();
        System.out.println(" ");
        task5TernaryOperator();

    }

    private static void task1() {
        System.out.println("Задача 1. Реалиация Predicate");

        Predicate<Integer> isPositiveNumber1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x > 0;
            }
        };
        System.out.println(isPositiveNumber1.test(4));
        System.out.println(isPositiveNumber1.test(-1));


        Predicate<Integer> isPositiveNumber2 = x -> x > 0;
        System.out.println(isPositiveNumber2.test(4));
        System.out.println(isPositiveNumber2.test(-1));
    }

    private static void task2() {
        System.out.println("Задача 2. Реализация Consumer");

        Consumer<String> greetings1 = new Consumer<String>() {
            @Override
            public void accept(String greetings1) {
                System.out.println("Привет, " + greetings1 + "!");
            }
        };
        greetings1.accept("Ольга");

        Consumer<String> greetings2 = x -> System.out.println("Привет, " + x + "!");
        greetings2.accept("Елена");
    }


    private static void task3() {
        System.out.println("Задача 3. Реализация Function");

        Function<Double, Long> valueConverter1 = new Function<Double, Long>() {
            @Override
            public Long apply(Double doubleValue) {
                return doubleValue.longValue();
            }
        };
        System.out.println(valueConverter1.apply(5.7));


        Function<Double, Long> valueConverter2 = x -> x.longValue();
        System.out.println(valueConverter2.apply(7.6));

    }

    private static void task4() {
        System.out.println("Задача 4. Реализация Supplier");

        Supplier<Integer> randomNumber1 = new Supplier<Integer>() {
            int max = 100;
            @Override
            public Integer get() {
                return (int) (Math.random() * ++max);
            }
        };

        System.out.println(randomNumber1.get());

        Supplier<Integer> randomNumber2 = () -> {
            int max = 100;
            int value = (int)(Math.random() * ++max);
            return value;
        };

        System.out.println(randomNumber2.get());

    }

    private static void task5TernaryOperator() {
        System.out.println("Задача 5. Комбинирование функций.");

        double number = -25.67;
        Predicate<Double> isPositive = x -> x > 0;
        Function<Double, Long> newValueConverter1 = x -> x.longValue();
        Function<Double, Long> newValueConverter2 = x -> Math.abs(x.longValue());

        System.out.println((isPositive.test(number))?
                newValueConverter1.apply(number) : newValueConverter2.apply(number));

    }
}