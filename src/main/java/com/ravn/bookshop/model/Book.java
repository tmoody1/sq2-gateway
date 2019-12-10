package com.ravn.bookshop.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class Book implements Serializable {
private String title;
private String author;
private String publishDate;
private String isbn;
private List<Review> reviews;
}
