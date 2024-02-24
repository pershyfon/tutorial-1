package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.CarRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarServiceImplTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarServiceImpl carService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateCar() {
        Car car = new Car();
        when(carRepository.create(car)).thenReturn(car);

        Car createdCar = carService.create(car);
        assertEquals(car, createdCar);
    }

    @Test
    void testFindAllCars() {
        Car car = new Car();
        when(carRepository.create(car)).thenReturn(car);
        carService.create(car);

        when(carRepository.findAll()).thenReturn(List.of(car).iterator());
        Iterator<Car> foundCars = carService.findAll().iterator();

        assertTrue(foundCars.hasNext());
        Car savedCar = foundCars.next();
        assertEquals(car, savedCar);
    }

    @Test
    void testFindCarById() {
        Car car = new Car();
        String carId = car.getCarId();
        when(carRepository.findById(carId)).thenReturn(car);

        Car foundCar = carService.findById(carId);
        assertEquals(car, foundCar);
    }

    @Test
    void testEditCar() {
        Car car = new Car();
        car.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car.setCarName("Mercidis");
        car.setCarColor("black");
        car.setCarQuantity(100);

        when(carRepository.create(car)).thenReturn(car);
        carService.create(car);

        Car editedCar = new Car();
        editedCar.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        editedCar.setCarName("Lexis");
        editedCar.setCarColor("white");
        editedCar.setCarQuantity(50);
        carService.update("eb558e9f-1c39-460e-8860-71af6af63bd6", editedCar);

        when(carRepository.findById("eb558e9f-1c39-460e-8860-71af6af63bd6")).thenReturn(editedCar);
        Car resultCar = carService.findById("eb558e9f-1c39-460e-8860-71af6af63bd6");

        assertEquals(editedCar, resultCar);
        verify(carRepository).update("eb558e9f-1c39-460e-8860-71af6af63bd6", editedCar);
    }

    @Test
    void testDeleteCar() {
        Car car = new Car();
        car.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car.setCarName("Mercidis");
        car.setCarColor("black");
        car.setCarQuantity(100);

        when(carRepository.create(car)).thenReturn(car);
        carService.create(car);

        carService.deleteCarById("eb558e9f-1c39-460e-8860-71af6af63bd6");

        verify(carRepository).delete("eb558e9f-1c39-460e-8860-71af6af63bd6");
    }
}