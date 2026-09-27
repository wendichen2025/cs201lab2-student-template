import java.util.*;

public class SinglyLinkedList<E extends Comparable<E>> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    private static class Node<E> {
        private E element;
        private Node<E> next;
    
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }
    
        public E getElement(){
            return element;
        }
    
        public Node<E> getNext(){
            return next;
        }
    
        public void setNext(Node<E> n){
            next = n;
        }
    }

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            sb.append(current.getElement());
            sb.append(" ");
            current = current.getNext();
        }
        return sb.toString();
    }

    // write your codes here
    // Swaps the k-th smallest element with the k-th largest element for every k.
    public void swap(){
        if (size < 2){
            return;
        }

        // collect the nodes into a list
        List<Node<E>> nodes = new ArrayList<>(size);
        Node<E> current = head;
        while (current != null) {
            nodes.add(current);
            current = current.getNext();
        }

        // sort the nodes by their elements (O(n log n))
        nodes.sort((a, b) -> a.getElement().compareTo(b.getElement()));

        // swap the elements of the i-th smallest and i-th largest nodes
        for (int i = 0, j = nodes.size() - 1; i < j; i++, j--) {
            Node<E> small = nodes.get(i);
            Node<E> large = nodes.get(j);
            E temp = small.element;
            small.element = large.element;
            large.element = temp;
        }
    }
   
}

