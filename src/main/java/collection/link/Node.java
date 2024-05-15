package collection.link;

public class Node {

    Object item;
    Node next;

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        if(this.next == null){
            return "["+item+"]";
        }
        return "["+this.item+"]"+"->"+ next.toString();
    }
}
