package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 3. Уникальность элементов и сортировка. [#340678]
 */
public class Profiles {
    /**
     * Метод возвращает список уникальных адресов клиентов, отсортированных по полю city
     * @param profiles - список клиентов
     * @return - список адресов клиентов
     */
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted((Comparator.comparing(Address::getCity)))
                .distinct()
                .collect(Collectors.toList());
    }
}
