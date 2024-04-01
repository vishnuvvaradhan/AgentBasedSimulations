/*
  Author: Vishnu Varadhan

  LinkedList creation

  Date: 3/10/2024

  Name: LinkedList.java
*/



import java.util.Iterator;    // defines the Iterator interface
import java.util.NoSuchElementException;
import java.lang.StringBuilder;


public class LinkedList<T> implements Iterable<T>{
    private Node head; 
    private int size;


    private class LLIterator implements Iterator<T>{
        private Node nextNode;

        public LLIterator(Node head){
            nextNode = head;
        }

        public boolean hasNext(){
            return nextNode.getNext() != null;
        }

        public T next(){
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            T item = nextNode.getData();
            nextNode = nextNode.getNext();
            return item;
        }

        public void remove(){
            System.out.println("Not Supported");
        }

    }

    private class Node{
        private Node next;
        private T value;

        public Node(T item){
            next = null;
            value = item;   
        }

        public T getData(){
            return value;
        }

        public void setNext(Node n){
            next = n;
        }

        public Node getNext(){
            return next;
        }
    }

    public LinkedList(){
        head = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public void clear(){
        head = null;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public String toString(){
        if(head == null){
            return "{}";
        }else{
        StringBuilder linkedList = new StringBuilder();
        linkedList.append("{");
        Node currentNode = head;
        while(currentNode != null){
            linkedList.append(currentNode.value + ",");
            currentNode = currentNode.getNext();
        }
        linkedList.append("}");
        return linkedList.toString();
    }
    }

    //adds item to start of list
    public void add(T item){
        Node newHead = new Node(item);
        newHead.setNext(head);
        head = newHead;
        size++;
    }

    public boolean contains(Object o){
        Node currentNode = head;
        while(currentNode != null){
            if(o.equals(currentNode.getData())){
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    public T get(int index){
        Node currentNode = head;

        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }else{
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }
    }

    public T remove(){
        Node firstNode = head;
        if(firstNode == null){
            throw new NoSuchElementException("Cannot remove from an empty list.");
        }
        head = firstNode.getNext();
        size--;
        return firstNode.getData();
    }

    public void add(int index, T item) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }else if(index == 0){
            add(item);
            return;
        }
        else {
            Node nodeToAdd = new Node(item);
            Node currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            nodeToAdd.setNext(currentNode.getNext());
            currentNode.setNext(nodeToAdd);
        }
        size++;

    }

    public T remove(int index){
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }else if(index == 0){
            return remove();
        }else{
        Node currentNode = head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.getNext();
        }
        T value = currentNode.getNext().getData();
        currentNode.setNext(currentNode.getNext().getNext());
        size--;
        return value;
    }
    }

    public boolean equals(Object o) {
        if (this == o){return true;}

        if (!(o instanceof LinkedList)){return false;}
        
        LinkedList<T> other = (LinkedList<T>) o;
        
        if (this.size() != other.size()){return false;}
        
        Node currentThisNode = this.head;
        Node currentOtherNode = other.head;
        while (currentThisNode != null && currentOtherNode != null) { 
            if (!currentThisNode.getData().equals(currentOtherNode.getData())) {
                return false;
            }
            currentThisNode = currentThisNode.getNext();
            currentOtherNode = currentOtherNode.getNext();
        }
        return true;
    }

    public Iterator iterator(){
        return new LLIterator(head);
    }

    public Node getHead(){
        return head;
    }
}
