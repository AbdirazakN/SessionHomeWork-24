import java8.classes.Car;
import java8.classes.Person;
import java8.enums.Colour;
import java8.enums.Country;
import java8.enums.Gender;
import java8.exception.MyException;
import java8.service.impl.CarServiceImpl;
import java8.service.impl.PersonServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyException {

        /**
         * Home work
         * java8 деген пакет ачып ичине clases,java8.exception.service,java8.exception.service.enums,java8.exception деген пакеттерди ачыныз.
         * java8.exception.service.classes пакетинин ичине:Person жана Car деген класстарды ачыныз.
         * Person классынын полелери {
         *     private String name;
         *     private LocalDate dateOfBirth;
         *     private Gender gender;
         *     private BigDecimal money;
         *     private String phoneNumber;
         *     private List<Car> cars;
         * }
         * Ал эми Car классынын полелери{
         *     private String name;
         *     private String mark;
         *     private BigDecimal price;
         *     private Year releaseYear;
         *     private Colour color;
         *     private Country countryOfOrigin;
         * }
         * Enums пакетинин ичинде Country,Colour,Gender деген enumдарды тузунуздор.Enumдардын
         * ичине озуно керектуу константаларды жазыныз.
         * Service пакетинин ичине PersonService деген интерфейс ачып анын ичине ушундай абстрактный методдорду жазыныз.
         *
         *     String createPerson(List<Person> people);
         *
         *     String removePerson(String name, List<Person> people);
         *
         *     List<Person> getAll();
         *
         *     List<Person> findByName(String name, List<Person> people);
         *
         *     List<Person> findByCarName(String name, List<Person> people);
         *
         *     String payCars(String name, List<Person> person, String carName, List<Car> cars);
         *
         *      List<Person>sortPersonDateOfBirth(List<Person>persons);
         *
         *      List<Person>sortPersonName(List<Person>persons);
         *
         *      List<Person>sortGender(List<Person>person)
         *
         *      int getAge(Person person);
         *
         * CarService деген интерфейс ачып анын ичине астында тургандай методдорду жазыныз.
         *
         *     String createCar(List<Car>cars);
         *
         *     String removeCar(String name,List<Car>cars);
         *
         *     List<Car>getAll();
         *
         *     List<Person>findByName(String name,List<Person>people);
         *
         *     List<Car>findByCountry(String name,List<Person>persons);
         *
         * Service пакетинин ичине impl деген пакет ачып анын ичине PersonServiceImpl деген
         * класс ачып PersonService интерфейсин impliments кылып методдордун реализациясын ошол класстан жазыныз.
         * жана Ошондой эле CarServiceImpl деген класс ачып ал CarService интерфейсин impliment
         * кылсын анын ичиндеги методдорду  @Override кылып алып отуп логикасын иштетиниз.
         * Эскертуу баардык озгочо учурлардын алдын алыныз.Mисалы келе элек кунду туулат деп бере албайбыз,
         * ушуга окшогон баардык майда чуйдону эске алып жазыныздар программированиеда бир болбогон
         * нерсе учун биздин жазган проектибиз иштебей калышы мумкун ошого ар бир нерсеге маани берип жазыныздар.
         * Коп коп практика кылсак жакшы баары болот.Озунуздор учун мага иштеп жонотунуздор.
         */


        Car car1 = new Car("Lexus", "LX570", new BigDecimal(1200000), Year.of(2021), Colour.WHITE, Country.USA);
        Car car2 = new Car("BMW", "i820", new BigDecimal(2200000), Year.of(2022), Colour.BLACK, Country.KYRGYZSTAN);
        Car car3 = new Car("Toyota", "Camry-70", new BigDecimal(2500000), Year.of(2020), Colour.BROWN, Country.CHINA);
        Car car4 = new Car("KIA", "K5", new BigDecimal(1600000), Year.of(2019), Colour.BLUE, Country.RUSSIA);


        Person person1 = new Person("Abdirazak", LocalDate.of(2001, 1, 1), Gender.MALE, new BigDecimal(12500), "+996 700 707 707", new ArrayList<>(List.of(car1)));
        Person person2 = new Person("Fatima", LocalDate.of(2002, 11, 21), Gender.FEMALE, new BigDecimal(120000), "+996 777 777 707", new ArrayList<>(List.of(car2)));
        Person person3 = new Person("Baatyr", LocalDate.of(2005, 5, 18), Gender.MALE, new BigDecimal(1250000), "+996 500 505 505", new ArrayList<>(List.of(car3)));
        Person person4 = new Person("Amirbek", LocalDate.of(1999, 9, 14), Gender.MALE, new BigDecimal(5000000), "+996 220 202 202", new ArrayList<>(List.of(car4)));

        ArrayList<Car> carArrayList = new ArrayList<>(List.of(car1, car2, car3, car4));
        ArrayList<Person> personArrayList = new ArrayList<>(List.of(person1, person2, person3, person4));

        CarServiceImpl carServiceImpl = new CarServiceImpl();
        PersonServiceImpl personServiceImpl = new PersonServiceImpl();


        Scanner remove = new Scanner(System.in);
        Scanner find = new Scanner(System.in);
        Scanner pay = new Scanner(System.in);
        Scanner command = new Scanner(System.in);
        Scanner age = new Scanner(System.in);

        while (true) {

            System.out.println("""
                    =========================Программанын командалары===========================
                    <1> - Машиналардын тизмесин тузуу
                    <2> - Адамдардын тизмесин тузуу
                    <3> - Бардык адамдардын тизмесин коруу
                    <4> - Бардык машиналардын тизмесин коруу
                    <5> - Белгиленген машинаны тизмеден очуруу
                    <6> - Белгиленген адамды тизмеден очуруу
                    <7> - Тизмеден адам издоо
                    <8> - Тизмеден адамды машинасы менен издоо
                    <9> - Машина сатып алуу
                    <10> - Адамдын жашын коруу
                    <11> - Адамдарды жашы боюнча тартиптоо
                    <12> - Адамдарды аты боюнча тартиптоо
                    <13> - Адамдарды жынысы боюнча тартиптоо
                     <0> == Программаны жыйынтыктоо.
                    """);

            int commands = command.nextInt();
            switch (commands) {
                case 1:
                    System.out.println(carServiceImpl.createCar(carArrayList));
                    break;
                case 2:
                    System.out.println(personServiceImpl.createPerson(personArrayList));
                    break;
                case 3:
                    System.out.println(personServiceImpl.getAll(personArrayList));
                    break;
                case 4:
                    System.out.println(carServiceImpl.getAll());
                    break;
                case 5:
                    System.out.println("Очуруу учун машинанын атын жазыныз: ");
                    System.out.println(carServiceImpl.removeCar(remove.nextLine(), carArrayList));
                    break;
                case 6:
                    System.out.println("Кайсы адамды тизмеден очургунуз келсе атын жазыныз: ");
                    System.out.println(personServiceImpl.removePerson(remove.nextLine(), personArrayList));
                    break;
                case 7:
                    System.out.println("Тизмеден адамды аты менен издоо учун ал адамдын атын жазыныз:  ");
                    System.out.println(personServiceImpl.findByName(find.nextLine(), personArrayList));
                    break;
                case 8:
                    System.out.println("Тизмеден машинаны аты менен издоо учун ал машинанын атын жазыныз:  ");
                    System.out.println(personServiceImpl.findByCarName(find.nextLine(), personArrayList));
                    break;
                case 9:
                    System.out.println("Сатып алуучунун атын жана машинанын атын жазыныз: ");
                    System.out.println(personServiceImpl.payCars("Abdirazak", personArrayList, "BMW", carArrayList));
                    break;
                case 10:
                    System.out.println("Кайсы адамдын жашын билгиниз келет? ");
                    String name = age.nextLine();
                    if (name.equals("Abdirazak")) {
                        System.out.println(personServiceImpl.getAge(person3));
                    } else if (name.equals("Amirbek")) {
                        System.out.println(personServiceImpl.getAge(person4));
                    } else if (name.equals("Fatima")) {
                        System.out.println(personServiceImpl.getAge(person2));
                    } else if (name.equals("Baatyr")) {
                        System.out.println(personServiceImpl.getAge(person3));
                    }
                    break;
                case 11:
                    System.out.println(personServiceImpl.sortPersonDateOfBirth(personArrayList));
                    break;
                case 12:
                    System.out.println(personServiceImpl.sortPersonName(personArrayList));
                    break;
                case 13:
                    System.out.println(personServiceImpl.sortGender(personArrayList));
                    break;
            }
            if (commands == 0) {
                System.out.println("=======================  PROGRAM  IS  COMPLETE!!  =============================");
                break;
            }
        }
    }
}