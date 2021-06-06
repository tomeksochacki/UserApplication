package pl.ts.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.ts.database.Database;
import pl.ts.model.User;
import pl.ts.model.view.Mail;
import pl.ts.session.SessionObject;

import javax.annotation.Resource;
import javax.swing.*;
import javax.xml.parsers.SAXParser;
import java.util.List;

@Controller
public class CommonController {

    @Autowired
    Database database;

    @Resource
    SessionObject sessionObject;

    /*@Autowired
    UserDAO userDAO;*/

    /*@RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model){
        List<User> users = this.userDAO.getAllUsers();
        model.addAttribute("users", users);
        return "main";
    }


    @Autowired
    IBookService bookService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("books", this.bookService.getBooksWithFilter());
        model.addAttribute("logged", this.sessionObject.isLogged());
        model.addAttribute("role",
                this.sessionObject.getUser() != null ? this.sessionObject.getUser().getRole() : null);
        return "main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main2(Model model) {
        return "redirect:/";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model) {
        model.addAttribute("mail", new Mail());
        model.addAttribute("logged", this.sessionObject.isLogged());
        model.addAttribute("role",
                this.sessionObject.getUser() != null ? this.sessionObject.getUser().getRole() : null);
        return "contact";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String processForm(@ModelAttribute Mail mail) {
        System.out.println(mail.getTitle());
        System.out.println(mail.getMessage());
        System.out.println(mail.getName());
        return "redirect:/";
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public String find(@RequestParam String pattern) {
        this.sessionObject.setFindPattern(pattern);
        return "redirect:/";
    }*/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model) {
        List<User> users;

        if (this.sessionObject.getFindPattern() != null && !this.sessionObject.getFindPattern().equals("")) {
            users = this.database.getFilteredUsers(this.sessionObject.getFindPattern());
        } else {
            users = this.database.getAllUsers();
        }
        model.addAttribute("users", users);
        model.addAttribute("logged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.getUser() != null ? this.sessionObject.getUser().getRole() : null);
        return "main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main2(Model model) {
        return "redirect:/";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model) {
        model.addAttribute("mail", new Mail());
        model.addAttribute("logged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.getUser() != null ? this.sessionObject.getUser().getRole() : null);
        return "contact";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String processForm(@ModelAttribute Mail mail) {
        System.out.println(mail.getTitle());
        System.out.println(mail.getMessage());
        System.out.println(mail.getName());
        return "redirect:/";
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public String find(@RequestParam String pattern) {
        this.sessionObject.setFindPattern(pattern);
        return "redirect:/";
    }
}
