public class App {
    public static void main(String[] args) {
        try {
            NumberAlphabet p1 = new NumberAlphabet("Я написал этот текст сам и не жалею об этом");
            p1.result();
        } catch (IllegalArgumentException e) {
            error(e);
        }
    }
    private static void error(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
