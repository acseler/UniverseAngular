package com.universe.MVC.Controllers;

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import com.universe.DAO.DAOLayer.DialogDAO;
import com.universe.DAO.DAOLayer.MessageDAO;
import com.universe.DAO.DAOLayer.MessageInfoDAO;
import com.universe.Entity.Account;
import com.universe.Entity.MessageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by boduill on 23.12.15.
 */
@Controller
@Scope("session")
@RequestMapping(value = "/message")
public class MessageController {

    private static final Logger logger = Logger.getLogger(MessageController.class);

    @Autowired
    private MessageInfoDAO messageInfoDAO;

    @Autowired
    private DialogDAO dialogDAO;

    @Autowired
    private MessageDAO messageDAO;

    @RequestMapping(value = "/{userId}", method = RequestMethod.POST)
    public void sendMessage(@RequestParam("message") String message,
                            @PathVariable long userId,
                            HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        messageDAO.sendMessage(account, userId, message);
        System.out.println(userId);
        System.out.println(message);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getMessagesPage(HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        if (null != account) {
            Map<String, Object> attributes = new HashMap<>();
            session.setAttribute("account", account);
            attributes.put("account", account);
            attributes.put("messageInfo", messageInfoDAO.getMessageInfo(account));
            logger.info(messageInfoDAO.getMessageInfo(account));
            attributes.put("dialogs", dialogDAO.getDialogs(account));
            return new ModelAndView("messages", attributes);
        } else {
            return new ModelAndView("wellcome");
        }
    }

//    @RequestMapping(value = "/{dialogId}", method = RequestMethod.GET)
//    public ModelAndView getMessageForDialog(HttpSession session,
//                                            @PathVariable long dialogId) {
//        Account account = (Account) session.getAttribute("account");
//        if (null != account) {
//            Map<String, Object> attributes = new HashMap<>();
//            session.setAttribute("account", account);
//            attributes.put("account", account);
//            attributes.put("messageInfo", messageInfoDAO.getMessageInfo(account));
//            attributes.put("messages", messageDAO.getMessages(dialogId));
//            System.out.println(Arrays.toString(messageDAO.getMessages(dialogId).toArray()));
//            return new ModelAndView("dialog", attributes);
//        } else {
//            return new ModelAndView("wellcome");
//        }
//    }
}
