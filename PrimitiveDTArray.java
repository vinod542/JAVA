package com.amazonArray.com;

class Student {

	public int roll_No;
	public String Student_name;

	public Student(int roll_No, String Student_name) { // constructor stub
		this.roll_No = roll_No;
		this.Student_name = Student_name;
	}

}

public class PrimitiveDTArray {

	public void oneDarr() {
		Student[] arr; // declaring an array
		arr = new Student[5]; // allocating memory
		// below initialize the elements
		arr[0] = new Student(0, "Kiran");
		arr[1] = new Student(1, "Ravvan");
		arr[2] = new Student(2, "Basha");
		arr[3] = new Student(3, "Krish");
		arr[4] = new Student(4, "Ravi");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].roll_No + " " + arr[i].Student_name);
		}

	}

	public void twoDarr() {

		int twoD[][] = { { 2, 4, 5 }, { 5, 6, 3 }, { 7, 4, 5 } };
		// run two pointers for 2D array
		for (int i = 0; i < twoD.length; i++) {
			for (int j = 0; j < twoD.length; j++)
				System.out.print(twoD[i][j] + " ");
			System.out.println();
		}

	}

	public void rotation(int d) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		int n = arr.length;
		if (d >= n) {
			System.out.println("out of range");
		} else {
			for (int i = 0; i < d; i++)
				leftRotate(arr, n);
			printarr(arr, n);

		}
	}

	private void leftRotate(int[] arr, int n) {
		int i, temp;
		temp = arr[0];
		for (i = 0; i < n - 1; i++)
			arr[i] = arr[i + 1];
		arr[i] = temp;
	}

	void printarr(int[] arr, int n) {
		for (int j = 0; j < n - 1; j++)
			System.out.print(arr[j]);

	}

	public static void main(String[] args) {

		PrimitiveDTArray PDT = new PrimitiveDTArray();
		PDT.oneDarr();
		PDT.twoDarr();
		PDT.rotation(5);

	}

}
