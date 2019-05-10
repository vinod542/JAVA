package com.Java.practice;

import java.util.Arrays;

public class BinarySearch {
	int[] arr = { 34, 4, 212, 414, 216, 417, 222, 125, 3, 426 }; // Binary search operations are only applicable on //
	// sorted list

	void BinaryFun(int[] arr, int start_index, int End_index, int search) {
		int middle_index = (start_index + End_index) / 2;
		System.out.println(middle_index);
		if (arr[middle_index] == search) {
			System.out.println("index: " + middle_index + " value:" + arr[middle_index]);

		} else if (arr[End_index] < search) {
			System.out.println("high value: " + search + " not in sorted array");

		} else if (arr[middle_index] > search) {
			End_index = middle_index - 1;
			BinaryFun(arr, start_index, End_index, search);

		} else if (arr[middle_index] < search) {
			start_index = middle_index + 1;
			BinaryFun(arr, start_index, End_index, search);

		} else {

			System.out.println(search + " Value not found");
		}
	}

	public void BinarySearchMethod() {
		int search = 417;
		Arrays.parallelSort(arr);

		/*
		 * for (int i : arr) System.out.print(" " + i);
		 * 
		 */
		int start_index = 0;
		int End_index = arr.length - 1;
		BinaryFun(arr, start_index, End_index, search);

	}

	public static void main(String[] args) {
		BinarySearch BS = new BinarySearch();
		BS.BinarySearchMethod();

	}

}
