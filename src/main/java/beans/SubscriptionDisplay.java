package beans;

/**
 * Created by Prashant on 21-Jul-17.
 */
public class SubscriptionDisplay {

    private boolean admin;
    private String  username;
    private int tid;
    private String topicname;
    private String  visibility;
    private int user_userid;
    private int subid;
    private String seriousness;

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public int getUser_userid() {
        return user_userid;
    }

    public void setUser_userid(int user_userid) {
        this.user_userid = user_userid;
    }

    public int getSubid() {
        return subid;
    }

    public void setSubid(int subid) {
        this.subid = subid;
    }

    public String getSeriousness() {
        return seriousness;
    }

    public void setSeriousness(String seriousness) {
        this.seriousness = seriousness;
    }





}
