package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.omg.CORBA.StringHolder;

import test.stackTest;

public class CharAndArrayExecise {

	public static void main(String[] args) {
		String string = "asjfjfjwekgjjfsjfsjfsjfdgnmvvetsdf";
		int a = lengthOfLongestSubstringTwoDistict(string);
	}

	/**
	 * with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. 
	 * How many different ways do you know to solve this problem?
	 * */
	public static int[] rotate1(int index, int len){
		int[] a = new int[len+index];
		for(int i = 0; i < len; i++){
			a[i] = i+1;
		}
		for(int i=0; i< index; i++){
			a[len+i] = a[i];
		}
		for(int i = 0; i <a.length-index; i++){
			a[i] = a[i+index];
		}
		for(int i = 0; i<a.length;i++){
			System.out.println(a[i]);
		}
		return a;		
	}
	public static void rotate2(int[] nums, int k) {
	    if(k > nums.length) 
	        k=k%nums.length;
	 
	    int[] result = new int[nums.length];
	 
	    for(int i=0; i < nums.length -k; i++){
	        result[i] = nums[k+i];
	    }
	 
	    for(int i=0; i<k; i++){
	        result[nums.length -k+i] = nums[i];
	    }
	 
	    for(int i = 0; i <result.length; i++){
	    	System.out.println(result[i]);
	    }
	}
	
	/*速度太慢*/
	public static void rotate3(int[] arr,int order){
		if(arr == null || order < 0)
			throw new IllegalArgumentException("Illegal argument!");
		for(int i = 0; i < order; i++){
			for(int j = 0; j < arr.length-1 ; j++){
				int temp = arr[j];
				arr[j] = arr[j +1];
				arr[j +1] = temp;
			}
		}
		for(int a : arr){
			System.out.println(a);
		}
	}
	
	/**
	 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
	 *  Return all such possible sentences. For example, given s = "catsanddog", 
	 *  dict = ["cat", "cats", "and", "sand", "dog"], the solution is ["cats and dog", "cat sand dog"].
	 * */
	public static List<String> wordBreak(String s, Set<String> dict){
		List<String> dp[] = new ArrayList[s.length()+1];
		dp[0] = new ArrayList<String>();
		for(int i = 0; i < s.length(); i++){
			if(dp[i] == null)
				continue;
			for(String word: dict){
				int len = word.length();
				int end = i +len;
				if(end >s.length())
					continue;
				if(s.substring(i, end).equals(word)){
					if(dp[end] == null){
						dp[end] = new ArrayList<String>();
					}
					dp[end].add(word);
				}
			}
		}
//		for(int i = 0; i< s.length(); i++){
//			for(String word: dict){
//				int len = word.length();
//				int end = i+len;
//				if(end<=s.length()){
//					if(s.substring(i,end).equals(word)){
//						if(dp[end] == null){
//							dp[end] = new ArrayList<String>();
//						}
//						dp[end].add(word);
//						
//					}
//				}
//				
//			}
//		}
		List<String> result = new LinkedList<String>();
		if(dp[s.length()] == null)
			return result;
		ArrayList<String> temp = new ArrayList<String>();
		dfs(dp, s.length(), result, temp);
		return result;
	}

	private static void dfs(List<String>[] dp, int end, List<String> result, ArrayList<String> temp) {
		if(end <= 0){
			String path = temp.get(temp.size() -1);
			for(int i = temp.size() -2; i >= 0; i--){
				path +=" "+ temp.get(i); 
			}
			result.add(path);
			return;
		}
		for(String string: dp[end]){
			temp.add(string);
			dfs(dp, end-string.length(), result, temp);
			temp.remove(temp.size() -1);
		}
	}
	
	
	/**
	 * 
	 * Given an array of integers, find two numbers such that they add up to a specific target number.
	 *
	 *The function twoSum should return indices of the two numbers such that they add up to the target,
	 *where index1 must be less than index2. Please note that your returned answers 
	 *(both index1 and index2) are not zero-based.
	 *
	 *For example:
	 *Input: numbers={2, 7, 11, 15}, target=9
	 *Output: index1=0, index2=1
	 *use index as value, value as key
	 * */
	public static int[] findIndex(int[] numbers, int target){
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0; i < numbers.length; i++){
			if(map.containsKey(numbers[i])){
				int index = map.get(numbers[i]);
				result[0] = index;
				result[1] = i;
				break;
			}else{
				map.put(target - numbers[i], i);
			}
		}
		
		return result;
	}
	
	/**
	 * Given a string, find the longest substring that contains only two unique characters. 
	 * For example, given "abcbbbbcccbdddadacb",
	 *  the longest substring that contains 2 unique character is "bcbbbbcccb".
	 * */
	public static String findLongestContains(String string){
		String result = "";
		return result;
	}
	
	public static int lengthOfLongestSubstringTwoDistict(String s){
		int max = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0;
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(map.containsKey(c)){
				map.put(c,map.get(c)+1);
			}else {
				map.put(c, 1);
			}
			if(map.size() > 2){
				max = Math.max(max, i-start);
				while(map.size() > 2){
					char t = s.charAt(start);
					int count = map.get(t);
					if(count >1){
						map.put(t, count -1);
					}else {
						map.remove(t);
					}
					start++;
				}
			}
		}
		max = Math.max(max, s.length() - start);
		return max;
	}
	
}

































