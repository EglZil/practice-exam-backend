package lt.techin.exam.services;

import lt.techin.exam.employees.Employee;

import java.util.Objects;
import java.util.Set;

public class CarServiceEntityDto extends CarServiceDto{
    private Long id;

    public CarServiceEntityDto() {
    }

    public CarServiceEntityDto(String name, String address, Set<Employee> employees, Long id) {
        super(name, address, employees);
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
        CarServiceEntityDto that = (CarServiceEntityDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "CarServiceEntityDto{" +
                "id=" + id +
                '}';
    }
}
