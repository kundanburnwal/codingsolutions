package ts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * // anagrams
// loop -> pool
// boot -> boto

message m: array of ASCII chars
phrase p: array of ASCII chars

find all substrings of m that are anagrams of phrase p

return collection of starting indices of message m, such that the substring m[i...j] is an anagram of phrase p

message : abcddbdcda
phrase : ddcb
anagrams are : [1, 4]

 * @author kundan
 *
 */
public class Round3 {

	public static void main(String[] args) {
		AnagramDetector detector = new AnagramDetector("abbdd");
		List<Integer> res = detector.match("bdabdbab");
		
	} 
}

class AnagramDetector {
	private String phrase;
	
	Map<Character, Integer> phraseCharFreq;
	
	//0-25: A-Z //26-51: a-z
	//a=97 ; A=65
	//int charFreq[];
	/**
	 *  AnagramDetector d = new AnagramDetector("ab");
//         List<Integer> matches = d.match("bdabdbab");
	 * @param phrase
	 */
	public AnagramDetector(String phrase) {
		this.phrase = phrase;
		phraseCharFreq = assignFreq(phrase);
	}
	
	//bdabdbab
	// bdabd dabdb abdba bdbab
	public List<Integer> match(String input) {
		
		int lenOfSubstring = phrase.length(); 
		List<Integer> resultIndices = new ArrayList<>();
		
		for (int i=0; i<input.length()-lenOfSubstring; i++) {
			String substr = input.substring(i, i+lenOfSubstring);
			if (isAnagram(substr)) {
				resultIndices.add(i);
			}
		}
		return resultIndices;
	}
	
	private Map<Character, Integer> assignFreq(String phrase) {
		Map<Character, Integer> freq = new HashMap<>();
		for (int i=0; i< phrase.length(); i++) {
			char ch = phrase.charAt(i);
			if (freq.containsKey(ch)) {
				freq.put(ch, freq.get(ch)+1);
			}
		}
		return freq;
	}
	
	//msg: abc ; phrase: bca
	private boolean isAnagram(String input) {
		Map<Character, Integer> resp = assignFreq(input);
		//write code to check if resp map and phraseCharFreq have each and every element along with frquency as same
		return resp.equals(phraseCharFreq);
	}
	
}