/*
Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.

Hint:

Consider the palindromes of odd vs even length. What difference do you notice?
Count the frequency of each character.
If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?

Tags: Hash Table
Similar Problems: (M) Longest Palindromic Substring, (E) Valid Anagram, (M) Palindrome Permutation II

*/

/*
Add each char into map.
Count if odd > 1, false

Note: Iterate HashMap
HashMap.Entry<String, Integer> entry : map.entrySet()
*/

public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
        	return true;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < s.length(); i++) {
        	String str = s.charAt(i) + "";
        	if (!map.containsKey(str)) {
        		map.put(str, 1);
        	} else {
        		map.put(str, map.get(str) + 1);
        	}
        }//ENd for
        int countOdd = 0; 
        for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
        	if (entry.getValue() % 2 == 1) {
        		countOdd++;
        	}
        	if (countOdd > 1) {
        		return false;
        	}
        }//END for
        return true;
    }
}