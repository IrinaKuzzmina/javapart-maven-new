package homework14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class LamdaDemo {
    interface StringTransformer {
        String transformString(String str);
    }

    interface StringSplitter {
        List<String> splitStrings(String str);
    }

    interface NumberOperation {
        int changeInteger(int n);
    }

    public static void main(String[] args) {

        //1) оставьте лямбда-выражение, которое возвращает значение true, если
        //число принадлежит к диапазону чисел 10-20, включая граничные значения

        boolean isInRange = checkNumber(10, num -> num >= 10 && num <= 20);
        System.out.println("Does 10 is bigger or equal to 10 and less or equal to 20");
        System.out.println(isInRange);

        String initStr = "This is initial string";
        System.out.println(initStr);


        //2)	Создайте блочное лямбда-выражение для вычисления факториала целого числа.
        //	Продемонстрируйте его использование.
        int forFactorial = 2;
        int factorial = changeInteger((n) -> {
            int result = 1;
            for (int i = 1; i<=n; i++) {
                result *= i;
            }
            return result;
        },forFactorial);


        //3)  Создайте лямбда-выражение, которое переводит строку в верхний режим.
        //Перевести строку в верхний регистр с помощью лямбда-выражения.
        String stringToUpper = changeStr(str -> str.toUpperCase(), initStr);
        System.out.println("*****String to upper case*****");
        System.out.println(stringToUpper);

        //Перевести строку в верхний регистр с помощью ссылки на метод.
        String stringToUpper2 = changeStr(String::toUpperCase, initStr);
        System.out.println("*****String to upper case var 2*****");
        System.out.println(stringToUpper2);

        //4) Заданную строк разбить на слова
        List<String> stringSplitted = splitStrings((str) -> {
            List<String> stringSplittedTemp = new ArrayList<>(Arrays.asList(str.split(" ")));
            return stringSplittedTemp;
        }, initStr);
        System.out.println("*****Splitted String*****");
        System.out.println(stringSplitted);


        //4) - отсортировать слова по алфавиту не учитывая регистр первой буквы
        stringSplitted.sort(String::compareToIgnoreCase);
        System.out.println("*****Sorted by alphabet*****");
        System.out.println(stringSplitted);

        //4)  - отсортировать слова по длине
        stringSplitted.sort((word1, word2) -> {
            if (word1.length() > word2.length()) {
                return 1;
            } else if (word1.length() == word2.length()) {
                return 0;
            } else return -1;

        });
        System.out.println("*****Sorted by length*****");
        System.out.println(stringSplitted);

        //4)  - отсортировать слова по длине с помощью ссылки на метод
        stringSplitted.sort(Comparator.comparing(String::length));
        System.out.println("*****Sorted by length vr2****");
        System.out.println(stringSplitted);

        //4) - отсортировать слова по последней букве
        stringSplitted.sort(Comparator.comparing(str -> str.substring(str.length() - 1)));
        System.out.println("*****Sorted by last letter****");
        System.out.println(stringSplitted);

        stringSplitted.sort((str1, str2) -> str1.substring(str1.length() - 1).compareTo(str2.substring(str2.length() - 1)));
        System.out.println("*****Sorted by last letter var2****");
        System.out.println(stringSplitted);

        //5) Создайте лямбда-выражение, которое удаляет все пробелы из заданной строки и возвращает результат.
        //	Продемонстрируйте работу лямбда-выражения.
        String withoutSpaces = changeStr(str -> str.replaceAll("\\s", ""), initStr);
        System.out.println("*****Without spaces****");
        System.out.println(withoutSpaces);
    }

    private static boolean checkNumber(int number, Predicate<Integer> checker) {
        return checker.test(number);

    }

    static String changeStr(StringTransformer stf, String s) {
        return stf.transformString(s);
    }

    static List<String> splitStrings(StringSplitter stsp, String s) {
        return stsp.splitStrings(s);
    }

    static int changeInteger(NumberOperation nO, int n) {
        return nO.changeInteger(n);
    }
}






