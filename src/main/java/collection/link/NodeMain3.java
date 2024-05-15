package collection.link;

public class NodeMain3 {
    public static void main(String[] args) {
        Node first = new Node("A");
        first.next = new Node("B");
        first.next.next = new Node("C");
        System.out.println(first);

        // 마지막 노드 조회
        Node lastNode = getLastNode(first);
        System.out.println(lastNode);

        // 특정 노드 조회 O(N)
        int index=2;
        Node index2Node = getNode(first, index);
        System.out.println(index2Node);

        //데이터 추가
        add(first,"D");
        System.out.println(first);
    }

    private static void add(Node first,String param) {
        Node lastNode = getLastNode(first);
        lastNode.next = new Node(param);
    }

    private static Node getNode(Node first, int index) {
        Node x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    private static Node getLastNode(Node node) {
        Node x = node;
        while(x.next != null){
            x= x.next;
        }
        return x;
    }
}
