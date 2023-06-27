package lt.techin.exam.employees;

public class EmployeeMapper {
    public static EmployeeDto toEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setName(employee.getName());
        employeeDto.setSurname(employee.getSurname());
        employeeDto.setCity(employee.getCity());
        employeeDto.setSpecialization(employee.getSpecialization());
        employeeDto.setManager(employee.getManager());
        employeeDto.setCarService(employee.getCarService());

        return employeeDto;
    }

    public static EmployeeEntityDto toEmployeeEntityDto(Employee employee) {
        EmployeeEntityDto employeeEntityDto = new EmployeeEntityDto();

        employeeEntityDto.setId(employee.getId());
        employeeEntityDto.setName(employee.getName());
        employeeEntityDto.setSurname(employee.getSurname());
        employeeEntityDto.setCity(employee.getCity());
        employeeEntityDto.setSpecialization(employee.getSpecialization());
        employeeEntityDto.setManager(employee.getManager());
        employeeEntityDto.setCarService(employee.getCarService());

        return employeeEntityDto;
    }

    public static Employee toEmployee (EmployeeDto employeeDto) {
        Employee employee = new Employee();

        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());
        employee.setCity(employeeDto.getCity());
        employee.setSpecialization(employeeDto.getSpecialization());
        employee.setManager(employeeDto.getManager());
        employee.setCarService(employeeDto.getCarService());

        return employee;
    }

    public static Employee toEmployeeFromEntityDto(EmployeeEntityDto employeeEntityDto) {
        Employee employee = new Employee();

        employee.setId(employeeEntityDto.getId());
        employee.setName(employeeEntityDto.getName());
        employee.setSurname(employeeEntityDto.getSurname());
        employee.setCity(employeeEntityDto.getCity());
        employee.setSpecialization(employee.getSpecialization());
        employee.setManager(employeeEntityDto.getManager());
        employee.setCarService(employeeEntityDto.getCarService());

        return employee;
    }
}
