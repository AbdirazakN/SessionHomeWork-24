package java8.service.impl;

import java8.service.CarService;
import java8.classes.Car;
import java8.classes.Person;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {
    private ArrayList car = new ArrayList();

    @Override
    public String createCar(List<Car> cars) {
        this.car.addAll(cars);
        return "       Cars CREATED successfully!";
    }

    @Override
    public String removeCar(String name, List<Car> cars) {
        for (Car car : cars) {
            if (car.getName().equals(name)) {
                this.car.remove(car);
            }
        }
        return "       The car REMOVED successfully";
    }

    @Override
    public List<Car> getAll() {
        return car;
    }

    @Override
    public List<Person> findByName(String name, List<Person> people) {
        List<Person> resulSearch = new ArrayList<>();
        for (Person person : people) {
            if (person.getName().equals(name)) {
                resulSearch.add(person);
            }
        }
        return resulSearch;
    }

    @Override
    public List<Car> findByCountry(String name, List<Person> people) {
        List<Car> resulSearch = new ArrayList<>();
        for (Person person : people) {
            for (Car personCar : person.getCars()) {
                if (personCar.getCountryOfOrigin().name().equals(name.toUpperCase())) {
                    resulSearch.add(personCar);
                }
            }
        }
        return resulSearch;
    }
}
