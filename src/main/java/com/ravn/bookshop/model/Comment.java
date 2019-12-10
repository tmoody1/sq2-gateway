package com.ravn.bookshop.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class Comment implements Serializable {
    private String id;
    private String author;
    private String text;
}
