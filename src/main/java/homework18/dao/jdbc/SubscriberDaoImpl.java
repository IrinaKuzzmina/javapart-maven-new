package homework18.dao.jdbc;

import homework16.Subscriber;
import homework16.SubscriberDemo;
import homework18.dao.SubscriberDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SubscriberDaoImpl implements SubscriberDao {
    @Override
    public boolean save(Subscriber subscriber) {
        try {
            Connection connection = DBConnector.connectToDB();
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO abonent VALUES(?,?,?,?,?)");
            statement.setLong(1, subscriber.getId());
            statement.setInt(2, subscriber.getAge());
            statement.setString(3, subscriber.getFirstName());
            statement.setString(4, subscriber.getGender());
            statement.setString(5, subscriber.getLastName());
            statement.execute();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean remove(Subscriber subscriber) {
        return false;
    }

    @Override
    public List<Subscriber> getAll() {
        return null;
    }

    @Override
    public Subscriber findById(long id) {
        return null;
    }
}
