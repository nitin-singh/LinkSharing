package beans;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int tid;
    private String topicname;

    @ManyToOne(targetEntity=User.class)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /*  @Column(name="createdBy")
            private User createdBy;
        */
    private Date dataCreated;
    private Date lastUpdated;




    @OneToMany(mappedBy = "topic")
    private List<Subscription >subscription;

    public List<Subscription> getSubscription() {
        return subscription;
    }

    public void setSubscription(List<Subscription> subscription) {
        this.subscription = subscription;
    }

    @OneToMany(mappedBy = "topic")
    private List<Resource> resources;

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    @Enumerated(EnumType.STRING)
    private Visibility visibility;

      /* private User user;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }*/



    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

  /*  private User user;
    @ManyToOne(cascade=CascadeType.ALL)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }*/

   /* public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }*/

    public int getId() {
        return tid;
    }

    public void setId(int id) {
        this.tid= id;
    }

    public String gettopicname() {
        return topicname;
    }

    public void settopicname(String name) {
        this.topicname = name;
    }



    public Date getDataCreated() {
        return dataCreated;
    }

    public void setDataCreated(Date dataCreated) {
        this.dataCreated = dataCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }



}
