package com.kundan.ap;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/majority-element/
Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example :

Input : [2, 1, 2]
Return  : 2 which occurs 2 times which is greater than 3/2. 
 * @author kburnwal
 *
 */
public class MajorityElement {

	public static void main(String[] args) {
		int[] tc1 = {2,1,2};
		System.out.println("TC1:"+majorityElement(tc1));
		
		int[] tc2 = {2,1,2,1,3,2};
		System.out.println("TC2:"+majorityElement(tc2));
		
		int[] tc3 = {100};
		System.out.println("TC3:"+majorityElement(tc3));
		
	}

	static int majorityElement(int[] numbers) {
		if(numbers.length < 2) {
			return numbers[0];
		}
		Map<Integer,Integer> frequency = new HashMap<>();
		
		for(int i=0;i<numbers.length;i++) {
			int num = numbers[i];
			if(frequency.get(num)!=null) {
				int newFreq = frequency.get(num) + 1;
				frequency.put(num,newFreq);
				if(newFreq >= (numbers.length/2)) {
					return num;
				}
			}else {
				frequency.put(num,1);
			}
		}
		
		return -1;
	}
}