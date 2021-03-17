package at.htl.photoloco.entity;

import at.htl.photoloco.dto.PostDto;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Post extends PanacheEntity {

    public String title;

    public String markdownContent;

    public LocalDateTime dateOfCreation;

    @ManyToOne
    @JsonbTransient
    public User author;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    public List<PostComment> comments = new LinkedList<>();

    public Post() {
    }

    public Post(PostDto postDto, String username) {
        this.title = postDto.getTitle();
        this.markdownContent = postDto.getMarkdownContent();
        this.dateOfCreation = postDto.getDateOfCreation();
        this.author = User.find("username", username).firstResult();
    }

    public void update(PostDto updatedPost) {
        this.title = updatedPost.getTitle();
        this.markdownContent = updatedPost.getMarkdownContent();
    }
}
