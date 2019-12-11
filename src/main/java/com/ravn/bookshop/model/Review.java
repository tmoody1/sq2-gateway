package com.ravn.bookshop.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Review implements Serializable {
    private String id;
    private String author;
    private String text;
    private int likes;
    private List<Comment> comments;

}
