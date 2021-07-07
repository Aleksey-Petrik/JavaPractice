package sample.storage;

import sample.model.Person;

public interface AddressBook {
    void add(Person person);
    void delete(Person person);
    void update(Person person);
}
