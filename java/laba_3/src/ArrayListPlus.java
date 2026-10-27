
import java.util.ArrayList;
import java.util.List;
/* Не используя вспомогательных объектов, переставить отрицательные
элементы данного списка в конец, а положительные - в начало этого списка. */
public class ArrayListPlus<T extends Number> extends ArrayList<T> {
    @SafeVarargs 
    public ArrayListPlus(T... items) {
        super(List.of(items));
    }
    /* Я использовал структуру данных Arraylist т.к. цена сумму операций (добавление, получение, удаление)
    равна 2*O(1)+O(n), вместо 3*O(n) у LinkedList
    */
    public void sortPosNeg(){
        int size = this.size();
        for(int i = 0; i < size; ++i){
            if(this.get(i).doubleValue()<0){
                this.add(this.get(i)); // О(1) + О(1)
                this.remove(i); // О(n)
            }
        }
    }

}
