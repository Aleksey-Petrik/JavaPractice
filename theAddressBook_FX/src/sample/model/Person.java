package sample.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Objects;

public class Person {
    private final SimpleStringProperty fullName;
    private final SimpleStringProperty telephoneNumber;
    private StringProperty address;

    public Person() {
        this("", "", "");
    }

    public Person(String fullName) {
        this(fullName, "", "");
    }

    public Person(String fullName, String telephoneNumber) {
        this(fullName, telephoneNumber, "");
    }

    public Person(String fullName, String telephoneNumber, String address) {
        this.fullName = new SimpleStringProperty(fullName);
        this.telephoneNumber = new SimpleStringProperty(telephoneNumber);
        this.address = new SimpleStringProperty(address);
    }

    public String getFullName() {
        return fullName.get();
    }

    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }

    public String getTelephoneNumber() {
        return telephoneNumber.get();
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber.set(telephoneNumber);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public SimpleStringProperty fullNameProperty() {
        return fullName;
    }

    public SimpleStringProperty telephoneNumberProperty() {
        return telephoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(fullName, person.fullName) &&
                Objects.equals(telephoneNumber, person.telephoneNumber) &&
                Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, telephoneNumber);//, address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName=" + fullName.get() +
                ", telephoneNumber=" + telephoneNumber.get() +
                ", address=" + address.get() +
                '}';
    }
}
