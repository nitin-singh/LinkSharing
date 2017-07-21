package dao;

import beans.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Query;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

/**
 * Created by Prashant on 17-Jul-17.
 */
public class TopicImplement implements TopicDao {
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public String addTopic(Topic topic,User user){
        long millis=System.currentTimeMillis();
        Date dt = new Date(millis);
        String msg="Already Created";
        boolean flag=true;
        //   List<User> user=user;
            //msg="Created Topic Success";
            topic.setDataCreated(dt);
            topic.setLastUpdated(dt);
            topic.setUser(user);
           // topic.setVisibility(Visibility.private2);*/
           flag=checkTopic(topic,user.getUserid());
            if(flag==true) {
                Session session = sessionFactory.openSession();
                session.beginTransaction();
                session.save(topic);
                session.getTransaction().commit();
                session.close();
                msg="Created Topic Success";
            }


       /* }*/
        return msg;
}

public boolean checkTopic(Topic topic,int userid){
        boolean flag=true;
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    System.out.println(topic.gettopicname());

    String topicName=topic.gettopicname();
    Query query = session.createQuery(" from Topic where user_userid=? AND topicname=?");
    query.setParameter(0,userid);
    query.setParameter(1,topicName);
    List list = query.getResultList();

    if ((list != null) && (list.size() > 0)) {
        System.out.println("hello1");
        flag=false;
    }
    session.getTransaction().commit();
    session.close();

    return flag;

}
@Override
public List<String> displayTopicDropDown(int userid){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    System.out.println("hellofrom ");
    Query query = session.createQuery("SELECT distinct( t.topicname) FROM Topic t,Subscription sub where sub.user = t.user AND sub.user ="+userid);


    List<String> list = query.getResultList();
    System.out.println(list);
    session.getTransaction().commit();
    session.close();
return list;

}
@Override
    public void addDocument(String path,String description,int id ,User userId){
    long millis=System.currentTimeMillis();
    java.sql.Date dt = new java.sql.Date(millis);
    System.out.println("documentAdd");
    //    int id=topicId(topic);
  //  System.out.println("called topic id= "+id);
        Topic topicObj= new Topic();
    System.out.println("documentAdd1");
        topicObj.setId(id);
    System.out.println("documentAdd2");
        DocumentResource docObj=new DocumentResource();
        Session session = sessionFactory.openSession();
    System.out.println("documentAdd3"+docObj);
        session.beginTransaction();
        docObj.setFilepath(path);
        docObj.setTopic(topicObj);
        docObj.setDateCreated(dt);
        docObj.setLastupdated(dt);
        docObj.setDescription(description);
        docObj.setUser(userId);
     System.out.println("documentAdd"+docObj);

        session.save(docObj);
        session.getTransaction().commit();
        session.close();

}
@Override
    public int topicId(String topic){
        System.out.println("topic "+topic);
        int id=0;
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("Select tId from Topic where topicname=?");
        query.setParameter(0,topic);
        List list = query.getResultList();
//        System.out.println("list= "+list.get(0));

//        if ((list != null) && (list.size() > 0)) {
            System.out.println("in if");
            id=(Integer)list.get(0);
//        }
    System.out.println("ID=" +id);
        session.getTransaction().commit();
        session.close();
        System.out.println("ID= "+id);
        return id;
    }

    @Override
    public void addLink(String link,String description,int id ,User userId){
        long millis=System.currentTimeMillis();
        java.sql.Date dt = new java.sql.Date(millis);
        System.out.println("documentAdd");

        Topic topicObj= new Topic();
        //System.out.println("documentAdd1");
        topicObj.setId(id);
        //System.out.println("documentAdd2");
        LinkResource linkObj=new LinkResource();
        Session session = sessionFactory.openSession();
      //  System.out.println("documentAdd3"+docObj);
        session.beginTransaction();
        linkObj.setTopic(topicObj);
        linkObj.setUser(userId);
        linkObj.setLastupdated(dt);
        linkObj.setDateCreated(dt);
        linkObj.setUrl(link);
        linkObj.setDescription(description);
        System.out.println("documentAdd"+linkObj);
        session.save(linkObj);
        session.getTransaction().commit();
        session.close();

    }

}


