package com.app.utility;

public class InsertionSortLinkedLIST {
	
	    private Node head;

	    // Node class
	    private static class Node {
	        int data;
	        Node next;

	        Node(int data) {
	            this.data = data;
	            this.next = null;
	        }
	    }

	    // Method to insert a new node at the end
	    public void insert(int data) {
	        Node newNode = new Node(data);
	        if (head == null) {
	            head = newNode;
	        } else {
	            Node current = head;
	            while (current.next != null) {
	                current = current.next;
	            }
	            current.next = newNode;
	        }
	    }

	    // Method to print the linked list
	    public void printList() {
	        Node current = head;
	        while (current != null) {
	            System.out.print(current.data + " ");
	            current = current.next;
	        }
	        System.out.println();
	    }

	    // Method to sort the linked list using insertion sort
	    public void insertionSort() {
	        if (head == null || head.next == null) {
	            return;
	        }

	        Node sorted = null;  // Initialize sorted linked list

	        Node current = head;  // Traverse the given linked list and insert every node to sorted
	        while (current != null) {
	            Node next = current.next;  // Store next for next iteration
	            sorted = sortedInsert(sorted, current);  // Insert current in sorted linked list
	            current = next;  // Update current
	        }

	        head = sorted;
	    }

	    // Method to insert a new node in sorted way in a sorted linked list
	    private Node sortedInsert(Node sorted, Node newNode) {
	        if (sorted == null || sorted.data >= newNode.data) {
	            newNode.next = sorted;
	            sorted = newNode;
	        } else {
	            Node current = sorted;
	            while (current.next != null && current.next.data < newNode.data) {
	                current = current.next;
	            }
	            newNode.next = current.next;
	            current.next = newNode;
	        }
	        return sorted;
	    }

	    // Main method to test the insertion sort on a linked list
	    public static void main(String[] args) {
	    	InsertionSortLinkedLIST list = new InsertionSortLinkedLIST();
	        list.insert(30);
	        list.insert(3);
	        list.insert(4);
	        list.insert(20);
	        list.insert(5);

	        System.out.println("Linked List before sorting:");
	        list.printList();

	        list.insertionSort();

	        System.out.println("Linked List after sorting:");
	        list.printList();
	    }
	}


