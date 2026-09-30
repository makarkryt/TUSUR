import java.util.ArrayList;
import java.util.List;

public class Person {

    private int age;
    public final String gender;
    private String name;
    private List<String> bag;
    private float balance;

    public Person() {
        this.age = 20;
        this.gender = "женщина";
        this.name = "Катя";
        this.bag = new ArrayList<>(List.of("Телефон", "Помада", "Перцовка"));
        this.balance = 1000.00f;
    }

    public Person(int age, String gender, String name, List<String> bag, float balance) {
        validateAll(age, name, bag, balance);
        this.age = age;
        this.gender = gender;
        this.name = name;
        this.bag = new ArrayList<>(bag);
        this.balance = balance;
    }

    public Person(Person other) {
        validateAll(other.age, other.name, other.bag, other.balance);
        this.age = other.age;
        this.gender = other.gender;
        this.name = other.name;
        this.bag = new ArrayList<>(other.bag);
        this.balance = other.balance;
    }

    private void validateAge(int age) {
        if (age <= 0 || age > 150) {
            throw new IllegalArgumentException(age + " Некорректный возраст");
        }
    }

    private void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Имя не может быть null");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (name.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Имя не должно содержать цифр");
        }
    }

    private void validateBag(List<String> bag) {
        if (bag == null) {
            throw new IllegalArgumentException("Сумка не может быть null");
        }
        for (String item : bag) {
            if (item == null) {
                throw new IllegalArgumentException("Элементы сумки не могут быть null");
            }
            if (item.isBlank()) {
                throw new IllegalArgumentException("Элементы сумки не могут быть пустыми или состоять из пробелов");
            }
        }
    }

    private void validateBalance(float balance) {
        if (balance < 0 || balance > 1_000_000_000) {
            throw new IllegalArgumentException("Некорректный баланс: " + balance);
        }
    }
    
    private void validateAll(int age, String name, List<String> bag, float balance){
        validateAge(age);
        
        validateName(name);
        
        validateBag(bag);
        
        validateBalance(balance);
    }

    public void setAge(int age) {
        validateAge(age);
        this.age = age;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public void setBag(List<String> bag) {
        validateBag(bag);
        this.bag = new ArrayList<>(bag); // Защитная копия
    }

    public void setBalance(float balance) {
        validateBalance(balance);
        this.balance = balance;
    }


    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getBag() {
        return new ArrayList<>(this.bag);
    }

    public float getBalance() {
        return this.balance;
    }

    public void addItemToBag(String item) {
        if (item == null || item.isBlank()) {
            throw new IllegalArgumentException("Предмет не может быть null или пустым");
        }
        this.bag.add(item);
    }

    @Override
    public String toString() {
        return "Person {" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", balance=" + balance +
                "р, bag=" + bag +
                '}';
    }
}
