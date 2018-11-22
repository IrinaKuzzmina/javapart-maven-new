package homework18;

import homework16.PropertyReader;
import homework16.Subscriber;
import homework16.SubscriberDemo;
import homework18.dao.SubscriberDao;
import homework18.dao.jdbc.SubscriberDaoImpl;

import java.sql.SQLException;
import java.util.List;


public class Demo {
    public static void main(String[] args) {

        //Наполнить таблицу абонентов (200000):
//        for (int i = 0; i < 5; i++) {
//            Subscriber nextSubscriber = SubscriberDemo.nextSubscriber();
//            SubscriberDao subsDao = null;
//            try {
//                subsDao = new SubscriberDaoImpl(PropertyReader.readProperty("jdbc.url"));
//                subsDao.save(nextSubscriber);
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    subsDao.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//       }
//     }

        //Удалить одного subscriber
//        Subscriber subscriber = new Subscriber(1L, "Peter", "Pechking", 25, "099947349202", "m");
//        SubscriberDao subsDao = null;
//        try {
//            subsDao = new SubscriberDaoImpl(PropertyReader.readProperty("jdbc.url"));
//            subsDao.remove(subscriber);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                subsDao.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        //Выбрать всех subscriber в list

//        SubscriberDao subsDao = null;
//        List<Subscriber> allSubscribers = null;
//        try {
//            subsDao = new SubscriberDaoImpl(PropertyReader.readProperty("jdbc.url"));
//           allSubscribers =  subsDao.getAll();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                subsDao.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(allSubscribers);

        //Найти subsriber по id
        SubscriberDao subsDao = null;
        Subscriber foundSubscriber=null;
        try {
            subsDao = new SubscriberDaoImpl(PropertyReader.readProperty("jdbc.url"));
            foundSubscriber = subsDao.findById(5);
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(foundSubscriber.toString());
        }
    }
