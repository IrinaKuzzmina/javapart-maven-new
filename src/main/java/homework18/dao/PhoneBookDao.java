package homework18.dao;

import homework18.PhoneBookRecord;

import java.util.List;

public interface PhoneBookDao {
boolean save(PhoneBookRecord record);
boolean remove(PhoneBookRecord record);
List<PhoneBookRecord> getAll();
 PhoneBookRecord findByKeys(String phoneNumber, Long operatorId);
}
