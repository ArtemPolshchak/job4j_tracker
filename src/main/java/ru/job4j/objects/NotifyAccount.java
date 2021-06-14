package ru.job4j.objects;

import java.util.HashSet;
import java.util.List;

public class NotifyAccount {
    public static HashSet<Account1> sent(List<Account1> accounts) {
        HashSet<Account1> rsl = new HashSet<>();
        for (Account1 account : accounts) {
            rsl.add(account);
        }

        return rsl;
    }
}
