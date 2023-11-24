package InnerClass;
import java.util.ArrayList;


class Enclosing{
     private ArrayList<Object>dataStructure;
     Enclosing(){
        this.dataStructure=new ArrayList<>();
     }
     public void add(Object item){
        dataStructure.add(item);
     }
    private class EvenIterator{
         private int currentIndex;
         EvenIterator(){
            currentIndex=0;
         }
         public Boolean hasNext(){
               return currentIndex<dataStructure.size();
         }
         public Object getEvenItem(){
            Object item=dataStructure.get(currentIndex);
            currentIndex+=2;
            return item;
         }
    }

    public void printEvenItems(){
        EvenIterator evenIterator=new EvenIterator();
        while(evenIterator.hasNext()){
            System.out.println();;
        }
    }
}
public class Test {
     public static void main(String[] args) {
           Enclosing dataStructure=new Enclosing();
            
           dataStructure.add("momo");
           dataStructure.add(40);
           dataStructure.add("Beryani");
           dataStructure.add(true);
           dataStructure.add(89);
           dataStructure.add("Good Bye");

           Enclosing.EvenIterator evenIterator = dataStructure.new EvenIterator();
           while(da)
  
     }
}
