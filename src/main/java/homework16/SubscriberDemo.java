package homework16;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static homework16.Gender.MAN;

/*
2) Сгенерировать массив 100 абонентов:
		- id возрастает для каждого следующего абонента (необязательно последовательно)
		- со случайными именами и фамилиями (брать из подготовленного массива данных)
		- возраст от 18 до 60 лет
		- телефонный номер заполнить по следующему правилу (задача была на предыдущих занятиях):
			- 10 цифр
			- первый три цифры 999,
			- последняя 0 или 5
			- остальные цифры - любые
 */
public class SubscriberDemo {



    private static String [] firstNamesMen ={"Петя"};
    private static String [] firstNamesWomen ={"Maша"};
    private static String [] lastNamesMen ={"Иванов"};
    private static String [] lastNamesWomen ={"Петрова"};



    private static Random rand =  new Random();
    private static long id = 1L;

    // TODO
    private static String txt = "subscribers.txt";
    private static String xls = "subscribers.xlsx";

//    public static void main(String[] args) {
//
////        OutputStream os = new FileOutputStream("");
////        OutputStreamWriter osw = new OutputStreamWriter(os);
//        try (FileWriter fw = new FileWriter(txt)) {
//            System.out.println("***Generate***");
//            Subscriber[] array =
//                    Stream
//                            .generate(SubscriberDemo::nextSubscriber)
////                .generate(()->SubscriberDemo.nextSubscriber()) // можно так
////                .generate(()->{
////                    return SubscriberDemo.nextSubscriber();
////                }) // можно и так
//                            .limit(100)
//                            .filter(SubscriberDemo.distinctBy(Subscriber::getPhoneNumber))
//                            .peek(System.out::println)
////                            .peek(ConsumerExceptional.wrap(s->fw.write(s.toString())))
//                            .peek(s->{
//                                try {
//                                    fw.write(s.toString()+"\n");
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
//                            })
//                            .toArray(Subscriber[]::new);
//            System.out.println("***Finish***");
//
//            List<Subscriber> list = new ArrayList<>(Arrays.asList(array));
//
//            Arrays.sort(array);
//            System.out.println(Arrays.toString(array));
//
//            list.sort(Comparator.comparingInt(Subscriber::getAge));
////        list.sort((s1, s2)-> Integer.compare(s1.getAge(), s2.getAge()));
//            System.out.println(list);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    private static Subscriber nextSubscriber() {
        long nextId = id;
//        id = id + rand.nextInt(100);
        id++;
        Subscriber newSubscriber  = generateFullNameWithGender();
        newSubscriber.setId(nextId);
        newSubscriber.setAge(generateAge());
        newSubscriber.setPhoneNumber(generatePhoneNumber()); ;
        return newSubscriber;
    }

    private static Subscriber generateFullNameWithGender(){
        Subscriber newSubscriber  = new Subscriber();
        if (rand.nextBoolean()==true){
        int randomNumber = rand.nextInt(firstNamesMen .length);
        newSubscriber.setFirstName(firstNamesMen[randomNumber]);
        randomNumber = rand.nextInt(lastNamesMen .length);
        newSubscriber.setLastName(lastNamesMen[randomNumber]);
        newSubscriber.setGender(Gender.MAN.getGender());
}else {
            int randomNumber1 = rand.nextInt(firstNamesWomen .length);
        newSubscriber.setFirstName(firstNamesWomen[randomNumber1]);
            randomNumber1 = rand.nextInt(lastNamesWomen .length);
        newSubscriber.setLastName(lastNamesWomen[randomNumber1]);
        newSubscriber.setGender(Gender.WOMAN.getGender());
        }
        return newSubscriber;
    }



    public static int generateAge(){
        int lowerLimit = 18;
        int upperLimit = 60;
        return rand.nextInt(upperLimit-lowerLimit)+lowerLimit;
    }

    public static String generatePhoneNumber() {
        int firstThreeNumbers = 999;
        int middleDigits = rand.nextInt(1_000_000);

        // 1 способ
        int lastDigit = rand.nextBoolean() ? 0 : 5;

        // 2 способ
//        if (rand.nextBoolean())
//            last = 0;
//        else
//            last = 5;

        long phoneNumber =
                firstThreeNumbers*1_000_0000L + // двигаем влево на 7 разрядов
                        middleDigits*10 + // умножаем на 10, чтобы сдвинуть влево на один разряд
                        lastDigit; // 0 или 5

        return Long.toString(phoneNumber);
    }

    private static <T> Predicate<T> distinctBy(Function<? super T, ?> keyExtractor) {
        final Set<Object> set = new HashSet<>();

        return t -> set.add(keyExtractor.apply(t));
    }

    public static void main(String[] args) {
        Subscriber subscriber = nextSubscriber();
        System.out.println(subscriber.toString());
    }
}
