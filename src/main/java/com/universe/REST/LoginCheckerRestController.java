package com.universe.REST;

import com.universe.DAO.DAOLayer.RegistryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by boduill on 25.01.16.
 */

@RestController
@RequestMapping("/checkLogin/{login}")
public class LoginCheckerRestController {

    @Autowired
    private RegistryDAO registryDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String checkLogin(@PathVariable String login) {
        return registryDAO.checkLoginName(login);
    }
}
