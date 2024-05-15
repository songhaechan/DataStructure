package collection.link;

public class MyLinkedListV2 {
    private Node first;
    private int size = 0;

    public void add(Object e){
        Node newNode = new Node(e);
        if(first == null){
            first = newNode;
        }else{
            Node lastNode = getLastNode();
            lastNode.next = newNode;
        }
        size++;
    }

    public void add(int index, Object e){
        Node newNode = new Node(e);
        if(index == 0){
            newNode.next = first;
            first = newNode;
        }else{
            Node prev = getNode(index-1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    public Object remove(int index){
        Node removeNode = getNode(index);
        Object item = removeNode.item;
        if(index == 0){
            first = removeNode.next;
        }else{
            Node prev = getNode(index - 1);
            prev.next = prev.next.next;
        }
        removeNode.item = null;
        removeNode.next = null;
        size--;
        return item;
    }

    private Node getLastNode(){
        Node x = first;
        while(x.next != null){
            x = x.next;
        }
        return x;
    }

    public Object set(int index, Object e){
        Node x = getNode(index);
        Object oldValue = x.item;
        x.item = e;
        return oldValue;
    }

    public Object get(int index) {
        Node node = getNode(index);
        return node.item;
    }

    private Node getNode(int index){
        Node x = first;
        for(int i=0; i<index;i++){
            x = x.next;
        }
        return x;
    }

    public int indexOf(Object o){
        int index = 0;
        Node x = first;
        while(first != null){
            index++;
            if(o.equals(x.item)){
                return index;
            }
            x= x.next;
        }
        return -1;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        return "MyLinkedListV1{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }
}
