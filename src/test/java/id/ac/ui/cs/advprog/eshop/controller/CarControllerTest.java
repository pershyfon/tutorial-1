package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarControllerTest {

    @Mock
    private CarService carService;

    @Mock
    private Model model;

    @InjectMocks
    private CarController carController;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateCarPage() {
        String expectedViewName = "CreateCar";
        String actualViewName = carController.createCarPage(model);
        assertEquals(expectedViewName, actualViewName);
    }

    @Test
    void testCreateCarPost() {
        Car product = new Car();
        String expectedViewName = "redirect:listCar";
        String actualViewName = carController.createCarPost(product, model);
        assertEquals(expectedViewName, actualViewName);
    }

    @Test
    void testCarListPage() {
        List<Car> productList = new ArrayList<>();
        when(carService.findAll()).thenReturn(productList);

        String expectedViewName = "CarList";
        String actualViewName = carController.carListPage(model);
        assertEquals(expectedViewName, actualViewName);
    }

    @Test
    void testDeleteCar() {
        Car car = new Car();
        String carId = car.getCarId();
        String expectedViewName = "redirect:listCar";
        String actualViewName = carController.deleteCar(carId);
        assertEquals(expectedViewName, actualViewName);
    }

    @Test
    void testEditCarPage() {
        Car car = new Car();
        String carId = car.getCarId();
        when(carService.findById(carId)).thenReturn(car);

        String expectedViewName = "EditCar";
        String actualViewName = carController.editCarPage(carId, model);
        assertEquals(expectedViewName, actualViewName);
    }

    @Test
    void testEditCarList() {
        Car car = new Car();
        String carId = car.getCarId();
        String expectedViewName = "redirect:listCar";
        String actualViewName = carController.editCarPost(car, model);
        assertEquals(expectedViewName, actualViewName);
    }
}
