package ru.job4j.bank;

import java.util.Objects;

/**
 * pojo-класс банковского счета для пользователя банка
 * @author Roman Akulov
 * @version 1.0
 */
public class Account {
    /**
     * реквизиты счета - строка с уникальным идентификатором
     */
    private String requisite;
    /**
     * баланс счета
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * счета сравниваются по уникальному полю requisite
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
