package ru.zuykin.mandarinegroup.etc;

import java.util.Arrays;

public class AuthorData {
    private String name;
    private String tags;
    private String description;
    private byte[] avatar;
    private byte[] header;
    private String qiwiWallet;
    private String cardNumber;
    private String cardName;
    private String cardDate;
    private Integer cardCvv;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public byte[] getHeader() {
        return header;
    }

    public void setHeader(byte[] header) {
        this.header = header;
    }

    public String getQiwiWallet() {
        return qiwiWallet;
    }

    public void setQiwiWallet(String qiwiWallet) {
        this.qiwiWallet = qiwiWallet;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardDate() {
        return cardDate;
    }

    public void setCardDate(String cardDate) {
        this.cardDate = cardDate;
    }

    public Integer getCardCvv() {
        return cardCvv;
    }

    public void setCardCvv(Integer cardCvv) {
        this.cardCvv = cardCvv;
    }

    // Другие поля, геттеры и сеттеры

    @Override
    public String toString() {
        return "AuthorData{" +
                "name='" + name + '\'' +
                ", tags='" + tags + '\'' +
                ", description='" + description + '\'' +
                ", avatar=" + Arrays.toString(avatar) +
                ", header=" + Arrays.toString(header) +
                ", qiwiWallet='" + qiwiWallet + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardName='" + cardName + '\'' +
                ", cardDate='" + cardDate + '\'' +
                ", cardCvv=" + cardCvv +
                // Другие поля
                '}';
    }
}

