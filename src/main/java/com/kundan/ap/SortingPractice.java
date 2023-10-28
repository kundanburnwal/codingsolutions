/**
 * 
 */
package com.kundan.ap;


/**
 * @author kundan
 *
 */
public class SortingPractice {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MergeSortInternal msi = new MergeSortInternal();
		int[] a = {2,3,7,8,1,4,5,9};
		//int[] a = {4,2,3,8,1,9,5,4};
		//int[] a = {4,2,3,8,1,9,5,4};
		//int[] a = {4,2,3,8,1,9,5,4};
		//int[] a = {4,2,3,8,1,9,5,4};
		//int[] a = {4,2,3,8,1,9,5,4};
		int N = a.length;
		System.out.println("Before merge: "+msi.display(a));		
		int res[] = msi.merge(a, 0, (N/2 - 1), N/2, N-1);
		System.out.println("After merge: "+msi.display(res));
	}

}

class MergeSortInternal extends SortAlgorithm {
	/**
	 * Merges two sorted sub-arrays
	 * The whole set of numbers is stored in input array
	 * @param array
	 * @param a1start start index of first sorted (sub)array
	 * @param a1end end index of first sorted (sub)array
	 * @param a2start start index of second sorted (sub) array
	 * @param a2end end index of second sorted (sub) array
	 * @return the resultant array which is merged and yet sorted
	 */
	int[] merge(int[] array, int a1start, int a1end, int a2start, int a2end) {
		int[] res = new int[array.length];
		
		int i1=a1start, i2=a2start, ri = 0;
		
		while (i1 <= a1end && i2 <= a2end && ri < res.length) {
			if (array[i1] < array[i2]) {
				res[ri++] = array[i1];
				i1++;
			} else {
				res[ri++] = array[i2];
				i2++;
			}
			System.out.println("After iteration:"+ri+" result="+display(res));
		}
		
		while (i1 <= a1end && ri < res.length) {
			res[ri++] = array[i1];
			i1++;
		}
		
		while (i1 <= a2end && ri < res.length) {
			res[ri++] = array[i2];
			i2++;
		}
		return res;
	}

	@Override
	protected void sort(int[] arr) {
		// TODO Auto-generated method stub
		
	}
}