package beans;

import javax.persistence.ManyToOne;

/**
 * Created by Prashant on 21-Jul-17.
 */
public class ResourceRating {
    @ManyToOne
    private Resource resource;
    @ManyToOne
    private User user;

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int score;
}
