package com.universe.DAO.DAOLayer;

import com.universe.Entity.Account;
import com.universe.Entity.Dialog;
import com.universe.Entity.Message;
import com.universe.Tools.DAOTools;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by boduill on 04.01.16.
 */
@Repository
public class MessageDAO {

    private static final Logger logger = Logger.getLogger(MessageDAO.class);

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Autowired
    private DAOTools daoTools;

    @Transactional
    public List<Message> getMessages(Long dialogId) {
        return (List<Message>) hibernateTemplate.find("FROM Message WHERE dial_id = ? ORDER BY message_time ASC", dialogId);
    }

    @Transactional
    public Message getLastMessage(Long dialogId) {
        List<Message> messageList = (List<Message>) hibernateTemplate.find("FROM Message WHERE dial_id = ? ORDER BY message_time ASC", dialogId);
        return messageList.get(messageList.size() - 1);
    }

    @Transactional
    public void sendMessage(Account account, Long userId, String message) {
        logger.info(account);
        logger.info(userId);
        logger.info(message);
        Dialog dialog = new Dialog();
        dialog.setAccIdOne(account);
        dialog.setAccIdTwo(daoTools.getAccountById(userId));
        dialog.setMessage(message);
        dialog.setMessageTime(new Date());
        hibernateTemplate.save(dialog);
    }
}

