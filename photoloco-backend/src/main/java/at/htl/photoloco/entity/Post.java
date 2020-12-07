package at.htl.photoloco.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Post extends PanacheEntity {

    public String title;

    public String markdownContent;

    public LocalDate dateOfCreation;

    @ManyToOne
    public User author;

    @OneToMany(mappedBy = "post")
    public List<PostComment> comments;

    public Post() {
    }
}
