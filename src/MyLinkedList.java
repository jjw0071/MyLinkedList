public class MyLinkedList<T> {
    static class Node<T> {
        private T item;
        private Node<T> nextNode;

        public Node(T data, Node<T> node){
            this.item = data;
            this.nextNode = node;
        }

        public Node(T data){
            this.item = data;
            this.nextNode = null;
        }

        public Node(){
            this.item = null;
            this.nextNode = null;
        }

        private Node<T> next(){
            return nextNode;
        }

        private void setNextNode(Node<T> node){
            this.nextNode = node;
        }
    }

    private final Node<T> start = new Node<>();
    private final Node<T> end = new Node<>();
    private int size;

    public MyLinkedList() {
        this.start.setNextNode(end);
    }

    public void add(T data){
        Node<T> currentNode = this.start;

        for(int i = 0 ; i < this.size ; i++){
            currentNode = currentNode.next();
        }

        Node<T> newNode = new Node<>(data);
        currentNode.setNextNode(newNode);
        newNode.setNextNode(this.end);
        this.size++;
    }

    public T get(int index){
        Node<T> currentNode = this.start;

        for(int i = 0 ; i < index+1 ; i++){
            currentNode = currentNode.next();
        }
        return currentNode.item;
    }

    public boolean delete(int index){
        if(index>=this.size || index<0){
            System.out.println("index가 적정 범위를 벗어났습니다.");
            return false;
        }

        Node<T> currentNode = this.start;

        for(int i = 0 ; i < index;i++){
            currentNode = currentNode.next();
        }
        Node<T> nodeToDelete = currentNode.next();
        this.size--;

        currentNode.setNextNode(nodeToDelete.next());
        return true;
    }

    public int getSize(){
        return this.size;
    }

    @Override
    public String toString() {
        String start = "---------------------\n" +
                "MyLinkedList\n" +
                "{ startNode";
        String item = "";
        Node<T> currentNode = this.start;
        for(int i = 0 ;i<size;i++){
            currentNode = currentNode.next();
            item += " -> "+ currentNode.item;
        }

        String end = " -> endNode }\n" +
                "---------------------";
        return start + item + end;
    }
}
