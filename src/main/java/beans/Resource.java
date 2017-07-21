package beans;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Prashant on 20-Jul-17.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS )
abstract class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int rId;
    private String description;
    // private User createdBy ;
    //private Topic topic;
    private Date dateCreated;
    private Date lastupdated;

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    private User user;
    @ManyToOne
    private Topic topic;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(Date lastupdated) {
        this.lastupdated = lastupdated;
    }



}