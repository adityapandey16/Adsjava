package com.app.linkedlist;

public class GenericSinglyLinked<T> {

	private Node<T> head;
	private int length;

	private class Node<T> {
		Node<T> next;
		T data;

		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	public GenericSinglyLinked() {
		head = null;
		this.length = 0;

	}

//----------------------------------------------------------------------------------------------

	// To add the node at the end
	public void add(T data) {

		// Creating new node with given value
		Node<T> temp = new Node<>(data);

		// Checking if list is empty
		// and assigning new value to head node
		if (this.head == null) {
			head = temp;
		}

		// If list already exists
		else {

			// Temporary node for traversal
			Node<T> X = head;

			// Iterating till end of the List
			while (X.next != null) {
				X = X.next;
			}

			// Adding new valued node at the end of the list
			X.next = temp;
		}

		// Increasing length after adding new node
		length++;
	}

//-----------------------------------------------------------------------------------------

	// To add the node at the position
	public void add(int position, T data) {

		// Checking if position is valid
		if (position > length + 1) {

			// Display message only
			System.out.println("Position Unavailable in LinkedList");
			return;
		}

		// If new position is head then replace head node
		if (position == 1) {

			// Temporary node that stores previous head
			// value
			Node<T> temp = head;

			// New valued node stored in head
			head = new Node<T>(data);

			// New head node pointing to old head node
			head.next = temp;

			return;
		}

		// Temporary node for traversal
		Node<T> temp = head;

		// Dummy node with null value that stores previous
		// node
		Node<T> prev = new Node<T>(null);
		// iterating to the given position
		while (position - 1 > 0) {
			// assigning previous node
			prev = temp;
			// incrementing next node
			temp = temp.next;
			// decreasing position counter
			position--;
		}
		// previous node now points to new value
		prev.next = new Node<T>(data);
		// new value now points to former current node
		prev.next.next = temp;
	}

//-----------------------------------------------------------------------------------------
	public void remove(T key) {
		// Dummy node with null value or use just prev
		Node<T> prev = new Node<>(null);

		// Dummy node pointing to head node
		prev.next = head;

		// Next node that points ahead of current node
		Node<T> next = head.next;

		// Temporary node for traversal
		Node<T> temp = head;

		// Boolean value that checks whether value to be
		// deleted exists or not
		boolean exists = false;

		// If head node needs to be deleted
		if (head.data == key) {
			head = head.next;

			// Node to be deleted exists
			exists = true;
		}

		// Iterating over LinkedList
		while (temp.next != null) {

			// We convert value to be compared into Strings
			// and then compare using
			// String1.equals(String2) method

			// Comparing value of key and current node
			if (String.valueOf(temp.data).equals(String.valueOf(key))) {

				// If node to be deleted is found previous
				// node now points to next node skipping the
				// current node
				prev.next = next;
				// node to be deleted exists
				exists = true;

				// As soon as we find the node to be deleted
				// we exit the loop
				break;
			}

			// Previous node now points to current node
			prev = temp;

			// Current node now points to next node
			temp = temp.next;

			// Next node points the node ahead of current
			// node
			next = temp.next;
		}

		// Comparing the last node with the given key value
		if (exists == false && String.valueOf(temp.data).equals(String.valueOf(key))) {

			// If found , last node is skipped over
			prev.next = null;

			// Node to be deleted exists
			exists = true;
		}

		// If node to be deleted exists
		if (exists) {

			// Length of LinkedList reduced
			length--;
		}

		// If node to be deleted does not exist
		else {

			// Print statement
			System.out.println("Given Value is not present in linked list");
		}
	}

//-----------------------------------------------------------------------------------------------------------

	public void clear() {

		// Head now points to null
		head = null;
		// length is 0 again
		length = 0;
	}

//-----------------------------------------------------------------------------------------------------------
	public boolean empty() {

		// Checking if head node points to null
		if (head == null) {
			return true;
		}
		return false;
	}
//------------------------------------------------------------------------------------------------------------
	@Override
	 public String toString()
    {
 
        String S = "{ ";
 
        Node<T> X = head;
 
        if (X == null)
            return S + " }";
 
        while (X.next != null) {
            S += String.valueOf(X.data) + " -> ";
            X = X.next;
        }
 
        S += String.valueOf(X.data);
        return S + " }";
    }
//-----------------------------------------------------------------------------------------------------------
    // Method to reverse the list
    public void reverse() {
        Node<T> previous = null;
        Node<T> current = head;
        Node<T> next = null;
       // tail = head;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }
}

/*
 * To call in main : 
 *  list<Integer> list1 = new list<>();
        System.out.println(
            "Integer LinkedList created as list1 :");
        // Adding elements to the above List object
 
        // Element 1 - 100
        list1.add(100);
        // Element 2 - 200
        list1.add(200);
        // Element 3 - 300
        list1.add(300);
 
        // Display message only
        System.out.println(
            "list1 after adding 100,200 and 300 :");
 
        // Print and display the above List elements
        System.out.println(list1);
 
        // Removing 200 from list1
        list1.remove(200);
 
        // Display message only
        System.out.println("list1 after removing 200 :");
 
        // Print and display again updated List elements
        System.out.println(list1);
        
        --------------------------------------------------------------------------------------------------
          // Method to delete an element from the list with tail
    public boolean delete(T data) {
        if (head == null) {
            return false;
        }
        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return true;
        }
        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }
        if (current.next == null) {
            return false;
        }
        current.next = current.next.next;
        if (current.next == null) {
            tail = current;
        }
        size--;
        return true;
    }
 */
 
