package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void findTest() {
        Person person1 = new Person("Ivan", "Petrov", "4951234567", "Tula");
        Person person2 = new Person("John", "Dow", "9876541", "S.Peterburg");
        Person person3 = new Person("Aaa", "Bbb", "5555555", "Mordor");
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(person1);
        phoneDictionary.add(person2);
        phoneDictionary.add(person3);
        ArrayList<Person> expected = new ArrayList<>();
        expected.add(person1);
        expected.add(person2);
        assertThat(phoneDictionary.find("Pet"), is(expected));
    }
}