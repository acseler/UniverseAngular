package com.universe.DAO.DAOLayer;

import com.universe.Entity.Account;
import com.universe.Entity.MessageInfo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by boduill on 28.12.15.
 */
@Repository
public class MessageInfoDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public MessageInfo getMessageInfo(final Account account) {
        return hibernateTemplate.execute(new HibernateCallback<MessageInfo>() {
            @Override
            public MessageInfo doInHibernate(Session session) throws HibernateException {
                return (MessageInfo) session.createQuery("FROM MessageInfo where acc_id = ?").setParameter(0, account.getId()).uniqueResult();
            }
        });
    }
}
