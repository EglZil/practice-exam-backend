package lt.techin.exam.services;

import lt.techin.exam.employees.Employee;

import java.util.Objects;
import java.util.Set;

public class CarServiceDto {
    private String name;

    private String address;

    private Set<Employee> employees;

    public CarServiceDto() {
    }

    public CarServiceDto(String name, String address, Set<Employee> employees) {
        this.name = name;
        this.address = address;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarServiceDto that = (CarServiceDto) o;
        return Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, employees);
    }

    @Override
    public String toString() {
        return "CarServiceDto{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", employees=" + employees +
                '}';
    }
}
