import java.util.ArrayList;
import java.util.List;

public class Bar {
    private final String name;
    private final List<Person> guests;
    private final List<String> purchaseLog;

    public Bar(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Некорректное название бара");
        this.name = name;
        this.guests = new ArrayList<>();
        this.purchaseLog = new ArrayList<>();
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
            count++;
        }

        if (count > 0) {
            String logEntry = guest.getName() + " купил " + count + " шт. " + drinkName + " по цене " + price + "р";
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
        System.out.println("\n📜 История покупок в баре '" + this.name + "' (кроме воды):");
        if (purchaseLog.isEmpty()) {
            System.out.println("Покупок пока не было.");
            return;
        }
        
        for (int i = 0; i < purchaseLog.size(); i++) {
            if (purchaseLog.get(i).toLowerCase().contains("water")) continue;
            System.out.println((i + 1) + ". " + purchaseLog.get(i));
        }
    }

    public String getName() { return name; }
    public List<Person> getGuests() { return new ArrayList<>(guests); }
    public List<String> getPurchaseLog() { return new ArrayList<>(purchaseLog); }
}