package dev.camly.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin("http://localhost:3000/")
public class ReviewController {
    @Autowired
    private ReviewServices reviewServices;
    @PostMapping()
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload)
    {
        return new ResponseEntity<Review>(reviewServices.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.OK);
    }
}
