package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 2. Список адресов [#340677]
 */
public class Profiles {
    /**
     * Метод возвращает список адресов клиентов
     * @param profiles - список клиентов
     * @return - список адресов клиентов
     */
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(x -> x.getAddress())
                .collect(Collectors.toList());
    }
}
