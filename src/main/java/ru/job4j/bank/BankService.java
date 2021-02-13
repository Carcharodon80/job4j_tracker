package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * основной класс, описывающий работу с банковскими счетами
 * @author Roman Akulov
 * @version 1.0
 */
public class BankService {
    /**
     * карта клиентов банка с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * добавляет нового клиента с пустым списком счетов в карту
     * если клиент уже есть - добавлять не нужно
     * @param user - новый пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * добавляет новый счет клиенту, клиента ищем по паспорту
     * если счет уже есть - не добавляем
     * @param passport паспорт клиента
     * @param account новый счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * метод ищет клиента по паспорту
     * @param passport паспорт клиента
     * @return возвращает клиента, если клиента с таким паспортом нет - возвращает null
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * метод ищет счет клиента по реквизиту, сначала клиента ищем по паспорту
     * @param passport паспорт клиента
     * @param requisite реквизит счета
     * @return счет клиента, если счет или клиент не найден - возвращает null
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * метод для перевода денег с одного счета на другой
     * @param srcPassport паспорт клиента, с которого переводим деньги
     * @param srcRequisite счет клиент, с которого переводим деньги
     * @param destPassport паспорт клиента, которому переводим деньги
     * @param destRequisite счет клиента, которому переводим деньги
     * @param amount сумма перевода
     * @return false - если какой-то счет не найден, или на счете не хватает денег
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null
                && srcAccount.getBalance() >= amount) {
            double newScrBalance = srcAccount.getBalance() - amount;
            double newDestBalance = destAccount.getBalance() + amount;
            srcAccount.setBalance(newScrBalance);
            destAccount.setBalance(newDestBalance);
            rsl = true;
        }
        return rsl;
    }
}
