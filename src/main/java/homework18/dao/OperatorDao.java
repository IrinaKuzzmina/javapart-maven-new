package homework18.dao;

import homework18.Operator;

import java.util.List;

public interface OperatorDao {

    boolean save(Operator operator);

    boolean remove(Operator operator);

    List<Operator> getAll();

    Operator findById(long id);
}
