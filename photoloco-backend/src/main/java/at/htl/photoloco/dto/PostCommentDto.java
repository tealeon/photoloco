package at.htl.photoloco.dto;

import at.htl.photoloco.entity.PostComment;

import java.util.List;
import java.util.stream.Collectors;

public class PostCommentDto {

    private Long id;

    private String content;

    private AuthorDto author;

    private List<PostCommentDto> replies;

    private List<PostCommentRatingDto> ratings;

    public PostCommentDto() {
    }

    public PostCommentDto(PostComment postComment) {
        this.id = postComment.id;
        this.content = postComment.content;
        this.author = new AuthorDto(postComment.author);
        this.replies = postComment.replies.stream().map(PostCommentDto::new).collect(Collectors.toList());
        this.ratings = postComment.ratings.stream().map(PostCommentRatingDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    public List<PostCommentDto> getReplies() {
        return replies;
    }

    public void setReplies(List<PostCommentDto> replies) {
        this.replies = replies;
    }

    public List<PostCommentRatingDto> getRatings() {
        return ratings;
    }

    public void setRatings(List<PostCommentRatingDto> ratings) {
        this.ratings = ratings;
    }
}
