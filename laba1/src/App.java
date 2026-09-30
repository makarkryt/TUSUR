import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Person p1 = new Person();
        System.out.println(p1); //Person@2f92e0f4
        
        Bar bar = new Bar("Черника");
        
        Person katya = new Person();
        Person ivan = new Person(17, "мужчина", "Иван", List.of("Книга"), 5000f);
        Person oleg = new Person(25, "мужчина", "Олег", List.of("Кошелек"), 120f);

        bar.admitGuest(katya);
        bar.admitGuest(ivan);
        bar.admitGuest(oleg);

        bar.makePurchase(katya, "Whiskey");
        bar.makePurchase(oleg, "Beer");
        bar.makePurchase(oleg, "Water");
        bar.makePurchase(katya, "Martini");

        System.out.println("\nПоиск: " + (bar.findGuest("Катя") != null ? "Найдена" : "Не найдена"));
        System.out.println("Иван в баре: " + (bar.findGuest("Иван") != null));
        
        bar.showPurchaseLog();
    }
}
