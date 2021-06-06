package pl.ts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.ts.database.Database;
import pl.ts.model.User;
import pl.ts.session.SessionObject;
import pl.ts.validators.UserValidator;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;

@Controller
public class UserController {

    @Autowired
    Database database;

    @Resource
    SessionObject sessionObject;
    /*@Autowired
    UserDAO userDAO;*/

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("info", this.sessionObject.getInfo());
        model.addAttribute("logged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.getUser() != null ? this.sessionObject.getUser().getRole() : null);
        return "addUser";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user) {
        if (!UserValidator.validateFull(user)) {
            this.sessionObject.setInfo("Nieprawidłowe dane !!");
            return "redirect:/addUser";
        }
        this.database.addUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/editUser/{phoneNumber}", method = RequestMethod.GET)
    public String editUserForm(Model model, @PathVariable String phoneNumber) {
        User user = this.database.findUserByPhoneNumber(phoneNumber);
        if (user == null) {
            return "redirect:/main";
        }
        model.addAttribute("user", user);
        model.addAttribute("info", this.sessionObject.getInfo());
        model.addAttribute("logged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.getUser() != null ? this.sessionObject.getUser().getRole() : null);
        return "editUser";
    }

    @RequestMapping(value = "/editUser/{phoneNumber}", method = RequestMethod.POST)
    public String editUser(@PathVariable String phoneNumber, @ModelAttribute User user) {
        User userFromDb = database.findUserByPhoneNumber(phoneNumber);
        if (userFromDb == null) {
            return "redirect:/editUser/" + phoneNumber;
        }

        userFromDb.setName(user.getName());
        userFromDb.setSurname(user.getSurname());
        userFromDb.setAge(user.getAge());
        userFromDb.setPhoneNumber(user.getPhoneNumber());
        userFromDb.setRole(user.getRole());

        return "redirect:/main";
    }

}
