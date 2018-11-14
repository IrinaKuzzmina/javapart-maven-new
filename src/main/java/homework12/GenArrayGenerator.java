package homework12;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class GenArrayGenerator<T> {

    Long[] array = new Long[20];

    public void fillArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = generateNumber();
        }
    }

    public long generateNumber() {
        String firstThreeNumbers = "999";
        long upperLimit = 999999;
        long lowerLimit = 100000;
        long randomeNumber = ThreadLocalRandom.current().nextLong(
                upperLimit + lowerLimit) + lowerLimit;
        int lastPart = Math.random() < 0.5 ? 0 : 5;
        String concatenatedNumber = firstThreeNumbers + Long.toString(randomeNumber)
                + Integer.toString(lastPart);
        long finalNumber = Long.parseLong(concatenatedNumber);
        return finalNumber;
    }

    public void printSortedArray() {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

    }

}
