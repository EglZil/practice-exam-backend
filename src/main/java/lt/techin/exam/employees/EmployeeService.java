package lt.techin.exam.employees;

import lt.techin.exam.services.CarServiceRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final CarServiceRepository carServiceRepository;

    public EmployeeService(EmployeeRepository employeeRepository,
                           CarServiceRepository carServiceRepository) {
        this.employeeRepository = employeeRepository;
        this.carServiceRepository = carServiceRepository;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getById(Long id) {
        return employeeRepository.findById(id);
    }

    public boolean deleteById(Long id) {
        try {
            employeeRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException exception) {
            return false;
        }
    }

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow();

        existingEmployee.setName(employee.getName());
        existingEmployee.setSurname(employee.getSurname());
        existingEmployee.setCity(employee.getCity());
        existingEmployee.setManager(employee.getManager());
        existingEmployee.setSpecialization(employee.getSpecialization());
        existingEmployee.setCarService(employee.getCarService());

        return employeeRepository.save(existingEmployee);
    }

    public List<Employee> getAllByCarServiceId(Long carServiceId) {
        return employeeRepository.findEmployeesByCarServiceId(carServiceId);
    }
}
