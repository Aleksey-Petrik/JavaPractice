package sample.storage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.model.Person;

public class CollectionAddressBook implements AddressBook {
    private final ObservableList<Person> storage = FXCollections.observableArrayList();

    public ObservableList<Person> getStorage() {
        return storage;
    }

    public int getSize(){
        return storage.size();
    }

    public void testData() {
        add(new Person("Jack", "999-9999", "st.Black 69"));
        add(new Person("Nick", "888-8888", "st.White 99"));
        add(new Person("Jane", "777-7777", "st.Black 69"));
        add(new Person("Rock", "666-6666", "st.White 99"));
        add(new Person("Same", "555-5555", "st.Black 69"));
        add(new Person("Tome", "444-4444", "st.White 99"));
    }

    public String printPersons() {
        StringBuilder sb = new StringBuilder();
        storage.forEach(person -> sb.append("ФИО - ")
                .append(person.getFullName())
                .append(" Номер телефона - ")
                .append(person.getTelephoneNumber())
                .append("\n"));
        return sb.toString();
    }

    @Override
    public void add(Person person) {
        storage.add(person);
    }

    @Override
    public void delete(Person person) {
        storage.remove(person);
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public String toString() {
        return "CollectionAddressBook{" +
                "storage=" + storage +
                '}';
    }

}
