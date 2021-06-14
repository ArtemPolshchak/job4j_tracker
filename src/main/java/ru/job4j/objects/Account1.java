package ru.job4j.objects;

import java.util.Objects;

public class Account1 {
    private String passport;
    private String username;
    private String deposit;

    public Account1(String passport, String username, String deposit) {
        this.passport = passport;
        this.username = username;
        this.deposit = deposit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account1 account = (Account1) o;
        return Objects.equals(passport, account.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    @Override
    public String toString() {
        return "Account{"
                + "passport='"
                + passport + '\''
                + ", username='"
                + username + '\''
                + ", deposit='"
                + deposit + '\'' + '}';
    }
}

