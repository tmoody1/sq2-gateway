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
        final Review[] reviews = restTemplate.getForObject("http://review:8080/reviewsForIsbn/"+bookId, Review[].class);
        if (reviews != null) {
            return Arrays.asList(reviews);
        }
        else {
            return Collections.emptyList();
        }
    }

    public void like(String id) {
        restTemplate.put("http://review:8080/reviews/"+id+"/like", null);
    }
}
