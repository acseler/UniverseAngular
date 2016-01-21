//package com.universe.MVC.Controllers;
//
//import com.universe.Entity.Account;
//import com.universe.Entity.Universe;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.Date;
//
///**
//* Created by boduill on 20.09.15.
//*/
//@Controller
//@RequestMapping(value = "/")
//public class TestController {
//    @RequestMapping (method = RequestMethod.GET)
//    public ModelAndView getTestPage() {
//        Account account = new Account();
//        account.setFirstName("Saitama");
//        account.setLastName("Onepunch Man");
//        account.setBirthDay(new Date());
//        account.setHobbies("Superhero");
//        account.setProfession("Unemployed");
//        account.setUniverse(null);
//        Universe universe = new Universe();
//        universe.setUnverseName("Onepunch Man");
//        universe.setDescription("About Onepunch Man");
//        return new ModelAndView("home", "account", account);
//    }
//}
