package com.universe.MVC.Controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by bod on 12.01.2016.
 */
@Controller
@Scope("session")
@RequestMapping(value = "/exit")
public class ExitController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView closeSession(HttpSession session) {
//        session.removeAttribute("account");
        return new ModelAndView("wellcome");
    }
}
