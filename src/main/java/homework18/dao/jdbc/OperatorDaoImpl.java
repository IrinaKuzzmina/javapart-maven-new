package homework18.dao.jdbc;
import homework18.Operator;
import homework18.dao.OperatorDao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OperatorDaoImpl extends BaseDAO implements OperatorDao {
    private final String SQL_INSERT = "INSERT INTO operator (operator_id, name, address) VALUES(?, ?, ?)";
    private final String SQL_REMOVE = "DELETE FROM operator WHERE operator_id=? AND name=? AND address=?";
    public OperatorDaoImpl(String url) throws SQLException {
        super(url);
    }

    @Override
    public boolean save(Operator operator) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT);
            statement.setLong(1, operator.getOperatorId());
            statement.setString(2, operator.getName());
            statement.setString(3, operator.getAddress());
            return statement.execute();
        } catch (SQLException e) {
            System.out.println("Warning: " + e.getMessage());
            return false;
        }
    }
    @Override
    public boolean remove(Operator operator) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_REMOVE);
            statement.setLong(1, operator.getOperatorId());
            statement.setString(2, operator.getName());
            statement.setString(3, operator.getAddress());
            return statement.execute();
        } catch (SQLException e) {
            System.out.println("Warning: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Operator> getAll() {
        return null;
    }

    @Override
    public Operator findById(long id) {
        return null;
    }
}
