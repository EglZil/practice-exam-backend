package lt.techin.exam.ratings;

import lt.techin.exam.employees.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lt.techin.exam.employees.EmployeeMapper.toEmployee;
import static lt.techin.exam.employees.EmployeeMapper.toEmployeeDto;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("api/v1/ratings")
public class RatingController {
    private final RatingService ratingService;

    public RatingController(RatingService employeeService) {
        this.ratingService = employeeService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Rating> getRatings() {
        return ratingService.getAll();
    }

    @GetMapping(value = "/{ratingId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Rating> getRating(@PathVariable Long ratingId) {
        var ratingOptional = ratingService.getById(ratingId);

        var responseEntity = ratingOptional.map(rating -> ok(rating)).orElseGet(() -> ResponseEntity.notFound().build());

        return responseEntity;
    }

    @PostMapping(value="/create", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        var createdRating = ratingService.create(rating);
        return ok(createdRating);
    }

    @PatchMapping(value = "/update/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable Long ratingId, @RequestBody Rating rating) {
        var updatedRating = ratingService.updateRating(ratingId,rating);
        return ok(updatedRating);
    }

    @DeleteMapping(value = "/{ratingId}")
    public ResponseEntity<Boolean> deleteRating(@PathVariable Long ratingId) {
        var isDeleted = ratingService.deleteById(ratingId);
        return ok(isDeleted);
    }
}
