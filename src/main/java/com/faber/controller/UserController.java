package com.faber.controller;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.faber.business.UserService;
import com.faber.entities.User;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//</editor-fold>

/**
 *
 * @author Nguyen Duc Thien
 * @email nguyenducthien@fabercompany.co.jp
 */
@RestController
public class UserController {

    Logger logger = LogManager.getLogger(UserController.class);
    
    @Autowired//Inject userService class, don't need to init new userservice
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    private List<User> getUser() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
        return userService.getListUser();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    private User getUser(@PathVariable int id) {
        return userService.getUserByID(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    private void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    String delUser() {
        return "Hello World!";
    }
}
