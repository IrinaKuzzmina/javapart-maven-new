package homework18;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Operator {
    private long operatorId;
    private String name;
    private String address;
    private BigDecimal fee;
    private List<String> phoneNumbers;

    public Operator() {
    }

    public Operator(long operatorId, String name, String address, BigDecimal fee, List<String> phoneNumbers) {
        this.operatorId = operatorId;
        this.name = name;
        this.address = address;
        this.fee = fee;
        this.phoneNumbers = phoneNumbers;
    }

    public long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(long operatorId) {
        this.operatorId = operatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "operatorId=" + operatorId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", fee=" + fee +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator = (Operator) o;
        return operatorId == operator.operatorId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(operatorId, name, address, fee, phoneNumbers);
    }

    public List<String> addNumber(String number) {
        this.phoneNumbers.add(number);
        return phoneNumbers;
    }
}
