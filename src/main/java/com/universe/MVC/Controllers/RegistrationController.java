package com.universe.MVC.Controllers;

import com.universe.DAO.DAOLayer.MessageInfoDAO;
import com.universe.DAO.DAOLayer.RegistryDAO;
import com.universe.Entity.Account;
import com.universe.Entity.Login;
import com.universe.Entity.RegistrationForm;
import com.universe.Tools.ControllerTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@Scope("session")
@RequestMapping(value = "/")
public class RegistrationController {

    @Autowired
    private RegistryDAO registryDAO;

    @Autowired
    private MessageInfoDAO messageInfoDAO;

    @Autowired
    private ControllerTools controllerTools;

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String getWellcomePage() {
        return "pages/index.html";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView doneRegistry(@Valid RegistrationForm registrationForm,
                                     BindingResult bindingResult,
                                     @RequestParam(value = "avatar", required = true) MultipartFile avatar,
                                     HttpSession session) {

        Login login = controllerTools.fillLoginFields(registrationForm);
        try {
            login.getAccount().setAvatar(avatar.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Account account = login.getAccount();
        if (registryDAO.createAccount(login, controllerTools.getNewMessageInfoForAccount())) {
            Map<String, Object> attributes = new HashMap<>();
            session.setAttribute("account", account);
            attributes.put("account", account);
            attributes.put("messageInfo", messageInfoDAO.getMessageInfo(account));
            return new ModelAndView("home", attributes);
        } else {
            return new ModelAndView("wellcome");
        }
    }

}


