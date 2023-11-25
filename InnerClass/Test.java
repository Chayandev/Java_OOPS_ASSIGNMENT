package InnerClass;

import java.util.ArrayList;

class Enclosing {
   private ArrayList<Integer> dataStructure;

   Enclosing() {
      this.dataStructure = new ArrayList<>();
   }

   public void add(int item) {
      dataStructure.add(item);
   }

   private class EvenIterator {
      private int currentIndex;

      EvenIterator() {
         currentIndex = 0;
      }

      public Boolean hasNext() {
         return currentIndex < dataStructure.size();
      }

      public ArrayList<Integer> getEvenItems() {
         ArrayList<Integer> evenItem = new ArrayList<Integer>();
         while (hasNext()) {
            int item = dataStructure.get(currentIndex++);
            if (item % 2 == 0) {
               evenItem.add(item);
            }
         }
          return evenItem;
      }
   }

   public void printEvenItems() {
      EvenIterator evenIterator = new EvenIterator();
       System.out.println(evenIterator.getEvenItems());
   }
}

public class Test {
   public static void main(String[] args) {
      Enclosing dataStructure = new Enclosing();

      dataStructure.add(55);
      dataStructure.add(40);
      dataStructure.add(96);
      dataStructure.add(7);
      dataStructure.add(89);
      dataStructure.add(69);

      dataStructure.printEvenItems();

   }
}
