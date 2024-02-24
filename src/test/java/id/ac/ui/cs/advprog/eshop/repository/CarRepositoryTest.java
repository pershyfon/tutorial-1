package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CarRepositoryTest {

    @InjectMocks
    CarRepository carRepository;
    @BeforeEach
    void setUp() {
    }
    @Test
    void testCreateAndFind() {
        Car car = new Car();
        car.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car.setCarName("Mercidis");
        car.setCarColor("black");
        car.setCarQuantity(100);
        carRepository.create(car);

        Iterator<Car> carIterator = carRepository.findAll();
        assertTrue(carIterator.hasNext());
        Car savedCar = carIterator.next();
        assertEquals(car.getCarId(), savedCar.getCarId());
        assertEquals(car.getCarName(), savedCar.getCarName());
        assertEquals(car.getCarColor(), savedCar.getCarColor());
        assertEquals(car.getCarQuantity(), savedCar.getCarQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Car> carIterator = carRepository.findAll();
        assertFalse(carIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Car car1 = new Car();
        car1.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car1.setCarName("Mercidis");
        car1.setCarColor("black");
        car1.setCarQuantity(100);
        carRepository.create(car1);

        Car car2 = new Car();
        car2.setCarId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        car2.setCarName("Lexis");
        car2.setCarColor("white");
        car2.setCarQuantity(50);
        carRepository.create(car2);

        Iterator<Car> carIterator = carRepository.findAll();
        assertTrue(carIterator.hasNext());
        Car savedCar = carIterator.next();
        assertEquals(car1.getCarId(), savedCar.getCarId());
        savedCar = carIterator.next();
        assertEquals(car2.getCarId(), savedCar.getCarId());
        assertFalse(carIterator.hasNext());
    }

    @Test
    void testFindById() {
        Car car = new Car();
        car.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car.setCarName("Mercidis");
        car.setCarColor("black");
        car.setCarQuantity(100);
        carRepository.create(car);

        Car foundCar = carRepository.findById("eb558e9f-1c39-460e-8860-71af6af63bd6");
        assertEquals(car.getCarId(), foundCar.getCarId());
        assertEquals(car.getCarName(), foundCar.getCarName());
        assertEquals(car.getCarColor(), foundCar.getCarColor());
        assertEquals(car.getCarQuantity(), foundCar.getCarQuantity());
    }

    @Test
    void testFindByIdIfMoreThanOneProduct() {
        Car car1 = new Car();
        car1.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car1.setCarName("Mercidis");
        car1.setCarColor("black");
        car1.setCarQuantity(100);
        carRepository.create(car1);

        Car car2 = new Car();
        car2.setCarId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        car2.setCarName("Lexis");
        car2.setCarColor("white");
        car2.setCarQuantity(50);
        carRepository.create(car2);

        Car foundCar = carRepository.findById("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        assertEquals(car2.getCarId(), foundCar.getCarId());
        assertEquals(car2.getCarName(), foundCar.getCarName());
        assertEquals(car2.getCarColor(), foundCar.getCarColor());
        assertEquals(car2.getCarQuantity(), foundCar.getCarQuantity());
    }

    @Test
    void testFindByIdIfDoesNotExist() {
        Car car1 = new Car();
        car1.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car1.setCarName("Mercidis");
        car1.setCarColor("black");
        car1.setCarQuantity(100);
        carRepository.create(car1);

        Car car2 = new Car();
        car2.setCarId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        car2.setCarName("Lexis");
        car2.setCarColor("white");
        car2.setCarQuantity(50);
        carRepository.create(car2);

        String randomId = UUID.randomUUID().toString();

        Car foundCar = carRepository.findById(randomId);
        assertNull(foundCar);
    }

    @Test
    void testFindByIdIfEmpty() {
        String randomId = UUID.randomUUID().toString();

        Car findById = carRepository.findById(randomId);
        assertNull(findById);
    }

    @Test
    void testUpdateCar() {
        Car car = new Car();
        car.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car.setCarName("Mercidis");
        car.setCarColor("black");
        car.setCarQuantity(100);
        carRepository.create(car);

        Car editedCar = new Car();
        editedCar.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        editedCar.setCarName("Lexis");
        editedCar.setCarColor("white");
        editedCar.setCarQuantity(50);
        Car foundCar = carRepository.update(editedCar.getCarId(), editedCar);

        assertEquals(editedCar.getCarId(), foundCar.getCarId());
        assertEquals(editedCar.getCarName(), foundCar.getCarName());
        assertEquals(editedCar.getCarColor(), foundCar.getCarColor());
        assertEquals(editedCar.getCarQuantity(), foundCar.getCarQuantity());
    }

    @Test
    void testUpdateCarNotFound() {
        Car car1 = new Car();
        car1.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car1.setCarName("Mercidis");
        car1.setCarColor("black");
        car1.setCarQuantity(100);
        carRepository.create(car1);

        Car car2 = new Car();
        car2.setCarId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        car2.setCarName("Lexis");
        car2.setCarColor("white");
        car2.setCarQuantity(50);
        carRepository.create(car2);

        Car updatedCar = new Car();
        updatedCar.setCarId(UUID.randomUUID().toString());
        updatedCar.setCarName("Ferirri");
        updatedCar.setCarColor("red");
        updatedCar.setCarQuantity(0);
        Car foundCar = carRepository.update(updatedCar.getCarId(), updatedCar);
        assertNull(foundCar);
    }

    @Test
    void testDeleteCar() {
        Car car1 = new Car();
        car1.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car1.setCarName("Mercidis");
        car1.setCarColor("black");
        car1.setCarQuantity(100);
        carRepository.create(car1);

        carRepository.delete(car1.getCarId());

        assertFalse(carRepository.findAll().hasNext());
    }
}