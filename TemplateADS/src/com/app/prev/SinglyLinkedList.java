package com.app.prev;



public class SinglyLinkedList {
	  private Node head;
	    private Node tail;
	    private int size;

	    // Node class
	    private static class Node {
	        int data;
	        Node next;

	        Node(int data) {
	            this.data = data;
	            this.next = null;
	        }
	    }

	    // Constructor
	    public SinglyLinkedList() {
	        this.head = null;
	        this.tail = null;
	        this.size = 0;
	    }

	    // Method to add an element at a specified position
	    public void add(int data, int index) {
	        if (index < 0) {
	            throw new InvalidIndexException("Index cannot be less than 0");
	        }
	        Node newNode = new Node(data);
	        if (index == 0) {
	            newNode.next = head;
	            head = newNode;
	            if (tail == null) {
	                tail = newNode;
	            }
	        } else {
	            Node current = head;
	            for (int i = 0; i < index - 1; i++) {
	                if (current == null) {
	                    throw new InvalidIndexException("Index is out of bounds");
	                }
	                current = current.next;
	            }
	            if (current == null) {
	                throw new InvalidIndexException("Index is out of bounds");
	            }
	            newNode.next = current.next;
	            current.next = newNode;
	            if (newNode.next == null) {
	                tail = newNode;
	            }
	        }
	        size++;
	    }

	    // Method to remove all occurrences of a specific element
	    public void removeAll(int data) {
	        while (head != null && head.data == data) {
	            head = head.next;
	            size--;
	        }
	        Node current = head;
	        while (current != null && current.next != null) {
	            if (current.next.data == data) {
	                current.next = current.next.next;
	                size--;
	            } else {
	                current = current.next;
	            }
	        }
	        if (tail != null && tail.data == data) {
	            tail = current;
	        }
	    }

	    // Method to calculate the average of all elements
	    public double avg() {
	        if (size == 0) {
	            throw new EmptyListException("Cannot calculate average of an empty list");
	        }
	        int sum = 0;
	        Node current = head;
	        while (current != null) {
	            sum += current.data;
	            current = current.next;
	        }
	        return (double) sum / size;
	    }

	    // Method to print the list in reverse order
	    public void printReverse() {
	        if (head == null) {
	            throw new EmptyListException("Cannot print reverse of an empty list");
	        }
	        printReverseRecursive(head);
	        System.out.println();
	    }

	    private void printReverseRecursive(Node node) {
	        if (node == null) {
	            return;
	        }
	        printReverseRecursive(node.next);
	        System.out.print(node.data + " ");
	    }

	    // Method to print all elements in the list
	    public void printList() {
	        Node current = head;
	        while (current != null) {
	            System.out.print(current.data + " ");
	            current = current.next;
	        }
	        System.out.println();
	    }
}
