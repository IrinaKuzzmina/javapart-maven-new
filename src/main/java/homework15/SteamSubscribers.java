package homework15;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SteamSubscribers {
    public static void main(String[] args) {
        Collection<Subscriber> collection = Arrays.asList(Subscriber.generateSubscribers(5));

        System.out.println("****Task 3*****");

//        3) Из массива:
//        - исключить дубликаты
//        - отсортировать по id,
//        - сохранить в список (List)
//
        List uniqueSortedSubscribers =
                collection.stream()
                        .distinct()
                      //.sorted((s1,s2) ->s1.getId().compareTo(s2.getId()));
                        .sorted((Comparator.comparing(Subscriber::getId)))
                        .collect(Collectors.toList());
        System.out.println(uniqueSortedSubscribers);

        //    4) Из списка абонентов:
//  - отсортировать по телефонному номеру
//	- отфильтровать по возрасту от 20 до 30
//  - перевести первый символ имени и фамилии в верхний регистр
//	- перевести все символы кроме первого в нижний регистр
//	- вывести на консоль

        System.out.println("****Task 4*****");

        collection.stream()
                .sorted(Comparator.comparing(Subscriber::getPhoneNumber))
                .filter(s -> s.getAge() >= 20 && s.getAge() <= 30)
                .peek(s -> s.getFirstName().substring(0, 1).toUpperCase())
                .peek(s -> s.getLastName().substring(0, 1).toUpperCase())
                .peek(s -> s.getFirstName().substring(1).toLowerCase())
                .peek(s -> s.getLastName().substring(1).toLowerCase())
                .forEach(System.out::println);

//        5) Из списка абонентов:
//  - исключить дубликаты по телефонном номеру* (не обязательно)
//  - отфильтровать по последней цифре номера = 5
//  - посчитать средний возраст

        System.out.println("****Task 5*****");

        Double averageAge = collection.stream()
                .filter(s->s.getPhoneNumber().substring(s.getPhoneNumber().length()-1).equals("5"))
                .mapToInt(Subscriber::getAge)
                .average()
                .getAsDouble();
        System.out.println(averageAge);

    }
}
