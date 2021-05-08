package ru.job4j.bank;

import java.util.*;

public class BankService {

    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
         List<Account> accounts = new ArrayList<>();
         if (!users.containsKey(user.getPassport())) {
             users.put(user, accounts);
         }
    }

    public void deleteUser(User user) {
        this.users.remove(user);
    }

    public void addAccount(String passport, Account account) {
        User foundUser = findByPassport(passport);
        if (foundUser != null) {
            List<Account> userAccs = users.get(findByPassport(passport));
            if (!userAccs.contains(account)) {
                users.get(findByPassport(passport)).add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                rsl = key;
                break;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account foundAccount = null;
        User user = findByPassport(passport);
        List<Account> accounts = users.get(user);
        for (Account accountForUser : accounts) {
            if (accountForUser.getRequisite().equals(requisite)) {
                foundAccount = accountForUser;
                break;
            }
        }
        return foundAccount;
    }

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
