import java.util.ArrayList;
import java.util.List;

public class Bar {
    private String name;
    private List<Person> guests;
    private List<String> purchaseLog;
    public Bar() {
        this.name =  "Черника";
        this.guests = new ArrayList<>();
        this.purchaseLog = new ArrayList<>();
    }
    public Bar(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Некорректное название бара");
        this.name = name;
        this.guests = new ArrayList<>();
        this.purchaseLog = new ArrayList<>();
    }
    public Bar(Bar other){
        this.name =  other.name;
        this.guests = other.guests;
        this.purchaseLog = other.purchaseLog;
    }

    public boolean admitGuest(Person person) {
        if (person == null) return false;
        
        if (person.getAge() >= 18) {
            guests.add(person);
            System.out.println(person.getName() + ", добро пожаловать в '" + name + "'!");
            return true;
        } else {
            System.out.println(person.getName() + ", вход запрещен (возраст: " + person.getAge() + ").");
            return false;
        }
    }

    private float getDrinkPrice(String drink) {
        if (drink == null) return -1f;
        switch (drink.toLowerCase()) {
            case "water": return 50f;
            case "cola": return 100f;
            case "beer": return 250f;
            case "whiskey": return 500f;
            default: return -1f;
        }
    }

    public void makePurchase(Person guest, String drinkName) {
        float price = getDrinkPrice(drinkName);
        if (price < 0) {
            System.out.println(" Напитка '" + drinkName + "' нет в меню.");
            return;
        }

        int count = 0;
        while (guest.getBalance() >= price) {
            guest.setBalance(guest.getBalance() - price);
            guest.addItemToBag(drinkName);
            ++count;
        }

        if (count > 0) {
            String verb = "мужчина".equalsIgnoreCase(guest.getGender()) ? " купил " : " купила ";
            String logEntry = guest.getName() + verb + count + " шт. " + drinkName + " по цене " + price + "р";
            purchaseLog.add(logEntry);
            System.out.println("Успешно: " + logEntry);
        } else {
            System.out.println("У " + guest.getName() + " недостаточно средств на " + drinkName);
        }
    }

    public Person findGuest(String name) {
        for (Person guest : guests) {
            if (guest.getName().equalsIgnoreCase(name)) return guest;
        }
        return null;
    }

    public void showPurchaseLog() {
        System.out.println("\n📜 История покупок в баре '" + this.name + ":");
        if (purchaseLog.isEmpty()) {
            System.out.println("Покупок пока не было.");
            return;
        }
        
        for (int i = 0; i < purchaseLog.size(); i++) {
            System.out.println((i + 1) + ". " + purchaseLog.get(i));
        }
    }

    public String getName() {
        return name; 
    }
    public List<Person> getGuests() {
        return new ArrayList<>(guests); 
    }
    public List<String> getPurchaseLog() {
        return new ArrayList<>(purchaseLog); 
    }
    public void setName(String name) {
        this.name = name; 
    }
    public void setGuests(List<Person> guests) {
        this.guests = new ArrayList<>(guests); 
    }
    public void setPurchaseLog(List<String> purchaseLog) {
        this.purchaseLog = new ArrayList<>(purchaseLog); 
    }
}