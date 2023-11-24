package MyPackage;

import MyPackage.Service.OperatorService;

public class Test {
    public static void main(String[] args){
        OperatorService customerQueue=new OperatorService();;
    
        customerQueue.enqueue("Souvik");
        customerQueue.enqueue("Chayan");
        customerQueue.enqueue("Mango");
 
        while (!customerQueue.isEmpty()) {
            customerQueue.dequeue();
        }

        customerQueue.dequeue();
    }
}
