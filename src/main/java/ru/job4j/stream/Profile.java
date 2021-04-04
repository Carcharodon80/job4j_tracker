package ru.job4j.stream;

/**
 * 3. Уникальность элементов и сортировка. [#340678]
 */
public class Profile {
    private String name;
    private Address address;

    public Profile(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
