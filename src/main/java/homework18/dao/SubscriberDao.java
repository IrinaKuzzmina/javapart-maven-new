package homework18.dao;

import homework16.Subscriber;

import java.sql.SQLException;
import java.util.List;

public interface SubscriberDao extends AutoCloseable {
    boolean save(Subscriber subscriber);
    boolean remove(Subscriber subscriber);
    List<Subscriber> getAll();
    Subscriber findById(long id) throws SQLException;
}
