package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 6. Функции высшего порядка [#340662]
 * 2. Local-Variable Type Inference [#340688]
 */
public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void findTest() {
        var person1 = new Person("Ivan", "Petrov", "4951234567", "Tula");
        var person2 = new Person("John", "Dow", "9876541", "S.Peterburg");
        var person3 = new Person("Aaa", "Bbb", "5555555", "Mordor");
        var phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(person1);
        phoneDictionary.add(person2);
        phoneDictionary.add(person3);
        var expected = new ArrayList<>();
        expected.add(person1);
        expected.add(person2);
        assertThat(phoneDictionary.find("Pet"), is(expected));
    }
}