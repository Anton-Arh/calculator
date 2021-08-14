import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static void main(String[] args) throws IllegalArgumentException {
        System.out.println("Введите пример для решения");
        Scanner scanner = new Scanner(System.in);
        String example = scanner.nextLine();

        boolean b1 = testArab(example);
        boolean b2 = testRome(example);
        if (b1) {
            calculationArab(example);
        } else if (b2) {
            calculationRome(example);
        }
        else
            System.out.println("Введите корректные значения аргументов");

    }

    public static boolean testArab(String s) {
        Pattern p = Pattern.compile("[0-9]{1,2}\\s[-+*/]\\s[0-9]{1,2}");
        Matcher m = p.matcher(s);
        return m.matches();
    }

    public static boolean testRome(String s) {
        Pattern p = Pattern.compile("[IXV]{1,4}\\s[-+*/]\\s[IVX]{1,4}");
        Matcher m = p.matcher(s);
        return m.matches();
    }

    public static void calculationArab(String s) {

        String[] arr = s.split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[2]);

        if ((a > 10 || a < 1) || (b > 10 || b < 1)) {
            System.out.println("Введите корректные значения аргументов");
        } else if (s.contains("+")) {
            System.out.println(a + b);
        } else if (s.contains("-")) {
            System.out.println(a - b);
        } else if (s.contains("*")) {
            System.out.println(a * b);
        } else if (s.contains("/")) {
            System.out.println(a / b);
        }
    }

    public static void calculationRome(String s) {
        String[] arr = s.split(" "); //преобразуем строку в массив
        String s1 = arr[0]; // объявляем и инициализируем стринговые переменные, данные получаем из элементов массива
        String s2 = arr[2];
        int a = Rome.valueOf(s1).toArab(); //объявляем и инициализируме числовые значения этих переменных, полученные из словаря Enum
        int b = Rome.valueOf(s2).toArab();
        int c = 0;
        if (s.contains("+")) { c = a + b; } //выполняем арифметические действия с числами
        else if (s.contains("-")) { c = a - b; }
        else if (s.contains("*")) { c = a * b; }
        else if (s.contains("/")) { c = a / b; }
        if (c <= 0) {
            System.out.println("Результат меньше или равен нулю, введите корректные значения аргументов");
        }

        // перевод результата расчета в римские числа
        // отсюда https://coding.tools/ru/numbers-to-roman-numerals
        int[] roman_value_list = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman_char_list = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < roman_value_list.length; i += 1) {
            while (c >= roman_value_list[i]) {
                c -= roman_value_list[i];
                res.append(roman_char_list[i]);
            }
        }
        System.out.println(res);

    }
}