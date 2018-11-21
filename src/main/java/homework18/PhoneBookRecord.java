package homework18;

import java.util.Date;
import java.util.Objects;

public class PhoneBookRecord {


    private String phoneNumber;
    private Long subscriberId;
    private Date registeredDate;

    public PhoneBookRecord() {
    }

    public PhoneBookRecord(String phoneNumber, Long subscriberId, Date registeredDate) {
        this.phoneNumber = phoneNumber;
        this.subscriberId = subscriberId;
        this.registeredDate = registeredDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Long subscriberId) {
        this.subscriberId = subscriberId;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    @Override
    public String toString() {
        return "PhoneBookRecord{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", subscriberId=" + subscriberId +
                ", registeredDate=" + registeredDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBookRecord that = (PhoneBookRecord) o;
        return Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(subscriberId, that.subscriberId) &&
                Objects.equals(registeredDate, that.registeredDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(phoneNumber, subscriberId, registeredDate);
    }
}
