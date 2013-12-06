package cai.peter.rss.opml.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import java.util.HashSet;
import java.util.Set;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Tag {

    /**
     */
    @ManyToOne
    @JoinColumn(name = "container_id")
    private Tag parent;

    /**
     */
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Tag> tags = new ArrayList<Tag>();

    public void addTag(Tag item) {
        tags.add(item);
    }

    /**
     */
    private String name;

    public Tag(String name) {
        super();
        this.name = name;
    }

    public boolean isRoot() {
        return parent == null;
    }

    public void addOutline(Outline item) {
            	outlines.add(item);
    }

    /**
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tag", fetch=FetchType.EAGER )
    private Set<Outline> outlines = new HashSet<Outline>();
}
