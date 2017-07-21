package beans;

import org.hibernate.mapping.Set;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Prashant on 09-Jul-17.
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userid;
    private String email;
    private String username;
    private String password_;
    private String firstname;
    private String lastname;
    @Lob @Basic(fetch = FetchType.LAZY)
    @Column(length=100000)
    private byte[] photo;
    private boolean admin;
    private boolean active;
    private Date datecreated;
    private Date lastupdated;

    @OneToMany(mappedBy = "user")
    private List<Resource> resources;
    private String forgotpassid;


    @OneToMany(targetEntity=Subscription.class,mappedBy = "user")
    private List<Subscription> subscriptions;


    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }


    public Date getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(Date lastupdated) {
        this.lastupdated = lastupdated;
    }




     public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }



    public String getForgotpassid() {
        return forgotpassid;
    }

    public void setForgotpassid(String forgotpassid) {
        this.forgotpassid = forgotpassid;
    }


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }


    public void setPhoto(MultipartFile photo) {

            try{
                this.photo = photo.getBytes();
            }
            catch(Exception e){
            e.printStackTrace();
            }


    }

    public byte[] getPhoto() {
        return photo;
    }




    public String getPassword_() {
        return password_;
    }

    public void setPassword_(String password_) {
        this.password_ = password_;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }





}
