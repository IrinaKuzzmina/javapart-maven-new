package homework18.dao.jdbc;

import homework18.PhoneBookRecord;
import homework18.dao.PhoneBookDao;

import java.util.List;

public class PhoneBookDaoImpl implements PhoneBookDao{
    @Override
    public boolean save(PhoneBookRecord record) {
        return false;
    }

    @Override
    public boolean remove(PhoneBookRecord record) {
        return false;
    }

    @Override
    public List<PhoneBookRecord> getAll() {
        return null;
    }

    @Override
    public PhoneBookRecord findByKeys(String phoneNumber, Long operatorId) {
        return null;
    }
}
