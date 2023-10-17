package ru.zuykin.mandarinegroup.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue()
    private Long id;
    private String username;
    private String password;
    private String email;
    private boolean is_author;
    @Column(name = "author_name")
    private String authorName;
    private String author_tags;
    private String author_description;
    private String author_avatar;
    private String author_header;
    private String qiwi_wallet;
    private String card_number;
    private String card_name;
    private String card_date;
    private String card_cvv;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Level> levels;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "follow",
            joinColumns = @JoinColumn(name = "follower_id"),
            inverseJoinColumns = @JoinColumn(name = "following_id")
    )
    private Set<User> following = new HashSet<>();

    @OneToMany(mappedBy = "subscriber")
    private List<Subscribe> subscriptions;


    // Конструкторы, геттеры и сеттеры
    public User(String n, String p, String e){
        this.email = e;
        this.password = p;
        this.username = n;
    }

    public User(){

    }

    public String getPassword(){
        return this.password;
    }

    public String getUsername(){
        return this.username;
    }

    public long getId(){
        return this.id;
    }

    public String getEmail(){
        return this.email;
    }

    public boolean getIs_author() {
        return this.is_author;
    }

    public void setIs_author() {
        this.is_author = true;
    }

    public String getAuthor_name() {
        return this.authorName;
    }

    public void setAuthor_name(String author_name) {
        this.authorName = author_name;
    }

    public String getAuthor_tags() {
        return this.author_tags;
    }

    public void setAuthor_tags(String author_tags) {
        this.author_tags = author_tags;
    }

    public String getAuthor_description() {
        return this.author_description;
    }

    public void setAuthor_description(String author_description) {
        this.author_description = author_description;
    }

    public String getAuthor_avatar() {
        return this.author_avatar;
    }

    public void setAuthor_avatar(String author_avatar) {
        this.author_avatar = author_avatar;
    }

    public String getAuthor_header() {
        return this.author_header;
    }

    public void setAuthor_header(String author_header) {
        this.author_header = author_header;
    }

    public String getQiwi_wallet() {
        return this.qiwi_wallet;
    }

    public void setQiwi_wallet(String qiwi_wallet) {
        this.qiwi_wallet = qiwi_wallet;
    }

    public String getCard_number() {
        return this.card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getCard_name() {
        return this.card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public String getCard_date() {
        return this.card_date;
    }

    public void setCard_date(String card_date) {
        this.card_date = card_date;
    }

    public String getCard_cvv() {
        return this.card_cvv;
    }

    public void setCard_cvv(String card_cvv) {
        this.card_cvv = card_cvv;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Set<User> getFollowing() {
        return following;
    }

    public void setFollowing(Set<User> following) {
        this.following = following;
    }

    public List<Subscribe> getSubscriptions() {
        return subscriptions;
    }
}
