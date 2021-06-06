/*
package pl.ts.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import pl.ts.model.User;
import pl.ts.services.IAuthenticationService;

import javax.annotation.Resource;

@Controller
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    IUserDAO userDAO;

    @Resource
    SessionObject sessionObject;

    public boolean authenticate(String login, String password) {
        User user = this.userDAO.getUserByLogin(login);

        if(user != null && user.getPassword().equals(DigestUtils.md5Hex(password))) {
            sessionObject.setUser(user);
            return true;
        }

        return false;
    }

    public void registerUser(User user) {
        user.setRole(User.Role.USER);
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        this.userDAO.addUser(user);
    }
}
*/
