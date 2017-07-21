package beans;

import javax.persistence.Entity;

/**
 * Created by Prashant on 19-Jul-17.
 */
@Entity
public class LinkResource extends Resource {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
