package com.ravn.bookshop;

import com.ravn.bookshop.model.Book;
import com.ravn.bookshop.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BookClient {


    @Autowired
    public RestTemplate restTemplate;

    public List<Book> getBooks(){
        final Book[] books = restTemplate.getForObject("http://books:8080/books/", Book[].class);
        if (books != null) {
            return Arrays.asList(books);
        }
        else {
            return Collections.emptyList();
        }
    }

    public void like(String id) {
    }
}
