package com.ravn.bookshop;

import com.ravn.bookshop.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class ReviewClient {


    @Autowired
    public RestTemplate restTemplate;

    public List<Review> getReviews(String bookId){
        final Review[] reviews = restTemplate.getForObject("http://localhost:9090/reviews/"+bookId, Review[].class);
        if (reviews != null) {
            return Arrays.asList(reviews);
        }
        else {
            return Collections.emptyList();
        }
    }
}
