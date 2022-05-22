package com.kundan.algopractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class KthLargestElement {
	public static void main(String[] args) {
		KthLargestElement instance = new KthLargestElement();
		int[] input = {5,4,1,2,3,6,9,8,7};
		int k = 4;
		int kthLargest = instance.findKthLargestElement(input, k);
		instance.display(input, k, kthLargest);
	}
	
	private PriorityQueue<Integer> queue;
	
	public void display(int[] input, int k, int kthLargest) {
		System.out.print("\nInput: k="+k+" elements before sorting: ");
		
		Integer[] sortedInput = new Integer[input.length];
		for (int i=0;i<input.length;i++) {
			sortedInput[i] = input[i];
			System.out.print(input[i]+"->");
		}
		
		Arrays.sort(sortedInput, Comparator.reverseOrder());
		System.out.print("\n elements after sorting: ");
		for (int i:sortedInput) {
			System.out.print(i+"->"); 
		}
		System.out.println("\nKthLargest="+kthLargest);
	}
	
	public Integer findKthLargestElement(int[] elements, int k) {
		if (k > elements.length) {
			throw new IllegalArgumentException("k="+k+" > numElements="+elements.length);
		}
		queue = new PriorityQueue<>(elements.length, Comparator.reverseOrder());
		for (int element:elements) {
			queue.add(element);
		}
		int removedElement = -1;
		for (int i=0; i<k && !queue.isEmpty(); i++) {
			removedElement = queue.remove();
			System.out.print(removedElement+"<-");
		}
		return removedElement;
	}
}
