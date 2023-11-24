package MyPackage.adtInterface;

/**
 * Queue
 * interface have only abstract mehtods , those are basicaly used for multiple
 * implementation of interface in one class, that is basicaly imrpove the
 * multiple inheritance feature(not eactly but still)
 * Special usecase :- To add some extra behaviour of a particular class , we need interface.
 * The interface have the method declaration not hte implementation.
 */
public interface Queue {
    public void enqueue(String customer);

    String dequeue();
}