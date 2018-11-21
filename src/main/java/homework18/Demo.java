package homework18;

import homework16.Subscriber;
import homework16.SubscriberDemo;
import homework18.dao.jdbc.SubscriberDaoImpl;

public class Demo {
    public static void main(String[] args) {
        for (int i=0; i<5; i++) {
            Subscriber nextSubscriber = SubscriberDemo.nextSubscriber();
            SubscriberDaoImpl subscriberDao = new SubscriberDaoImpl();
            subscriberDao.save(nextSubscriber);
        }
    }


}
