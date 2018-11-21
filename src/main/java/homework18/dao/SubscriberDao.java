package homework18.dao;

import homework16.Subscriber;

import java.util.List;

public interface SubscriberDao {
    boolean save(Subscriber subscriber);
    boolean remove(Subscriber subscriber);
    List<Subscriber> getAll();
    Subscriber findById(long id);
}
