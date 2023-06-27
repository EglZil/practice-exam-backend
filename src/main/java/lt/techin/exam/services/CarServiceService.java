package lt.techin.exam.services;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceService {
    private final CarServiceRepository carServiceRepository;

    public CarServiceService(CarServiceRepository carServiceRepository) {
        this.carServiceRepository = carServiceRepository;
    }

    public List<CarService> getAll() {
        return carServiceRepository.findAll();
    }

    public Optional<CarService> getById(Long id) {
        return carServiceRepository.findById(id);
    }

    public boolean deleteById(Long id) {
        try {
            carServiceRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException exception) {
            return false;
        }
    }

    public CarService create(CarService carService) {
        return carServiceRepository.save(carService);
    }

    public CarService updateCarService(Long id, CarService carService) {
        CarService existingCarService = carServiceRepository.findById(id).orElseThrow();

        existingCarService.setName(carService.getName());
        existingCarService.setAddress(carService.getAddress());
        existingCarService.setEmployees(carService.getEmployees());

        return carServiceRepository.save(existingCarService);
    }
}
