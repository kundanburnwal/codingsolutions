package com.kundan.ap;

public class Merge {

	public static void main(String[] args) {
		int[] A = {14,15,16,17,18};//{1,5,8,11,14};
		int[] B = {2,3,6,7,9, 10, 12, 13};
		int[] C = new int[A.length + B.length];
		Merge mergeInst = new Merge();
		mergeInst.print(A);
		mergeInst.print(B);
		mergeInst.merge(A,B,C);
		mergeInst.print(C);
	}
	
	void merge(int[] A, int[] B, int[] C) {
		int i=0,j=0,k=0;

		while (i < A.length && j < B.length) {
			if (A[i] < B[j]) {
				C[k] = A[i];
				i++;
				k++;
			} else {
				C[k] = B[j];
				j++;
				k++;
			}
		}
		while (i < A.length) {
			C[k] = A[i];
			k++;
			i++;
		}
		while (j < B.length) {
			C[k] = B[j];
			k++;
			j++;
		}
	}
	
	void print(int[] num) {
		
		for (int i:num) {
			System.out.print(i+",");
		}
		System.out.println();
	}
}
