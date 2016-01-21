package com.universe.DAO.DAOLayer;

import com.universe.Entity.Account;
import com.universe.Entity.Dialog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by boduill on 11.01.16.
 */
@Repository
public class DialogDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<Dialog> getDialogs(Account account) {
        List<Dialog> dialogList = (List<Dialog>) hibernateTemplate.find("FROM Dialog WHERE acc_id_one = ?" +
                " ORDER BY message_time DESC", account.getId());

        return dialogList;
    }

}
