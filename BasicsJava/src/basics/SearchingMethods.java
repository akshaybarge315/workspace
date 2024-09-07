package basics;

import java.util.Arrays;

public class SearchingMethods {
	
	public static int linearSearch(int[] a, int key) {
		for (int i = 0; i < a.length; i++) {
			if(a[i] == key) {
				return i;
			}
		}
		return -1;
	}
		
	public static void main(String[] args)
	{
		int[] a = {50,10,33,40,26};
		int key = 99;
		System.out.println(linearSearch(a, key));
	}

}

class BinarySearch {
	public static int binarySearch(int[] a, int key) {
		int l = 0,h = a.length-1, mid = 0;
		while(l <= h) {
			mid = (l+h)/2;
			if(key == a[mid]) {
				return mid;
			}
			else if(key < a[mid]) {
				h = mid-1;
			}
			else {
				l = mid-1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args)
	{
		int[] a = {3,5,6,8,12,15,16,19,21};
		Arrays.sort(a);
		int key = 15;
		System.out.println(binarySearch(a, key));
	}
}

class BubbleSort {
	static void bubbleSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] < a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = { 3, 2, 7, 5, 9 };
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		bubbleSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}

class SelectionSort {
	static void selectionSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int min_i = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] > a[min_i]) {
					min_i = j;
				}
			}
			int temp = a[i];
			a[i] = a[min_i];
			a[min_i] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] a = { 3, 2, 7, 5, 9 };
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		selectionSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}


class InsertionSort {
	static void insertionSort(int[] a) {
		int j = 0;
		for (int i = 1; i < a.length; i++) {
			j = i - 1;
			int key = a[i];
			while (j >= 0 && a[j] < key) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = key;
		}
	}
	
	public static void main(String[] args) {
		int[] a = { 3, 2, 7, 5, 9 };
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		insertionSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}