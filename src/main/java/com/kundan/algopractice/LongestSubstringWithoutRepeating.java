package com.kundan.algopractice;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Given a string s, find the length of the longest substring without repeating characters.
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 * @author kundan
 *
 */
public class LongestSubstringWithoutRepeating {
	
	public static void main(String[] args) {
		String input = "pwwwkew";
		System.out.println("input="+input);
		int output = new LongestSubstringWithoutRepeating().longestNonRepeatingSubsequence(input);
		System.out.println("longest substring non-repeating="+output);
	}

	private int longestNonRepeatingSubsequence(String input) {
		//length, subsequence
		Comparator<Entry<Integer, String>> comparator = Comparator.comparing(Map.Entry<Integer, String>::getKey).reversed();
		PriorityQueue<Map.Entry<Integer,String>> sortedSubsequences = new PriorityQueue<>(comparator);
		for (int i=0; i<input.length();i++) {
			int j=i;
			while (j < input.length()-1 && input.charAt(j)!=input.charAt(j+1)) {
				j++;
			}
			String subseq = input.substring(i, j+1);
			int len = subseq.length();
			System.out.println("subseq="+subseq+" len="+len+" i="+i+" j="+j);
			SimpleEntry<Integer, String> entry = new SimpleEntry<Integer, String>(len, subseq);
			sortedSubsequences.add(entry);
			i=j;
		}
		return sortedSubsequences.remove().getKey();
	}
}
