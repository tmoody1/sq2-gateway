package com.ravn.bookshop;

import java.io.Serializable;

public class Book implements Serializable {
private String title;
private String author;
private String publishDate;
private String isbn;

    public Book(){}

    public Book(String title, String author, String publishDate, String isbn) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
