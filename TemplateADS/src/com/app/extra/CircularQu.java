package com.app.extra;

public class CircularQu {
	    private Node front;
	    private Node rear;
	    private int size;
	    private int capacity;

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
	    public CircularQu(int capacity) {
	        this.capacity = capacity;
	        this.front = null;
	        this.rear = null;
	        this.size = 0;
	    }

	    // Method to check if the queue is empty
	    public boolean isEmpty() {
	        return size == 0;
	    }

	    // Method to check if the queue is full
	    public boolean isFull() {
	        return size == capacity;
	    }

	    // Method to add an element to the queue
	    public void enqueue(int data) {
	        if (isFull()) {
	            throw new IllegalStateException("Queue is full");
	        }
	        Node newNode = new Node(data);
	        if (isEmpty()) {
	            front = newNode;
	            rear = newNode;
	            rear.next = front;
	        } else {
	            rear.next = newNode;
	            rear = newNode;
	            rear.next = front;
	        }
	        size++;
	    }

	    // Method to remove an element from the queue
	    public int dequeue() {
	        if (isEmpty()) {
	            throw new IllegalStateException("Queue is empty");
	        }
	        int data = front.data;
	        if (front == rear) {
	            front = null;
	            rear = null;
	        } else {
	            front = front.next;
	            rear.next = front;
	        }
	        size--;
	        return data;
	    }

	    // Method to get the front element of the queue
	    public int peek() {
	        if (isEmpty()) {
	            throw new IllegalStateException("Queue is empty");
	        }
	        return front.data;
	    }

	    // Method to print the elements of the queue
	    public void printQueue() {
	        if (isEmpty()) {
	            System.out.println("Queue is empty");
	            return;
	        }
	        Node current = front;
	        do {
	            System.out.print(current.data + " ");
	            current = current.next;
	        } while (current != front);
	        System.out.println();
	    }

	    /* Main method to demonstrate functionality
	    public static void main(String[] args) {
	        try (Scanner scanner = new Scanner(System.in)) {
	            System.out.print("Enter the capacity of the circular queue: ");
	            int capacity = scanner.nextInt();
	            CircularQueue queue = new CircularQueue(capacity);
	            boolean exit = false;

	            while (!exit) {
	                try {
	                    System.out.println("Menu:");
	                    System.out.println("1. Enqueue an element");
	                    System.out.println("2. Dequeue an element");
	                    System.out.println("3. Peek the front element");
	                    System.out.println("4. Print the queue");
	                    System.out.println("5. Check if the queue is empty");
	                    System.out.println("6. Check if the queue is full");
	                    System.out.println("7. Exit");
	                    System.out.print("Choose an option: ");
	                    int choice = scanner.nextInt();

	                    switch (choice) {
	                        case 1:
	                            System.out.print("Enter element to enqueue: ");
	                            int data = scanner.nextInt();
	                            try {
	                                queue.enqueue(data);
	                            } catch (IllegalStateException e) {
	                                System.out.println(e.getMessage());
	                            }
	                            break;
	                        case 2:
	                            try {
	                                int removedData = queue.dequeue();
	                                System.out.println("Dequeued element: " + removedData);
	                            } catch (IllegalStateException e) {
	                                System.out.println(e.getMessage());
	                            }
	                            break;
	                        case 3:
	                            try {
	                                System.out.println("Front element: " + queue.peek());
	                            } catch (IllegalStateException e) {
	                                System.out.println(e.getMessage());
	                            }
	                            break;
	                        case 4:
	                            queue.printQueue();
	                            break;
	                        case 5:
	                            System.out.println("Is queue empty? " + queue.isEmpty());
	                            break;
	                        case 6:
	                            System.out.println("Is queue full? " + queue.isFull());
	                            break;
	                        case 7:
	                            exit = true;
	                            break;
	                        default:
	                            System.out.println("Invalid choice. Please try again.");
	                    }
	                } catch (Exception e) {
	                    System.out.println("An error occurred: " + e.getMessage());
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("An unexpected error occurred: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }*/
	}


