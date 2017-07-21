package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Prashant on 16-Jul-17.
 */
@Controller
public class logout {
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView forgotpass(HttpServletRequest request, HttpSession session) {
        ModelAndView model = new ModelAndView();
        session  = request.getSession(false);
        session.invalidate();
        model.setViewName("logout");

        return model;

    }
}
