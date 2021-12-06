package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу сервиса, который хранит список клиентов(user)
 * класс позволяет создавать клиентам аккаунты для хранения средств
 * класс позволяет переводить средства с аккаунта на аккаунт
 * @author ARTEM POLSHCHAK
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение юзеров осуществляется в коллекции типа HashMap
     */
   final private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход юзера,
     * если юзера с таким именем нет в списке, то данный метод добавляет данного юзера в список
     * если юзер с таким именем уже имеется в списке, то добавление юзера игнорируется
     * @param user добавляется в список users (HashMap)
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет данного пользователя из списка
     * @param user пользователь, который удаляется из списка
     */
    public void deleteUser(User user) {
        this.users.remove(user);
    }

    /**
     * Методо добавляет аккаунт для данного пользователя
     * сперва, метод проверяет, есть ли данный пользователь в списке с помощью метода findByPassport
     * если пользователь не null, метод добавляет в список аккаунтов данного пользователя
     * @param passport пасспорт юзера которому нужно присвоить аккаунт если юзер есть в списке
     * @param account создается для данного юзера
     */
    public void addAccount(String passport, Account account) {
        User foundUser = findByPassport(passport);
        if (foundUser != null) {
            List<Account> userAccs = users.get(foundUser);
            if (!userAccs.contains(account)) {
                users.get(foundUser).add(account);
            }
        }
    }

    /**
     * Метод находит пользователя по пасспорту
     * метод проходит по всем елементам списка пользователей и сравнивает их с искомым пользователем
     * @param passport принимается на вход для осуществления поиска по пасспорту
     * @return возвращает искомого пользователя, если он есть в списке.
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод находит аккаунт клиента по реквизитами
     * @param passport приходит на вход метода, для поиска клиента по пасспорту
     * @param requisite приходит на вход метода, для поиска реквизитов данного пользователя
     * @return возвращает аккаунт владельца пасспорта
     */

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод переводит денежные средства с одного аккаунта на другой
     * сперва метод находит двух пользователей по реквизитам,
     * затем метод проверяет достаточно ли с редств у первого пользователя для трансвера средств
     *
     * @param srcPassport пасспорт первого пользователя, со счета которого нужно снять средства
     * @param srcRequisite реквизиты первого пользователя
     * @param destPassport пасспорт второго пользователя, на счет которого нужно положить средства
     * @param destRequisite реквизиты второго пользователя
     * @param amount количество средств, которые нужно перевести с первогона второй аккаунт
     * @return если оба пользователя найдены, и средств достаточно, метод возвращает true
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);

        if (srcAcc != null && destAcc != null && srcAcc.getBalance() >= amount) {
           srcAcc.setBalance(srcAcc.getBalance() - amount);
           destAcc.setBalance(destAcc.getBalance() + amount);
           rsl = true;
        }

        return rsl;
    }

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        String requisite = "3fdsbb9";
        accounts.add(new Account("3fdsbb9", 140));
        int index = accounts.indexOf(new Account(requisite, -1));
        Account find = accounts.get(index);
        System.out.println(find.getRequisite() + " -> " + find.getBalance());
    }
}
