package com.softuni.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class CommentEntity extends BaseEntity{

    private Integer score;
    private String textContent;
    private UserEntity author;
    private HomeworkEntity homework;

    public CommentEntity() {
    }

    @Column(name = "score")
    public Integer getScore() {
        return score;
    }

    public CommentEntity setScore(Integer score) {
        this.score = score;
        return this;
    }

    @Column(name = "text_content", columnDefinition = "TEXT")
    public String getTextContent() {
        return textContent;
    }

    public CommentEntity setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    @ManyToOne
    public UserEntity getAuthor() {
        return author;
    }

    public CommentEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    @ManyToOne
    public HomeworkEntity getHomework() {
        return homework;
    }

    public CommentEntity setHomework(HomeworkEntity homework) {
        this.homework = homework;
        return this;
    }
}
