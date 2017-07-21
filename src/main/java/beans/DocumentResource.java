package beans;

import javax.persistence.Entity;

/**
 * Created by Prashant on 19-Jul-17.
 */
@Entity
public class DocumentResource extends Resource {
    private String filepath;

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}
