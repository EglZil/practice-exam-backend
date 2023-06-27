package lt.techin.exam.ratings;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<Rating> getAll() {
        return ratingRepository.findAll();
    }

    public Optional<Rating> getById(Long id) {
        return ratingRepository.findById(id);
    }

    public boolean deleteById(Long id) {
        try {
            ratingRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException exception) {
            return false;
        }
    }

    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating updateRating(Long id, Rating rating) {
        Rating existingRating = ratingRepository.findById(id).orElseThrow();

        existingRating.setEmployee(rating.getEmployee());
        existingRating.setRating(rating.getRating());

        return ratingRepository.save(existingRating);
    }

    public Double getRatingByEmployee(Long employeeId) {
        List<Rating> ratings = ratingRepository.findRatingsByEmployeeId(employeeId);
        double sum = ratings.stream().map(rating -> rating.getRating()).reduce((double) 0, (subtotal, element) -> subtotal + element);
        return sum / ratings.size();
    }
}
