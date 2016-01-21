package com.universe.Entity;

import javax.persistence.*;

/**
 * Created by boduill on 04.12.15.
 * Entity for logins table
 */
@Entity
@Table(name = "LOGINS")
public class Login {
    @Id
    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ACC_ID")
    private Account account;

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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Login{" +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", account=" + account +
                '}';
    }
}
