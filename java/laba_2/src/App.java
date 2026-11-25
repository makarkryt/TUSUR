public class App {
    public static void main(String[] args) throws Exception {
        try {
            Color c1 = new Color("14,2asd34,123");
            System.out.println(c1.checkRGB());
        }
        catch (IllegalArgumentException e) {
            error(e);
        }
    }
    private static void error(IllegalArgumentException e){
        System.out.println(e.getMessage());
    }
}
