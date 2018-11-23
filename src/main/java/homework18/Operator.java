package homework18;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Operator {
    private long operatorId;
    private String name;
    private String address;
    private BigDecimal fee;
    private List<String> phoneNumbers;

    public Operator() {
    }

    public Operator(long operatorId, String name, List<String> phoneNumbers) {
        this.operatorId = operatorId;
        this.name = name;
        this.phoneNumbers = phoneNumbers;
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

    public static Operator generateOperatorNumber() {
        Random random = new Random();
        double defineOperator = Math.random();
        double defineNumber = Math.random();
        int upperLimit = 10_000_000;
        int lowerLimit = 1_000_000;
        Operator operator = null;
        Long id = null;
        String name = null;
        List<String> number = new ArrayList<>();

        if (defineOperator <= 0.3) {
            id = 1L;
            name = "Life";
            if (defineNumber <= 0.3) {
                number.add("38063" + (random.nextInt(upperLimit - lowerLimit) + lowerLimit));
            } else if (defineNumber >= 0.4 && defineNumber <= 0.6) {
                number.add("38093" + (random.nextInt(upperLimit - lowerLimit) + lowerLimit));
            } else {
                number.add("38073" + (random.nextInt(upperLimit - lowerLimit) + lowerLimit));
            }
            operator = new Operator(id, name, number);
        } else if ((defineOperator >= 0.4 && defineOperator <= 0.6)) {
            id = 2L;
            name = "Kievstar";
            if (defineNumber <= 0.3) {
                number.add("38097" + (random.nextInt(upperLimit - lowerLimit) + lowerLimit));
            } else if (defineNumber >= 0.4 && defineNumber <= 0.6) {
                number.add("38067" + (random.nextInt(upperLimit - lowerLimit) + lowerLimit));
            } else {
                number.add("38098" + (random.nextInt(upperLimit - lowerLimit) + lowerLimit));
            }
            operator = new Operator(id, name, number);
        } else {
            id = 3L;
            name = "Vodafone";
            if (defineNumber <= 0.3) {
                number.add("38050" + (random.nextInt(random.nextInt(upperLimit - lowerLimit) + lowerLimit)));
            } else if (defineNumber >= 0.4 && defineNumber <= 0.6) {
                number.add("38066" + (random.nextInt(random.nextInt(upperLimit - lowerLimit) + lowerLimit)));
            } else {
                number.add("38095" + (random.nextInt(random.nextInt(upperLimit - lowerLimit) + lowerLimit)));
            }
            operator = new Operator(id, name, number);
        }
        return operator;
    }

    public static void main(String[] args) {
        System.out.println(generateOperatorNumber().toString());
    }

}
