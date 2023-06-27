package lt.techin.exam.employees;

import lt.techin.exam.services.CarService;

import java.util.Objects;

public class EmployeeDto {
    private String name;

    private String surname;

    private String city;

    private String specialization;

    private Boolean isManager;

    private CarService carService;

    public EmployeeDto() {
    }

    public EmployeeDto(String name, String surname, String city, String specialization, Boolean isManager, CarService carService) {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.specialization = specialization;
        this.isManager = isManager;
        this.carService = carService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Boolean getManager() {
        return isManager;
    }

    public void setManager(Boolean manager) {
        isManager = manager;
    }

    public CarService getCarService() {
        return carService;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDto that = (EmployeeDto) o;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(city, that.city) && Objects.equals(specialization, that.specialization) && Objects.equals(isManager, that.isManager) && Objects.equals(carService, that.carService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, city, specialization, isManager, carService);
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", city='" + city + '\'' +
                ", specialization='" + specialization + '\'' +
                ", isManager=" + isManager +
                ", carService=" + carService +
                '}';
    }
}
