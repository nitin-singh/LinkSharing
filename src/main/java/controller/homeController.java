package controller;


import beans.Subscription;
import beans.User;
import beans.Visibility;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import dao.*;

import javax.servlet.Registration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Blob;
import java.util.List;

/**
 * Created by Prashant on 08-Jul-17.
 */
@Controller
public class homeController {

    @Autowired
    UserImplement userImplement;

    @Autowired
    services.Registration registration;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        return "home";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user) {
        ModelAndView model = new ModelAndView();
        String valid= userImplement.addUser(user);
        if(valid.equals("Not Valid")){
            model.addObject("msg","Already Exists Username or Email");
            model.setViewName("home");
        }
        else{
            model.setViewName("success");
        }
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpSession session, HttpServletResponse response, @RequestParam("Username") String Username, @RequestParam("Password") String Password,@ModelAttribute User user) {

        session=request.getSession(false);
        boolean result = userImplement.checkLogin(Username, Password);
        if (result == true) {

            int id=userImplement.getUserID(Username);

            user.setUserid(id);
            session.setAttribute("user" , Username);
            session.setAttribute("userId",user);
//            model.setViewName("dashboard");
            //List userData=userImplement.getUserData(Username);
            //System.out.println(userData.get(0));
            User userData=userImplement.getUserData(Username);
            long sub= userImplement.countSubscription(user);
            long topic= userImplement.countTopic(user);
            System.out.println("dash"+topic);
            request.getSession(true).setAttribute("userData",userData);
            request.getSession(true).setAttribute("subscription",sub);
            request.getSession(true).setAttribute("topics",topic);
            List<Subscription> displaySub = userImplement.subscriptionDisplay(user);
            request.getSession(true).setAttribute("displaySub",displaySub);
            return ("redirect:/dashboard");
        } else {

            request.setAttribute("msg","Not a valid Username or Password");
            return ("redirect:/");
        }

    }
    @RequestMapping(value = "/forgotpass", method = RequestMethod.GET)
    public ModelAndView forgotpass() {
        ModelAndView model = new ModelAndView();
        model.setViewName("forgotPassword");
        return model;

    }
    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public ModelAndView sendEmail( @RequestParam("emailid") String email) {
        ModelAndView model = new ModelAndView();
        String emailCheck="false";
        String msg="Invalid Email ID";
        emailCheck=userImplement.checkEmail(email);
        if(!emailCheck.equals("false")){
            msg=registration.sendEmail(email,emailCheck);
        }
        model.setViewName("forgotPassword");
        model.addObject("msg",msg);
        return model;

    }
    @RequestMapping(value = "/changePassword", method = RequestMethod.GET)
    public ModelAndView changePassword( @RequestParam("pass") String pass, @RequestParam("id") String id) {
        ModelAndView model = new ModelAndView();
        String msg="Enter Valid Email";
        msg=userImplement.changePassword(id,pass);
        model.setViewName("changePassword");
        model.addObject("msg",msg);
        return model;

    }
    @RequestMapping(value = "/change", method = RequestMethod.GET)
    public ModelAndView change(@RequestParam("id") String id) {
        ModelAndView model = new ModelAndView();
        model.addObject("msg",id);
        model.setViewName("changePassword");
         return model;

    }
}
