package dao;

import beans.Topic;
import beans.User;

import java.util.List;

/**
 * Created by Prashant on 17-Jul-17.
 */
public interface TopicDao {

    public String addTopic(Topic topic,User userid);
    public List<String> displayTopicDropDown(int userid);
    public void addDocument(String path,String description,int id,User userId);
    public int topicId(String topic);
    public void addLink(String link,String description,int id ,User userId);


}
