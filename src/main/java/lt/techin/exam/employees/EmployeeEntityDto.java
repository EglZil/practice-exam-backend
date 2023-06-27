package lt.techin.exam.employees;

import lt.techin.exam.services.CarService;

import java.util.Objects;

public class EmployeeEntityDto extends EmployeeDto{
    private Long id;

    public EmployeeEntityDto() {
    }

    public EmployeeEntityDto(String name, String surname, String city, String specialization, Boolean isManager, CarService carService, Long id) {
        super(name, surname, city, specialization, isManager, carService);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EmployeeEntityDto that = (EmployeeEntityDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "EmployeeEntityDto{" +
                "id=" + id +
                '}';
    }
}
