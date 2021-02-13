package ru.job4j.bank;

import java.util.Objects;

/**
 * pojo-класс для описания клиента банка
 * @author Roman Akulov
 * @version 1.0
 */
public class User {
    /**
     * паспорт клиента, уникальное поле для каждого клиента
     */
    private String passport;
    /**
     * имя клиента
     */
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * клиенты сравниваются по уникальному паспорту
     * @param o объект для сравнения
     * @return true если объекты идентичны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
