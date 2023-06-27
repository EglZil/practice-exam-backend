package lt.techin.exam.employees;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lt.techin.exam.employees.EmployeeMapper.toEmployee;
import static lt.techin.exam.employees.EmployeeMapper.toEmployeeDto;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    public Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<EmployeeEntityDto> getEmployees() {
        return employeeService.getAll().stream().map(EmployeeMapper::toEmployeeEntityDto).collect(toList());
    }

    @GetMapping(value = "/{employeeId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Employee> getEmployee(@PathVariable Long employeeId) {
        var employeeOptional = employeeService.getById(employeeId);

        var responseEntity = employeeOptional.map(employee -> ok(employee)).orElseGet(() -> ResponseEntity.notFound().build());

        return responseEntity;
    }

    @PostMapping(value="/create", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        var createdEmployee = employeeService.create(toEmployee(employeeDto));
        return ok(toEmployeeDto(createdEmployee));
    }

    @PatchMapping(value = "/update/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long employeeId, @RequestBody EmployeeDto employeeDto) {
        var updatedEmployee = employeeService.updateEmployee(employeeId, toEmployee(employeeDto));
        return ok(toEmployeeDto(updatedEmployee));
    }

    @DeleteMapping(value = "/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long employeeId) {
        var isDeleted = employeeService.deleteById(employeeId);
        return ok(isDeleted);
    }
}
