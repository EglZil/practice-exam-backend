package lt.techin.exam.services;

import lt.techin.exam.employees.EmployeeEntityDto;
import lt.techin.exam.employees.EmployeeMapper;
import lt.techin.exam.employees.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lt.techin.exam.services.CarServiceMapper.toCarService;
import static lt.techin.exam.services.CarServiceMapper.toCarServiceDto;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/services")
public class CarServiceController {
    public Logger logger = LoggerFactory.getLogger(CarServiceController.class);

    private final CarServiceService carService;

    private final EmployeeService employeeService;

    public CarServiceController(CarServiceService carService, EmployeeService employeeService) {
        this.carService = carService;
        this.employeeService = employeeService;
    }


    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CarServiceEntityDto> getCarServices() {
        return carService.getAll().stream().map(CarServiceMapper::toCarServiceEntityDto).collect(toList());
    }

    @GetMapping(value = "/{carServiceId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CarService> getCarServices(@PathVariable Long carServiceId) {
        var carServiceOptional = carService.getById(carServiceId);

        var responseEntity = carServiceOptional.map(service -> ok(service)).orElseGet(() -> ResponseEntity.notFound().build());

        return responseEntity;
    }

    @PostMapping(value="/create", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CarServiceDto> createCarService(@RequestBody CarServiceDto carServiceDto) {
        var createdCarService = carService.create(toCarService(carServiceDto));
        return ok(toCarServiceDto(createdCarService));
    }

    @PatchMapping(value = "/update/{carServiceId}")
    public ResponseEntity<CarServiceDto> updateCarService(@PathVariable Long carServiceId, @RequestBody CarServiceDto carServiceDto) {
        var updatedCadService = carService.updateCarService(carServiceId, toCarService(carServiceDto));
        return ok(toCarServiceDto(updatedCadService));
    }

    @DeleteMapping(value = "/{carServiceId}")
    public ResponseEntity<Boolean> deleteCarService(@PathVariable Long carServiceId) {
        var isDeleted = carService.deleteById(carServiceId);
        return ok(isDeleted);
    }

    @GetMapping(value = "/employees/{carServiceId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<EmployeeEntityDto> getEmployeesByCarService(@PathVariable Long carServiceId) {
        return employeeService.getAllByCarServiceId(carServiceId).stream().map(EmployeeMapper::toEmployeeEntityDto).collect(toList());
    }
}
