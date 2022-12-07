package java8.classes;

import java8.enums.Gender;
import java8.exception.MyException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Person {
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private BigDecimal money;
    private String phoneNumber;
    private List<Car> cars;

    public Person(String name, LocalDate dateOfBirth, Gender gender, BigDecimal money, String phoneNumber, List<Car> cars) throws MyException {
        if (name.matches("[A-zА-я]*") && name.length() > 2) {
            this.name = name;
        } else {
            throw new MyException("Name can't be few than two letters and with symbols!");
        }
        if (dateOfBirth.getYear() < LocalDate.now().getYear() && dateOfBirth.getYear() > 0) {
            this.dateOfBirth = dateOfBirth;
        } else {
            throw new MyException("Date of birth can't be few than zero and more than 2022!");
        }
        this.gender = gender;
        this.money = money;
        if (!phoneNumber.matches("[A-zА-я]*") && phoneNumber.length() <= 17) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new MyException("Phone number can't be create with letters and more than 16 number!");
        }

        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "\n    Person-->>>" +
                "\nName: " + name +
                "\nDate Of Birth: " + dateOfBirth +
                "\nGender: " + gender +
                "\nMoney: " + money +
                "\nPhone Number: " + phoneNumber +
                "\n  Cars: " + cars;
    }
}
