package ru.job4j.stream;

import java.util.Objects;

public class User {
    private String name;
    private String surname;
    private byte age;
    private String login;
    private String password;
    private boolean activated;
    private String gender;

    static class Builder {
        private String name;
        private String surname;
        private byte age;
        private String login;
        private String password;
        private boolean activated;
        private String gender;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildLogin(String login) {
            this.login = login;
            return this;
        }

        Builder buildPassword(String password) {
            this.password = password;
            return this;
        }

        Builder buildActivated(boolean activated) {
            this.activated = activated;
            return this;
        }

        Builder buildGender(String gender) {
            this.gender = gender;
            return this;
        }

        User build() {
            User user = new User();
            user.name = name;
            user.surname = surname;
            user.age = age;
            user.login = login;
            user.password = password;
            user.activated = activated;
            user.gender = gender;
            return user;
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User user)) {
            return false;
        }

        return getAge() == user.getAge()
                && isActivated() == user.isActivated()
                && Objects.equals(getName(), user.getName())
                && Objects.equals(getLogin(), user.getLogin())
                && Objects.equals(getPassword(), user.getPassword())
                && Objects.equals(getGender(), user.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getLogin(),
                getPassword(), isActivated(), getGender());
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name
                + '\'' + ", surname='" + surname
                + '\'' + ", age=" + age
                + ", login='" + login
                + '\'' + ", password='" + password
                + '\'' + ", activated=" + activated
                + ", gender='" + gender + '\'' + '}';
    }

    public static void main(String[] args) {
        User user = new Builder().buildName("name")
                .buildSurname("surname")
                .buildAge((byte) 32)
                .buildLogin("Login")
                .buildActivated(true)
                .buildGender("male")
                .build();
        System.out.println(user);
    }
}
