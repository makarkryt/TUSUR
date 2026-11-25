public class App {
    public static void main(String[] args) throws Exception {
        try{
            ArrayListPlus list1 = new ArrayListPlus<>(1,3,4,-4,5,-2,4,9);
            list1.sortPosNeg();
            System.out.println(list1);
        }
        catch(IllegalArgumentException  e){
            error(e);
        };
    }

    private static void error(IllegalArgumentException  e){
        System.out.println(e.getMessage());
    } 
}
