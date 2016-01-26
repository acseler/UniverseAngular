package com.universe.REST;

import com.universe.Entity.Account;
import com.universe.Entity.RegistrationForm;
import org.apache.log4j.Logger;
import org.springframework.http.RequestEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by boduill on 25.01.16.
 */
@RestController
@RequestMapping("/registration")
public class RegistrationRestController {

    private static final Logger logger = Logger.getLogger(RegistrationRestController.class);

    @RequestMapping(method = RequestMethod.POST)
    RequestEntity<Account> registryAccount(@ModelAttribute RegistrationForm regForm,
                                           BindingResult bindingResult,
                                           @RequestParam(value = "avatar", required = true) MultipartFile avatar) {
        logger.info("regForm " + regForm);
        logger.info(avatar);
        return null;
    }
}
