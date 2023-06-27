package lt.techin.exam.services;

public class CarServiceMapper {
    public static CarServiceDto toCarServiceDto(CarService carService) {
        CarServiceDto carServiceDto = new CarServiceDto();

        carServiceDto.setName(carService.getName());
        carServiceDto.setAddress(carService.getAddress());
        carServiceDto.setEmployees(carService.getEmployees());

        return carServiceDto;
    }

    public static CarServiceEntityDto toCarServiceEntityDto(CarService carService) {
        CarServiceEntityDto carServiceEntityDto = new CarServiceEntityDto();

        carServiceEntityDto.setId(carService.getId());
        carServiceEntityDto.setName(carService.getName());
        carServiceEntityDto.setAddress(carService.getAddress());
        carServiceEntityDto.setEmployees(carService.getEmployees());

        return carServiceEntityDto;
    }

    public static CarService toCarService (CarServiceDto carServiceDto) {
        CarService carService = new CarService();

        carService.setName(carServiceDto.getName());
        carService.setAddress(carServiceDto.getAddress());
        carService.setEmployees(carServiceDto.getEmployees());

        return carService;
    }

    public static CarService toCarServiceFromEntityDto(CarServiceEntityDto carServiceEntityDto) {
        CarService carService = new CarService();

        carService.setId(carServiceEntityDto.getId());
        carService.setName(carServiceEntityDto.getName());
        carService.setAddress(carServiceEntityDto.getAddress());
        carService.setEmployees(carServiceEntityDto.getEmployees());

        return carService;
    }
}
