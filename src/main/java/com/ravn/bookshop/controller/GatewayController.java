package com.ravn.bookshop.controller;

import com.ravn.bookshop.Book;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@EnableAutoConfiguration

public class GatewayController {

    @RequestMapping("/books")
    public List<Book> getAll(){
        return Arrays.asList(
                new Book("title", "author", "today", "123"),
                new Book("Day", "john", "yesterday", "987" ));
    }
}
