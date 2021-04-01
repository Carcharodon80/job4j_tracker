package ru.job4j.stream;

/**
 * 2. Список адресов [#340677]
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
