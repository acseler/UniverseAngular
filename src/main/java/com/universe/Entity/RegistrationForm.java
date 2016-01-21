package com.universe.Entity;

import javax.persistence.Entity;

/**
 * Created by boduill on 14.12.15.
 */
@Entity
public class RegistrationForm extends EditProfileForm {
    private String login;
    private String password;
    private String universeName;
    private String description;


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

    public String getUniverseName() {
        return universeName;
    }

    public void setUniverseName(String universeName) {
        this.universeName = universeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




    @Override
    public String toString() {
        return "RegistrationForm{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", universeName='" + universeName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
