package ru.job4j.bank;

import java.util.*;

/**
 * 3. Банковские переводы [#340848]
 * 4. Optional в Stream API. [#340690]
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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * метод ищет клиента по паспорту
     * @param passport паспорт клиента
     * @return возвращает клиента, если клиента с таким паспортом нет - возвращает Optional.empty()
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * метод ищет счет клиента по реквизиту, сначала клиента ищем по паспорту
     * @param passport паспорт клиента
     * @param requisite реквизит счета
     * @return счет клиента, если счет или клиент не найден - возвращает Optional.empty()
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        Optional<Account> account = Optional.empty();
        if (user.isPresent()) {
            account = users.get(user.get())
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst();
        }
        return account;
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            double newScrBalance = srcAccount.get().getBalance() - amount;
            double newDestBalance = destAccount.get().getBalance() + amount;
            srcAccount.get().setBalance(newScrBalance);
            destAccount.get().setBalance(newDestBalance);
            rsl = true;
        }
        return rsl;
    }
}
