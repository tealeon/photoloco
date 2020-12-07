package at.htl.photoloco.dto;

import at.htl.photoloco.entity.User;

public class AuthorDto {

    private Long id;

    private String username;

    public AuthorDto() {
    }

    public AuthorDto(User user) {
        this.id = user.id;
        this.username = user.username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
