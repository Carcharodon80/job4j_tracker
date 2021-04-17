package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * 6. Функции высшего порядка [#340662]
 * 2. Local-Variable Type Inference [#340688]
 */
public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Ищет совпадения (можно частичные) по всем полям класса Person (используя Predicate)
     * @param key - что нужно найти
     * @return
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> checkName = person -> person.getName().contains(key);
        Predicate<Person> checkSurname = person -> person.getSurname().contains(key);
        Predicate<Person> checkPhone = person -> person.getPhone().contains(key);
        Predicate<Person> checkAddress = person -> person.getAddress().contains(key);
        Predicate<Person> combine = checkName.or(checkSurname.or(checkAddress.or(checkPhone)));
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
