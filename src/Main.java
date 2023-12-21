public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> ll = new MyLinkedList<>();

        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.delete(5);
        System.out.println(ll.getSize());




        System.out.println(ll.toString());
    }
}