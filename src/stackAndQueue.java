public class stackAndQueue {
    public static class Node{
        private int data;
        private Node next;
        private Node(int data){
            this.data = data;
        }
    }

    public class Queue{

        private Node head; // remove from here
        private Node tail; // add to here

        public boolean isEmpty(){
            return head == null;
        }

        public void add(int data){
            Node node = new Node(data);

            if(tail != null)
                tail.next = node;

            tail = node;
            if(head == null){
                head = node;
            }
        }

        public int remove(){
            int data = head.data;
            head = head.next;

            if(head == null)
                tail = null;

            return data;
        }
    }

    public class stack{
        private Node top;

        public int pop(){
            int data = top.data;
            top = top.next;

            return data;
        }

        public void push(int data){
            Node node = new Node(data);
            node.next = top;
            top = node;
        }

    }

}
