package Events;


import beans.User;
import dao.UserImplement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import services.Registration;

import javax.persistence.Query;
import java.util.List;


/**
 * Created by Prashant on 14-Jul-17.
 */
@Component
public class StartupEventListener {

    @Autowired
    private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void ContextRefreshedEvent(final ContextRefreshedEvent event) {


       checkAdmin();


/*
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("Context Refreshed");
        sampleEvent.setEventFired(true);
    }
    */
    }
    public void checkAdmin(){
        Session session = sessionFactory.openSession();
        //  boolean emailFound=checkEmail(email);
        // String msg="";
        session.beginTransaction();
        //System.out.println(Password);
        Query q = session.createQuery("select admin from User where admin=1");
        List list = q.getResultList();
        System.out.println(list);
        if ((list == null) || (list.size() == 0)) {
            addAdmin();
        }

    }
    public void addAdmin(){
        long millis=System.currentTimeMillis();
        java.sql.Date dt = new java.sql.Date(millis);
        String pass="admin@123";
        User user=new User();
        user.setLastupdated(dt);
        user.setDatecreated(dt);
        user.setForgotpassid(Registration.randomAlphaNumeric(20));
        user.setActive(true);
        user.setPassword_(pass);
        user.setAdmin(true);
        user.setUsername("Admin");
        user.setEmail("LinkSharing17@gmail.com");
        user.setFirstname("Admin");
        user.setLastname("LinkSharing");

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //System.out.println(user );
        session.save(user);
        session.getTransaction().commit();
        session.close();

    }
}

