
package MyPackage.Service;
import java.util.LinkedList;
import MyPackage.adtInterface.Queue;
public class OperatorService implements Queue {

    private LinkedList<String> queue;

    public OperatorService() {
        this.queue = new LinkedList<>(); //used for more effeciaency for deletion operation
    }

    
    @Override
    public void enqueue(String customer) {
        queue.add(customer);
        System.out.println("Ticket Generation Sucessfull for :" + customer);
    }

    @Override
    public String dequeue() {
        if (isEmpty()) {
            System.out.println("No Customer in the Queue.");
            return null;
        }

        String releasedCustomer = queue.removeFirst();
        System.out.println(releasedCustomer + " is served.");
        return releasedCustomer;

    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

}
