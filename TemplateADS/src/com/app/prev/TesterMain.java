package com.app.prev;

import java.util.Scanner;

import com.app.linkedlist.SinglyLinkedList;

public class TesterMain {

	public static void main(String[] args) {
		 try (Scanner scanner = new Scanner(System.in)) {
			 SinglyLinkedList list = new SinglyLinkedList();
	            boolean exit = false;

	            while (!exit) {
	                try {
	                    System.out.println("Menu:");
	                    System.out.println("1. Add an element");
	                    System.out.println("2. Remove all occurrences of an element");
	                    System.out.println("3. Calculate average of elements");
	                    System.out.println("4. Print list in reverse order");
	                    System.out.println("5. Print list");
	                    System.out.println("6. Exit");
	                    System.out.print("Choose an option: ");
	                    int choice = scanner.nextInt();

	                    switch (choice) {
	                        case 1:
	                            System.out.print("Enter element to add: ");
	                            int data = scanner.nextInt();
	                            System.out.print("Enter position: ");
	                            int index = scanner.nextInt();
	                            try {
	                                list.add(data, index);
	                            } catch (InvalidIndexException e) {
	                                System.out.println(e.getMessage());
	                            }
	                            break;
	                        case 2:
	                            System.out.print("Enter element to remove: ");
	                            int removeData = scanner.nextInt();
	                            list.removeAll(removeData);
	                            break;
	                        case 3:
	                            try {
	                                System.out.println("Average: " + list.avg());
	                            } catch (EmptyListException e) {
	                                System.out.println(e.getMessage());
	                            }
	                            break;
	                        case 4:
	                            try {
	                                System.out.print("List in reverse order: ");
	                                list.printReverse();
	                            } catch (EmptyListException e) {
	                                System.out.println(e.getMessage());
	                            }
	                            break;
	                        case 5:
	                            list.printList();
	                            break;
	                        case 6:
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

	}

}
