package com.adobe.interview.round1;

/**
 * 
 * You may recall that an array arr is a mountain array if and only if:

    arr.length >= 3
    There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
        arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
        arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.

2, 5, 9, 10, 14, 13, 11, 12, 9, 3, 1


2, 5, 9, 8, 7, 10, 14, 13, 11, 12, 9, 10, 11, 12, 11, 9, 8

M1 = {2, 5, 9, 8, 7}
M2 = {11, 12, 9}
M3 = {9, 10, 11, 12, 11, 9, 8}
 * @author kundan
 *
 */
public class Round1Main {

	public static void main(String[] args) {
		int arr[] = {2, 5, 9, 8, 7, 10, 14, 13, 11, 12, 9, 10, 11, 12, 11, 9, 8};
		int longest = new Round1Main().longestMountain(arr);
		System.out.println("longest="+longest);
	}

	int longestMountain(int[] arr) {
		
		int start = 0, end = 0, i, inflection = 0, longest = 0, len = 0, iteration = 0;
		
		while (start < arr.length && end < arr.length ) {		
			//ascending the mountain: arr[i+1] > arr[i]
			for (i=start; arr[i+1] > arr[i] && (i < arr.length - 2); i++);
			inflection = i;
			if (inflection == start) {
				start = end+1;
				continue;
			}
			//descending the mountain from inflection point
			for (i=inflection; (arr[i] > arr[i+1]) && (i < arr.length-2); i++);
			end = i;
			if (end == inflection) {
				start = end+1;
				continue;
			}
			len = end - start + 1;
			
			if ( len > longest) {
				longest = len;
			}
			
			System.out.println("iteration="+iteration+" start="+start+" inflection="+inflection+" end="+end+" length="+len+" longestSoFar="+longest);
			start = end;
			iteration++;
		}
		return longest;
	}
}

