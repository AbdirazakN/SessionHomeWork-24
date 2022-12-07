package java8.service.impl;

import java8.service.PersonService;
import java8.classes.Car;
import java8.classes.Person;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class PersonServiceImpl implements PersonService {
    private ArrayList<Person> people = new ArrayList();

    @Override
    public String createPerson(List<Person> people) {
        this.people.addAll(people);
        return "       People CREATED successfully!       ";
    }

    @Override
    public String removePerson(String name, List<Person> people) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                this.people.remove(person);
            }
        }
        return "        The person REMOVED successfully!        ";
    }

    @Override
    public List<Person> getAll(List<Person> people1) {
        return people1;
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
    public List<Person> findByCarName(String name, List<Person> people) {
        List<Person> resulSearch = new ArrayList<>();
        for (Person person : people) {
            for (Car car : person.getCars()) {
                if (car.getName().equals(name)) {
                    resulSearch.add(person);
                }
            }
        }
        return resulSearch;
    }

    @Override
    public String payCars(String name, List<Person> person, String carName, List<Car> cars) {
        String personName = null;
        String carsName = null;
        for (Person person1 : person) {
            if (person1.getName().equals(name)) {
                personName = person1.getName();
                for (Car car : cars) {
                    if (car.getName().equals(carName)) {
                        carsName = car.getName();
                        person1.getCars().add(car);
                        for (Person person2 : people) {
                            person2.getMoney().subtract(car.getPrice());
                        }
                        person1.getMoney().subtract(car.getPrice());
                    }
                }
            }
        }
        return "       SUCCESSFULLY " + personName + " buy a car " + carsName + "!";
    }

    @Override
    public List<Person> sortPersonDateOfBirth(List<Person> persons) {
        List<Person> sortedPeople = new ArrayList<>();
        persons.sort(sortByDate);
        sortedPeople.addAll(persons);
        return sortedPeople;
    }

    @Override
    public List<Person> sortPersonName(List<Person> persons) {
        List<Person> sortedPeople = new ArrayList<>();
        persons.sort(sortByName);
        sortedPeople.addAll(persons);
        return sortedPeople;
    }

    @Override
    public List<Person> sortGender(List<Person> person) {
        List<Person> sortedPeople = new ArrayList<>();
        person.sort(sortByGender);
        sortedPeople.addAll(person);
        return sortedPeople;
    }

    @Override
    public int getAge(Person person) {
        return Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
    }

    public static Comparator<Person> sortByDate = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getDateOfBirth().getYear() - o2.getDateOfBirth().getYear();
        }
    };

    public static Comparator<Person> sortByName = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o2.getName().compareTo(o1.getName());
        }
    };

    public static Comparator<Person> sortByGender = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getGender().name().compareTo(o2.getGender().name());
        }
    };
}
