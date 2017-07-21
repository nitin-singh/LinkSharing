package beans;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created by Prashant on 21-Jul-17.
 */
public class ReadingItem {
    @OneToOne
    private Resource resource;

    @OneToOne
    private User user;
    public boolean isRead() {

        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    private boolean isRead;

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
