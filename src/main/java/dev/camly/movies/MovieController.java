package dev.camly.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin("http://localhost:3000/")
public class MovieController {
    @Autowired
    private MovieServices movieServices;
    @GetMapping
    public ResponseEntity<List<Movies>> getAllMovies()
    {
        return new ResponseEntity<List<Movies>>(movieServices.allMovies(), HttpStatus.OK);
    }
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movies>> getSingleMovies(@PathVariable String imdbId)
    {
        return new ResponseEntity<Optional<Movies>>(movieServices.singleMovie(imdbId), HttpStatus.OK);
    }
}
