package com.universe.MVC.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.universe.DAO.DAOLayer.FriendsDAO;
import com.universe.DAO.DAOLayer.MessageInfoDAO;
import com.universe.Entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by boduill on 15.12.15.
 */
@Controller
@Scope("session")
@RequestMapping(value = "/friends")
public class FriendsController {

    @Autowired
    private FriendsDAO friendsDAO;

    @Autowired
    private MessageInfoDAO messageInfoDAO;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getFriendsList(HttpSession session) throws JsonProcessingException {
        Account account = (Account) session.getAttribute("account");
        ObjectMapper objectMapper = new ObjectMapper();
//        System.out.println(objectMapper.writeValueAsString(account));
        if (null == account) {
            return new ModelAndView("wellcome");
        }
        Map<String, Object> modelData = new HashMap<>();
        modelData.put("friendList", friendsDAO.getAccountFriends(account));
        modelData.put("account", account);
        modelData.put("messageInfo", messageInfoDAO.getMessageInfo(account));
        return new ModelAndView("friends", modelData);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addFriend() {
        return null;
    }

    @RequestMapping(value = "/{accId}/{friendId}",method = RequestMethod.POST)
    public void deleteFriend(@PathVariable("accId") long accId,
                             @PathVariable("friendId") long friendId) {
        System.out.println("accId " + accId);
        System.out.println("frId " + friendId);
    }


}

