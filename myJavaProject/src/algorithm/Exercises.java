package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Exercises {

	public static void main(String[] args) {
		double[] a = getHight(100, 2);
		System.out.println(a[0]);
		System.out.println(a[1]);

	}
	
	/**
	 * 使用双目计算分数
	 * */
	public static String getScore(int N){
		return  (N>90)?"A":(N>80?"B":(N>70)?"C":"D");
	}
	
	/**
	 * 输入两个正整数m和n，求其最大公约数和最小公倍数
	 * */
	public static String gcdAndLcm(int a, int b){
		StringBuffer stringBuffer = new StringBuffer();
		int big,small;
		int gcd,lcm;
		if(a > b){
			big = a;
			small = b;
		}else{
			big = b;
			small = a;
		}
		stringBuffer.append(a).append(" ").append(b).append("'s ");
		gcd = gcd(big, small);
		stringBuffer.append("gcd is ").append(gcd).append(" ");
		lcm= lcm(big,small);
		stringBuffer.append("lcm is ").append(lcm);
		return stringBuffer.toString();
	}

	private static int lcm(int big, int small) {
		int lcm = big * small / gcd(big, small);
		return lcm;
	}

	public static int gcd(int big, int small) {
		if( big % small == 0)
			return small;
		else {
			int c = big % small;
			return gcd(small, c);
		}
	}
	/****************************************************************************************************/
	
	/**
	 * 题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
	 * */
	public static String statistics(String word){
		int charCount = 0;
		int spaceCount = 0;
		int numCount = 0;
		int otherCount = 0;
		StringBuffer stringBuffer = new StringBuffer();
		char[] ch = word.toCharArray();
		for(int i = 0; i < ch.length; i++ ){
			if(Character.isDigit(ch[i])){
				numCount++;
			}else if (Character.isLetter(ch[i])) {
				charCount++;
			}else if (Character.isSpaceChar(ch[i])) {
				spaceCount++;
			}else {
				otherCount++;
			}
		}
		stringBuffer.append("字母个数 = ").append(charCount).append(",");
		stringBuffer.append("数字个数 = ").append(numCount).append(",");
		stringBuffer.append("其他字符个数 = ").append(charCount).append(",");
		stringBuffer.append("空格数= ").append(spaceCount);
		return stringBuffer.toString();
	}
	
	/*****************************************************************************************/
	/**
	 * 一个数如果恰好等于它的因子之和，这个数就称为"完数"。 例如6=1＋2＋3.编程 找出1000以内的所有完数。
	 * 
	 * */
	public static void wushu(){
		for(int j = 0; j < 999; j++){
			int num =j;
			List<Integer> list = factorList(num);
			int result = 0;
			for(int i = 0; i< list.size(); i++){
				result += list.get(i);
			}
			if(num == result)
				System.out.println(num);
		}
	}
	
	public static List<Integer> factorList(int num){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		if(num > 1){
			int k = 2;
			while (num > k) {
				if(num % k == 0){
					list.add(k);
					num = num / k;
				}else {
					k++;
				}
			}
			list.add(k);
		}
		
		return list;
	}
	
	/**
	 *  题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半；
	 *  再落下，求它在   第10次落地时，共经过多少米？第10次反弹多高？ 
	 * */
	public static double[] getHight(double hight, int times){
		double route = 0;
		double[] result = new double[2];
		for(int i=1; i<= times; i++){
			if(i==1){
				route +=hight;
			}else if(i >1) {
				route += 2*hight;
			}
			
			hight = hight/2;
		}
		result[0] = route;
		result[1] = hight;
		return result;
	}

}








































