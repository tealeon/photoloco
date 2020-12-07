package at.htl.photoloco.entity;

import at.htl.photoloco.dto.PostDto;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Post extends PanacheEntity {

    public String title;

    public String markdownContent;

    public LocalDateTime dateOfCreation;

    @ManyToOne
    public User author;

    @OneToMany(mappedBy = "post")
    public List<PostComment> comments;

    public Post() {
    }

    public Post(PostDto postDto, String username) {
        this.title = postDto.getTitle();
        this.markdownContent = postDto.getMarkdownContent();
        this.dateOfCreation = postDto.getDateOfCreation();
        this.author = User.find("username", username).firstResult();
    }
}
