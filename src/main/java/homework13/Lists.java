package homework13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lists {


    public static void main(String[] args) {
        String[] array = {"Peter", "Helen", "Andry", "Abdel", "kate", "Veronica", "Leonid", "Alex", "max" };

        List<String> listOfNames = new ArrayList<String>(Arrays.asList(array));
        listOfNames.add("Philip");
        listOfNames.add("Joseph");
        listOfNames.add("Leon");
        System.out.println(listOfNames);
        listOfNames.remove("Veronica");
        listOfNames.remove("Leonid");
        System.out.println(listOfNames);
        listOfNames.add(1, "Elizabet");
        Collections.sort(listOfNames);
        System.out.println(listOfNames);
        Collections.sort(listOfNames, new ComparatorInverseOrder());
        System.out.println(listOfNames);

        List<String> newList = new ArrayList<>();
        for (String string : listOfNames) {
            string = string.substring(0, 1).toUpperCase() + string.substring(1);
            newList.add(string);
        }
        System.out.println(newList);

        for (String string : newList) {
            if (string.substring(0, 1).equals("A")) {
                System.out.println(string);
            }
        }
        if (newList.contains("Andry")) {
            System.out.println("List contains the name Andry");
        } else {
            System.out.println("List doesn't contain name Andry");
        }
        List<String> tempList = new ArrayList<>();
        tempList.add("Helen");
        tempList.add("Kate");
        newList.retainAll(tempList);

        System.out.println(newList);

    }
}







