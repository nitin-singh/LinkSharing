package dao;

import beans.Subscription;
import beans.Topic;
import beans.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import services.Registration;

import javax.persistence.Query;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Prashant on 09-Jul-17.
 */
@Repository
public class UserImplement implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public String addUser(User user) {
       String valid="Not Valid";
       /* DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
     */
        long millis=System.currentTimeMillis();
        java.sql.Date dt = new java.sql.Date(millis);
       String paswd=user.getPassword_();
        try {
            user.setPassword_(new Registration().encrypt(paswd));
            user.setForgotpassid(Registration.randomAlphaNumeric(20));
        }
        catch(Exception e){
        e.printStackTrace();
            }
         boolean result=checkEmailUser(user.getEmail(),user.getUsername());

        user.setActive(true);
        user.setLastupdated(dt);
        user.setDatecreated(dt);
        user.setAdmin(false);
        if(result==false) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            //System.out.println(user );
            session.save(user);
            session.getTransaction().commit();
            session.close();
            valid="valid";
        }
        return valid;
    }
/*

    @SuppressWarnings("unchecked")
    @Override
    public List<User> listUsers() {
        Session session = sessionFactory.openSession();
        List<User> userList= session.createQuery(" User ").list();
        session.close();
        return userList;
    }
*/


    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        session.update(user);
        session.close();
     }

    @Override
    public void deleteUser(String email ) {
        Session session = sessionFactory.openSession();
        User user= (User) session.load(User.class, email);
        session.delete(user);
        session.close();
       }

       @Override
       public void searchAdmin(){
           Session session = sessionFactory.openSession();
           List<User> userList = new ArrayList<>();
           Query query= session.createQuery("from user");
           userList=query.getResultList();
           session.close();

       }

       @Override
    public boolean checkLogin(String Username, String Password){
           System.out.println("In Check login");
           Session session = sessionFactory.openSession();
           boolean userFound = false;
           //Query using Hibernate Query Language
           //String SQL_QUERY ="from User where username=?";

           session.beginTransaction();
           //System.out.println(Password);
           Query query = session.createQuery("select password_ from User  where username=? OR email=?");
           query.setParameter(0,Username);
           query.setParameter(1,Username);
           List list = query.getResultList();
           if ((list != null) && (list.size() > 0)) {
               String p = list.get(0).toString();
               String dec = new Registration().decrypt(p);
               if(dec.equals(Password))
               {
                   System.out.println("scuess");
                   userFound= true;
               }
            }
          session.getTransaction().commit();
           session.close();
           return userFound;
       }

       @Override
    public boolean checkEmailUser(String email,String username){
           Session session = sessionFactory.openSession();
           boolean userFound = false;
           session.beginTransaction();
           //System.out.println(Password);
           Query query = session.createQuery("from User where email=? OR username=?");
           query.setParameter(0,email);
           query.setParameter(1,username);
           List<User> beans = null;
           List list = query.getResultList();

           if ((list != null) && (list.size() > 0)) {
                   userFound= true;
               // User user=null;
               // new User().setFirstname(list.get(0));
               }
           session.getTransaction().commit();
           session.close();
               return userFound;

        }
        @Override
         public  String checkEmail(String email){
            Session session = sessionFactory.openSession();
            String value="false";
//            String msg="Email does not exists";
            session.beginTransaction();
            //System.out.println(Password);
            Query query = session.createQuery("from User where email=?");
            query.setParameter(0,email);
            List list = query.getResultList();

            if ((list != null) && (list.size() > 0)) {
               value=getid(email);
            }
            session.getTransaction().commit();
            session.close();
            return value;
        }

@Override
public String getid(String email){
    String pass=null;
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    Query query = session.createQuery("select forgotpassid from User where email=?");
    query.setParameter(0,email);
    List rows = query.getResultList();
    pass=rows.get(0).toString();
    session.getTransaction().commit();
    session.close();
    return pass;
         }
        @Override
    public String changePassword(String id,String password){
            Session session = sessionFactory.openSession();
          //  boolean emailFound=checkEmail(email);
            String msg="Password can not be updated";
                session.beginTransaction();
                //System.out.println(Password);
               Query q = session.createQuery("update User set password_=:pass where forgotpassid=:id");
               try {
                   q.setParameter("pass", new Registration().encrypt(password));
                   q.setParameter("id", id);
               }
               catch (Exception e){
                   e.getMessage();
               }
                q.executeUpdate();
               msg="Password Updated Successfully";
            session.getTransaction().commit();
            session.close();
            return msg;
        }

        @Override
        public void checkAdmin(){
            Session session = sessionFactory.openSession();
            //  boolean emailFound=checkEmail(email);
           // String msg="";
            session.beginTransaction();
            //System.out.println(Password);
            Query q = session.createQuery("select admin from User where admin=1");
            List list = q.getResultList();

            if ((list == null) && (list.size() == 0)) {
                addAdmin();
            }
        }
        @Override
        public void addAdmin(){
            long millis=System.currentTimeMillis();
            java.sql.Date dt = new java.sql.Date(millis);
            String pass="admin@123";
            User user=new User();
            user.setLastupdated(dt);
            user.setDatecreated(dt);
            user.setForgotpassid(Registration.randomAlphaNumeric(20));
            user.setActive(true);
            user.setPassword_(new Registration().decrypt(pass));
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

        @Override
    public int getUserID(String Username){

        int id=0;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("select userid from User  where email=? OR username=?");
        query.setParameter(0,Username);
        query.setParameter(1,Username);
        List rows = query.getResultList();
        String Id=rows.get(0).toString();
        id=Integer.parseInt(Id);
        session.getTransaction().commit();
        session.close();
        return id;

    }

    @Override
    public User getUserData(String username){

        Session session = sessionFactory.openSession();
        List<User> userList =  new ArrayList<User>() ;
        session.beginTransaction();

        userList = session.createQuery("from User where username='"+username+"' OR email='"+username+"'").list();
//        Query query= session.createQuery("from User where username=? OR email=?");
//        query.setParameter(0,username);
//        query.setParameter(1,username);
        User u=(User) userList.get(0);

        session.getTransaction().commit();
        session.close();
        return u;
    }
    @Override
    public long countSubscription(User userid){
        System.out.println("hello count= "+userid.getUserid());
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        System.out.println("hello count 1");
        Query query = session.createQuery("Select count(subID) from Subscription where user_userid=?");
        query.setParameter(0,userid.getUserid());
        long count=(Long)query.getResultList().get(0);
        session.getTransaction().commit();
        session.close();
        return count;
    }
    @Override
    public long countTopic(User userid){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("Select count(tid) from Topic where user_userid=?");
        query.setParameter(0,userid.getUserid());
        long count=(Long)query.getResultList().get(0);
        System.out.println("count="+count);
        session.getTransaction().commit();
        session.close();
        return count;
     }

     @Override

     public List subscriptionDisplay(User user){

         Session session = sessionFactory.openSession();
         session.beginTransaction();
         List<Subscription> displaySub;
        // display = session.createQuery("select u.admin,u.username,t.tid,t.topicname,t.visibility,t.user.userid,s.subID,s.seriousness from User u INNER  JOIN Subscription s ON u.userid = s.user.userid INNER  JOIN Topic t ON t.tid=s.topic.tid where u.userid="+user.getUserid()).list();
           //System.out.println(ls.get(0));
         displaySub=session.createQuery("from Subscription").list();
         session.getTransaction().commit();
         session.close();
         return displaySub;
     }

}


