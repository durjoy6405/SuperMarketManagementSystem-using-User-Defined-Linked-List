/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package part2;

/**
 *
 * @author Durjoy
 */
public class LinkedList <T> {
    
    Node<T> head;

    public LinkedList() {
        this.head = null;
    }
    
    public void append(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node<T> lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }
    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    public void deleteNodeByPosition(int position) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete from an empty list.");
            return;
        }

        if (position == 0) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        Node<T> prev = null;
        int count = 0;

        while (current != null && count < position) {
            prev = current;
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position " + position + " not found in the list.");
            return;
        }

        prev.next = current.next;
    }
    public Node<T> getHead() {
        return head;
    }
    public Node<T> getTail() {
        if (head == null) {
            return null; // Empty list
        }

        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }

        return current;
    }
    
    public void remove(T data) {
        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        Node<T> prev = null;

        while (current != null && !current.data.equals(data)) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            prev.next = current.next;
        }
    }
}
