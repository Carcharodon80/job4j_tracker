package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 2. Список адресов [#340677]
 */
public class ProfilesTest {
    @Test
    public void testCollect() {
        Profiles main = new Profiles();
        List<Profile> profiles = List.of(
                new Profile("Ivan", new Address("Moscow", "Arbat", 15, 135)),
                new Profile("John", new Address("Chicago", "Main street", 6, 65)),
                new Profile("Olivia", new Address("Paris", "Sevastopol bulvar", 45, 45))
        );
        List<Address> rsl = main.collect(profiles);
        List<Address> expected = List.of(
                new Address("Moscow", "Arbat", 15, 135),
                new Address("Chicago", "Main street", 6, 65),
        new Address("Paris", "Sevastopol bulvar", 45, 45)
        );
        assertThat(rsl, is(expected));
    }

}