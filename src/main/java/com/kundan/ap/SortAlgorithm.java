package com.kundan.ap;

public abstract class SortAlgorithm {

	protected abstract void sort(int[] arr);
	
	protected String display(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<arr.length;i++) {
			sb.append(arr[i]+",");
		}
		return sb.toString();
	}

}

class InsertionSort extends SortAlgorithm {

	@Override
	protected void sort(int[] arr) {
		int i=0;
		
	}
	
	
	
}