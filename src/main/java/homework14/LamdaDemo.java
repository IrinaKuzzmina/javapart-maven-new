package src.main.java.homework14;

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

    interface StringSorter {
        List<String> sortStrings(ArrayList<String> list);
    }
    public static void main(String[] args) {

        //1) оставьте лямбда-выражение, которое возвращает значение true, если
        //число принадлежит к диапазону чисел 10-20, включая граничные значения

        boolean isInRange = checkNumber(10, num -> num >= 10 && num <= 20);
        System.out.println("Does 10 is bigger or equal to 10 and less or equal to 20");
        System.out.println(isInRange);

        String initStr = "This is initial string";
        System.out.println(initStr);

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

        stringSplitted.sort(Comparator.comparing(String::length));
        System.out.println("*****Sorted by length vr2****");
        System.out.println(stringSplitted);    }



    private static boolean checkNumber(int number, Predicate<Integer> checker) {
        return checker.test(number);

    }

    static String changeStr(StringTransformer stf, String s) {
        return stf.transformString(s);
    }

    static List<String> splitStrings(StringSplitter stsp, String s) {
        return stsp.splitStrings(s);
    }


    }






