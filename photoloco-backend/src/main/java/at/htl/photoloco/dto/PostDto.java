package at.htl.photoloco.dto;

import at.htl.photoloco.entity.Post;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PostDto {

    private Long id;

    private String title;

    private String markdownContent;

    private LocalDate dateOfCreation;

    private AuthorDto author;

    private List<PostCommentDto> comments;

    public PostDto() {
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

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    public List<PostCommentDto> getComments() {
        return comments;
    }

    public void setComments(List<PostCommentDto> comments) {
        this.comments = comments;
    }
}
