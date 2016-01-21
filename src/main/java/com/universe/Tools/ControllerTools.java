package com.universe.Tools;

import com.universe.Entity.*;
import org.springframework.stereotype.Component;

import java.util.GregorianCalendar;

/**
 * Created by boduill on 01.12.15.
 * Tools for controllers
 */
@Component
public class ControllerTools {

    /**
     * Method gets necessary fields from RegistrationForm and fill Universe fields
     * @param registrationForm - Registration form entity
     * @return - Universe entity
     */
    private Universe fillUniverseFields(RegistrationForm registrationForm) {
        Universe universe = new Universe();
        universe.setUnverseName(registrationForm.getUniverseName());
        universe.setDescription(registrationForm.getDescription());
        universe.setUnTable(registrationForm.getUniverseName().
                toLowerCase().trim().replace(' ', '_'));
        return universe;
    }

    /**
     * Method gets necessary fields from RegistrationForm and fill Login fields
     * @param registrationForm - Registration form entity
     * @return - Login entity
     */
    public Login fillLoginFields(RegistrationForm registrationForm) {
        Login loginEn = new Login();
        loginEn.setLogin(registrationForm.getLogin());
        loginEn.setPassword(registrationForm.getPassword());
        loginEn.setAccount(fillAccountFields(registrationForm));
        return loginEn;
    }

    /**
     * Method gets necessary fields from RegistrationForm and fill Accounts fields
     * @param registrationForm - Registration form entity
     * @return - Account entity
     */
    private Account fillAccountFields(RegistrationForm registrationForm) {
        Account account = new Account();
        account.setFirstName(registrationForm.getFirstName());
        account.setLastName(registrationForm.getLastName());
        account.setBirthDay(new GregorianCalendar(registrationForm.getBirthDayYear(),
                registrationForm.getBirthDayMounth() - 1,
                registrationForm.getBirthDayDay()
        ).getTime());
        account.seteMail(registrationForm.geteMail());
        account.setProfession(registrationForm.getProfession());
        account.setHobbies(registrationForm.getHobbies());
        account.setUniverse(fillUniverseFields(registrationForm));
        return account;
    }

    /**
     * Method get fields from EditProfileForm and replace Account field
     * @param account - Account entity
     * @param editProfileForm - EditProfileForm entity
     * @return - Account entity
     */
    public Account editUserProfile(Account account, EditProfileForm editProfileForm) {
        account.setFirstName(editProfileForm.getFirstName());
        account.setLastName(editProfileForm.getLastName());
        account.setBirthDay(new GregorianCalendar(editProfileForm.getBirthDayYear(),
                editProfileForm.getBirthDayMounth() - 1, editProfileForm.getBirthDayDay()).getTime());
        account.seteMail(editProfileForm.geteMail());
        account.setProfession(editProfileForm.getProfession());
        account.setHobbies(editProfileForm.getHobbies());
        return account;
    }

    public MessageInfo getNewMessageInfoForAccount() {
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessCount(0);
        return messageInfo;
    }
}

