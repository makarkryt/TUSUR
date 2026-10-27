public class App {
    public static void main(String[] args) throws Exception {
        ArrayListPlus list1 = new ArrayListPlus<>(1,3,4,-4,5,-2,4,9);
        list1.sortPosNeg();
        System.out.println(list1);
    }
}
