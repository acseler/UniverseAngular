package com.universe.DAO.DAOLayer;

import com.universe.Entity.Account;
import com.universe.Entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by boduill on 07.12.15.
 * DAO class for user authorization
 */
@Repository
public class LoginDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    /**
     * Checking login and password
     * @param login - login
     * @param password - password
     * @return - Account entity
     */
    @Transactional
    public Account checkLoginAndPassword(String login, String password) {
        Login loginEn = null;
        if (login.isEmpty() || password.isEmpty()) {
            return null;
        } else {
            loginEn = hibernateTemplate.get(Login.class, login);
        }
        if (null == loginEn) {
            return null;
        } else {
            if (loginEn.getLogin().equals(login) && loginEn.getPassword().equals(password)) {
                return loginEn.getAccount();
            }
        }
        return null;
    }


}
