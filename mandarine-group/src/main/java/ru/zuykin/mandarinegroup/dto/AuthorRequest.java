package ru.zuykin.mandarinegroup.dto;

public class AuthorRequest {
    private boolean is_author;
    private String author_name;
    private String author_tags;
    private String author_description;
    private String author_avatar;
    private String author_header;
    private String qiwi_wallet;
    private String card_number;
    private String card_name;
    private String card_date;
    private String card_cvv;

    public boolean isIs_author() {
        return is_author;
    }

    public void setIs_author(boolean is_author) {
        this.is_author = is_author;
    }

    public String getAuthor_name() {
        return this.author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_tags() {
        return author_tags;
    }

    public void setAuthor_tags(String author_tags) {
        this.author_tags = author_tags;
    }

    public String getAuthor_description() {
        return author_description;
    }

    public void setAuthor_description(String author_description) {
        this.author_description = author_description;
    }

    public String getAuthor_avatar() {
        return author_avatar;
    }

    public void setAuthor_avatar(String author_avatar) {
        this.author_avatar = author_avatar;
    }

    public String getAuthor_header() {
        return author_header;
    }

    public void setAuthor_header(String author_header) {
        this.author_header = author_header;
    }

    public String getQiwi_wallet() {
        return qiwi_wallet;
    }

    public void setQiwi_wallet(String qiwi_wallet) {
        this.qiwi_wallet = qiwi_wallet;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public String getCard_date() {
        return card_date;
    }

    public void setCard_date(String card_date) {
        this.card_date = card_date;
    }

    public String getCard_cvv() {
        return card_cvv;
    }

    public void setCard_cvv(String card_cvv) {
        this.card_cvv = card_cvv;
    }
}
