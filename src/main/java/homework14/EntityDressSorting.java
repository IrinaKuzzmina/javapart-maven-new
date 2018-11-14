package homework14;

import automationpractice.model.EntityDress;
import lesson10.CompareDresses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EntityDressSorting {
    public static void main(String[] args) {
        List<EntityDress> dresses = new ArrayList<>(Arrays.asList(CompareDresses.getExpectedDresses()));
        System.out.println("*****List before sorting*****");
        System.out.println(dresses);

        //6) Отсортировать коллекцию по полю model
        dresses.sort((dress1, dress2) -> dress1.getModel().compareTo(dress2.getModel()));
        System.out.println("*****Sorted by model******");
        System.out.println(dresses);


        dresses.sort(Comparator.comparing(dress1 -> dress1.getModel()));
        System.out.println("*****Sorted by model var2******");
        System.out.println(dresses);


        //6) Отсортировать коллекцию по полю price по возрастанию
        dresses.sort((dress1, dress2) -> {
            if (dress1.getPrice() > dress2.getPrice()) {
                return 1;
            } else if (dress1.getPrice() == dress2.getPrice()) {
                return 0;
            } else return -1;
        });
        System.out.println("*****Sorted by price asc******");
        System.out.println(dresses);

       dresses.sort(Comparator.comparingDouble(d ->d.getPrice()));
        System.out.println("*****Sorted by price asc var2******");
        System.out.println(dresses);

        //6) Отсортировать коллекцию по полю price по убыванию
        dresses.sort((dress1, dress2) -> {
            if (dress2.getPrice() > dress1.getPrice()) {
                return 1;
            } else if (dress2.getPrice() == dress1.getPrice()) {
                return 0;
            } else return -1;
        });
        System.out.println("*****Sorted by price desc******");
        System.out.println(dresses);

        dresses.sort(Comparator.comparing(EntityDress::getPrice, Comparator.reverseOrder()));
        System.out.println("*****Sorted by price desc var2******");
        System.out.println(dresses);
    }
}