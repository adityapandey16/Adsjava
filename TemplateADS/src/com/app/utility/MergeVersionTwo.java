package com.app.utility;

public class MergeVersionTwo {
	    
	    // Merge two subarrays L and M into array
	    public static void merge(int[] array, int left, int mid, int right) {
	        // Sizes of two subarrays
	        int n1 = mid - left + 1;
	        int n2 = right - mid;

	        // Create temp arrays
	        int[] L = new int[n1];
	        int[] M = new int[n2];

	        // Copy data to temp arrays L[] and M[]
	        System.arraycopy(array, left, L, 0, n1);
	        System.arraycopy(array, mid + 1, M, 0, n2);

	        // Initial indexes of first and second subarrays
	        int i = 0, j = 0;

	        // Initial index of merged subarray
	        int k = left;

	        // Merge the temp arrays back into the original array
	        while (i < n1 && j < n2) {
	            if (L[i] <= M[j]) {
	                array[k] = L[i];
	                i++;
	            } else {
	                array[k] = M[j];
	                j++;
	            }
	            k++;
	        }

	        // Copy the remaining elements of L[], if there are any
	        while (i < n1) {
	            array[k] = L[i];
	            i++;
	            k++;
	        }

	        // Copy the remaining elements of M[], if there are any
	        while (j < n2) {
	            array[k] = M[j];
	            j++;
	            k++;
	        }
	    }

	    // Divide the array into two halves, sort them and merge them
	    public static void mergeSort(int[] array, int left, int right) {
	        if (left < right) {
	            // Calculate the middle point
	            int mid = left + (right - left) / 2;

	            // Sort first and second halves
	            mergeSort(array, left, mid);
	            mergeSort(array, mid + 1, right);

	            // Merge the sorted halves
	            merge(array, left, mid, right);
	        }
	    }

	    // Utility function to print the array
	    public static void printArray(int[] array) {
	        for (int j : array) {
	            System.out.print(j + " ");
	        }
	        System.out.println();
	    }

	    // Main method to test the merge sort algorithm
	    public static void main(String[] args) {
	        int[] array = {12, 11, 13, 5, 6, 7};

	        System.out.println("Given Array:");
	        printArray(array);

	        mergeSort(array, 0, array.length - 1);

	        System.out.println("\nSorted Array:");
	        printArray(array);
	    }
	}


