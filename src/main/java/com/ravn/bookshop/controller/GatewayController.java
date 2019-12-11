package com.ravn.bookshop.controller;

import com.ravn.bookshop.ReviewClient;
import com.ravn.bookshop.model.Book;
import com.ravn.bookshop.model.Comment;
import com.ravn.bookshop.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@EnableAutoConfiguration

public class GatewayController {

    @Autowired
    private ReviewClient reviewClient;

    @RequestMapping("/books")
    @CrossOrigin
    public List<Book> allBooks(){
        final List<Comment> comments1 = Arrays.asList(Comment.builder().author("me").id("1").text("great!").build(),
                Comment.builder().author("you").id("2").text("horrible").build());
        final List<Review> reviews = Collections.singletonList(Review.builder().author("me").id("34").likes(99).text("best book").comments(comments1).build())  ;

        return Arrays.asList(
                Book.builder().title("title").author("author").publishDate("today").isbn("123").reviews(reviews).build(),
                Book.builder().title("day").author("author").publishDate("2018-01-21").isbn("283").reviews(Collections.emptyList()).build());
    }


    @RequestMapping("/books/{id}/reviews")
    public List<Review> reviewsForBook(@PathVariable String id) {
        return reviewClient.getReviews("123");
    }


    @PostMapping("/review/{id}/comment")
    public Comment commentForReview(@PathVariable String id, Comment comment) {
        return comment;
    }

    @PutMapping("/review/{id}/like")
    public void likeForReview(@PathVariable String id) {
        reviewClient.like(id);
    }


}
