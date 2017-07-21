package controller;

import beans.Topic;
import beans.User;
import org.springframework.web.multipart.MultipartFile;
import services.TopicService;
import beans.Visibility;
import dao.TopicImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Prashant on 16-Jul-17.
 */
@Controller
public class dashboardController {

    @Autowired
    TopicService topicService;

    @Autowired
    TopicImplement topicImplement;

   /* @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(HttpServletRequest request, HttpSession session) {
        session  = request.getSession(false);

     //   request.setAttribute("Visibility", beans.Visibility.values());
        //model.addObject();
        if((String)session.getAttribute("user")!=null)
        {
            return "dashboard";
        }

        return "redirect:/";
      }*/
    @RequestMapping(value = "/topic", method = RequestMethod.POST)
     public @ResponseBody
    String   addTopic(HttpServletRequest request, HttpSession session, @RequestParam("visibility") String visibility,
                            @RequestParam("name") String name, @ModelAttribute("topic") Topic topic) {
        session  = request.getSession(false);
        String user=(String)session.getAttribute("user");
       User userid=(User) session.getAttribute("userId");
       // topic.setCreatedBy(user);
        topic.settopicname(name);
        topic.setVisibility(Visibility.valueOf(visibility));
       /* System.out.println("1= "+topic.gettopicname());*/
        System.out.println("1= "+topic.getVisibility());

        System.out.println("1= "+userid);
       String msg=topicImplement.addTopic(topic,userid);
        //model.addObject("msg",msg);

        return "{}";
    }

    @RequestMapping(value = "/sendInvite", method = RequestMethod.POST)
    public @ResponseBody String sendInvite(HttpServletRequest request, HttpSession session, @RequestParam("email") String email,
                            @RequestParam("topic") String topic) {
        User userid=(User) session.getAttribute("userId");
        System.out.println("invite");
        String emailMsg="Email not sent ";
        emailMsg=topicService.sendInvite(email,topic);
        topicImplement.displayTopicDropDown(userid.getUserid());
       /* return emailMsg;*/
        return "{}";
 }

        @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard(HttpServletRequest request, HttpSession session) {
        session  = request.getSession(false);
            ModelAndView modal=new ModelAndView();
             modal.setViewName("/");
            System.out.println(session.getAttribute("user"));
            if(session.getAttribute("user")!=null)
            {
                User user=(User)session.getAttribute("userId");
                modal.setViewName("dashboard");
                modal.addObject("topicname",topicImplement.displayTopicDropDown(user.getUserid()));
                modal.addObject("user",user.getUsername());
                modal.addObject("firstName",user.getFirstname());

            }
        return modal;
    }

    @RequestMapping(value = "/document", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    String documentUpload(HttpServletRequest request, HttpSession session, @RequestParam("description") String description,@RequestParam("topicDocument") String topicDocument, @RequestParam("file") MultipartFile file ) {
        session  = request.getSession(false);
        System.out.println("hello document");

        //   System.out.println("desc= "+description+" file= "+file);

     /*   System.out.println(file.getOriginalFilename());
     */
        String user=(String)session.getAttribute("user");
        User userid=(User) session.getAttribute("userId");


    //    topicImplement.addDocument(appPath,description,topicDocument,userid);



            String appPath = request.getServletContext().getRealPath("");
            String filePath=topicService.uploadFile(appPath,file);
            //    topicImplement.addDocument(appPath,description,topicDocument,userid);
             int topicid= topicImplement.topicId(topicDocument);
            topicImplement.addDocument(filePath,description,topicid,userid);
        // topic.setCreatedBy(user);
      //  topic.settopicname(name);
       // topic.setVisibility(Visibility.valueOf(visibility));
       // System.out.println("1= "+topic.gettopicname());
        //System.out.println("1= "+topic.getVisibility());
       //String msg=topicImplement.addTopic(topic,userid);
        //model.addObject("msg",msg);

        return "{}";
    }

    @RequestMapping(value = "/linkShare", method = RequestMethod.POST)
    public @ResponseBody
    String linkShare(HttpServletRequest request, HttpSession session, @RequestParam("link") String link,@RequestParam("descriptionLink") String descriptionLink, @RequestParam("topicLink") String topicLink ) {
        session  = request.getSession(false);
        System.out.println("hello document");
        String user=(String)session.getAttribute("user");
        User userid=(User) session.getAttribute("userId");
        int topicid= topicImplement.topicId(topicLink);
        topicImplement.addLink(link,descriptionLink,topicid,userid);
        return "success";
    }
}


