import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        
        Bar bar = new Bar("Черника");
        
        Person p1 = new Person();
        Person ivan = new Person(17, "мужчина", "Иван", List.of("Книга"), 5000f);
        System.out.println(p1); //Person@2f92e0f4
        Person p2 = new Person(25, "мужчина", "Олег", List.of("Кошелек"), 120f);

        bar.admitGuest(p1);
        bar.admitGuest(ivan);
        bar.admitGuest(p2);

        bar.makePurchase(p1, "Whiskey");
        bar.makePurchase(p2, "Beer");
        bar.makePurchase(p2, "Water");
        bar.makePurchase(p1, "Martini");

        System.out.println("\nПоиск: " + (bar.findGuest("Катя") != null ? "Найдена" : "Не найдена"));
        System.out.println("Иван в баре: " + (bar.findGuest("Иван") != null));
        
        bar.showPurchaseLog();
    }
}
