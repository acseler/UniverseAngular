package com.universe.MVC.Controllers;

import com.universe.DAO.DAOLayer.EditProfileDAO;
import com.universe.DAO.DAOLayer.MessageInfoDAO;
import com.universe.Tools.ControllerTools;
import com.universe.Entity.Account;
import com.universe.Entity.EditProfileForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by boduill on 14.12.15.
 */
@Controller
@Scope("session")
@RequestMapping("/edit")
public class EditController {

    @Autowired
    private ControllerTools controllerTools;

    @Autowired
    private EditProfileDAO editProfileDAO;

    @Autowired
    private MessageInfoDAO messageInfoDAO;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getChangeUserInfoPage(HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        if (null == account) {
            return new ModelAndView("wellcome");
        }
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("account", account);
        attributes.put("messageInfo", messageInfoDAO.getMessageInfo(account));
        return new ModelAndView("edit", attributes);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView changeUserInfo(@Valid EditProfileForm editProdfileForm,
                                       BindingResult bindingResult,
                                       @RequestParam(value = "avatar") MultipartFile avatar,
                                       HttpSession session) throws IOException {
        Account account = (Account) session.getAttribute("account");
        Map<String,Object> attributes = new HashMap<>();

        if (null == account) {
            return new ModelAndView("wellcome");
        }
        account = controllerTools.editUserProfile(account, editProdfileForm);
        if (!avatar.isEmpty()) {
            account.setAvatar(avatar.getBytes());
        }
        editProfileDAO.changeUserProfile(account);
        return new ModelAndView("edit", "account", account);
    }
}
