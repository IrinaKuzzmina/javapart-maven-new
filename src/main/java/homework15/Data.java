package homework15;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Data {
   String [] firstNames = {"Maша", "Петя", "Вася", "Миша", "Даша", "Катя", "Саша", "Паша"};
   String [] lastNames = {"Корженко", "Михайленко", "Кузьменко", "Клопотенко", "Половик"};

    public String generateFirstName(){
        Random rand =  new Random();
        int randomNumber = rand.nextInt(firstNames.length-1);
        String randomeName = firstNames [randomNumber];
        return randomeName;
    }

    public String generateLastName(){
        Random rand =  new Random();
        int randomNumber = rand.nextInt(lastNames.length-1);
        String randomeName = lastNames [randomNumber];
        return randomeName;
    }

    public int generateAge(){
        Random rand =  new Random();
        int lowerLimit = 18;
        int upperLimit = 60;
        int randomNumber = rand.nextInt(upperLimit-lowerLimit)+lowerLimit;
        return randomNumber;
    }

    public String generatePhoneNumber() {
        String firstThreeNumbers = "999";
        long upperLimit = 999999;
        long lowerLimit = 100000;
        long randomeNumber = ThreadLocalRandom.current().nextLong(
                upperLimit + lowerLimit) + lowerLimit;
        int lastPart = Math.random() < 0.5 ? 0 : 5;
        String concatenatedNumber = firstThreeNumbers + Long.toString(randomeNumber)
                + Integer.toString(lastPart);

        return concatenatedNumber;
    }


    public static void main(String[] args) {


    }
}
