package com.example.mynews;

public class News {
    public String title,author,newUrl,newUrlImage,newContent;

    public News(String title, String author, String newUrl, String newUrlImage, String newContent) {
        this.title = title;
        this.author = author;
        this.newUrl = newUrl;
        this.newUrlImage = newUrlImage;
        this.newContent = newContent;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getNewUrl() {
        return newUrl;
    }

    public String getNewUrlImage() {
        return newUrlImage;
    }

    public String getNewContent() {
        return newContent;
    }
}
