package homework18.dao.jdbc;

import homework16.Subscriber;
import homework18.dao.SubscriberDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SubscriberDaoImpl extends BaseDAO implements SubscriberDao {
    private final String SQL_INSERT = "INSERT INTO subscriber (id, age, first_name, gender, last_name) VALUES(?, ?, ?, ?, ?)";
    private final String SQL_REMOVE = "DELETE FROM subscriber WHERE id=? AND age=? AND first_name=? AND gender=? AND last_name=?";
    private final String SQL_FIND_BY_ID = "SELECT * FROM subscriber WHERE id=?";
    private final String GET_ALL = "SELECT * FROM subscriber";

    public SubscriberDaoImpl(String url) throws SQLException {
        super(url);
    }

    @Override
    public boolean save(Subscriber subscriber) {
        try {

            PreparedStatement statement = connection.prepareStatement(SQL_INSERT);
            statement.setLong(1, subscriber.getId());
            statement.setInt(2, subscriber.getAge());
            statement.setString(3, subscriber.getFirstName());
            statement.setString(4, subscriber.getGender());
            statement.setString(5, subscriber.getLastName());
            return statement.execute();
        } catch (SQLException e) {
            System.out.println("Warning: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean remove(Subscriber subscriber) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_REMOVE);
            statement.setLong(1, subscriber.getId());
            statement.setInt(2, subscriber.getAge());
            statement.setString(3, subscriber.getFirstName());
            statement.setString(4, subscriber.getGender());
            statement.setString(5, subscriber.getLastName());
            return statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Subscriber> getAll() {
        List<Subscriber> listOfAllSubscribers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(GET_ALL);
            while (result.next()) {
                listOfAllSubscribers.add(new Subscriber(result.getLong(1), result.getString(3),
                        result.getString(5), result.getInt(2), result.getString(4)));
            }
            return listOfAllSubscribers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfAllSubscribers;
    }

    @Override
    public Subscriber findById(long id) {
        Subscriber foundSubscriber =null;
       PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_FIND_BY_ID);
            statement.setLong(1,id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                foundSubscriber = new Subscriber(result.getLong("id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getInt("age"),
                        result.getString("gender"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundSubscriber;
    }
}
