package cai.peter.rss.opml.model;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Outline {

    /**
     */
    private String title;

    /**
     */
    private String url;

    public Outline(String title, String url) {
        super();
        this.title = title;
        this.url = url;
    }

    /**
     */
    @ManyToOne
    private Tag tag;
}
