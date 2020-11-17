package at.htl.photoloco.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.Hibernate;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "POST")
public class Post {

    @Column(name = "POST_ID")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "POST_TITLE")
    public String title;

    @Column(name = "POST_DESCRIPTION")
    public String description;

    @Column(name = "POST_IMG_URL")
    public String imgUrl;

    @Column(name = "POST_UPLOAD_DATE")
    public Date uploadDate;

    @JsonbTransient
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "POST_USR_ID")
    public User user;

    public Post() {
    }

    public Post(Long id, String title, String description, String imgUrl, Date uploadDate, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imgUrl = imgUrl;
        this.uploadDate = uploadDate;
        this.user = user;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", uploadDate=" + uploadDate +
                ", user=" + user +
                '}';
    }



}
