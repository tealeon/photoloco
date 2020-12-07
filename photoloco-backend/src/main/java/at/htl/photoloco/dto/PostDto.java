package at.htl.photoloco.dto;

import at.htl.photoloco.entity.Post;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PostDto {

    private Long id;

    @NotNull
    @Size(min = 1, max = 255)
    private String title;

    // TODO: Make it longer
    @NotNull
    @Size(min = 1, max = 255)
    private String markdownContent;

    private LocalDateTime dateOfCreation;

    private AuthorDto author;

    private List<PostCommentDto> comments;

    public PostDto() {
        this.dateOfCreation = LocalDateTime.now();
    }

    public PostDto(Post post) {
        this.id = post.id;
        this.title = post.title;
        this.markdownContent = post.markdownContent;
        this.dateOfCreation = post.dateOfCreation;
        this.author = new AuthorDto(post.author);
        this.comments = post.comments.stream().map(PostCommentDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMarkdownContent() {
        return markdownContent;
    }

    public void setMarkdownContent(String markdownContent) {
        this.markdownContent = markdownContent;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public List<PostCommentDto> getComments() {
        return comments;
    }
}
