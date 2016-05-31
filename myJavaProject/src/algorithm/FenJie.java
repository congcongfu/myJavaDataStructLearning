package algorithm;

import java.util.ArrayList;
import java.util.List;

public class FenJie {

	/**
	 * 题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5
	 * 
	 * 分析：先找到最小的质数k，（1）如果这个质数恰等于n，则说明分解质因数的过程结束。
	 * （2）如果 n > k,但n能被k整除，则应打印出k的值，并用n除以k的商，作为新的正整数n，重复执行第一步
	 * （3）如果n不能被k整除，则用k+1作为k的值
	 * 最小的质数为2，先从2开始
	 * */
	public static void main(String[] args) {
		System.out.println(fenJie(88));
	}
	
	public static String fenJie(int num){
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(num).append(" = ");
		int k = 2;
		while(num > k){
			if(num % k == 0){
				stringBuffer.append(k).append("*");
				num = num /k;
			}else {
				k++;
			}
		}
		stringBuffer.append(k);
		return stringBuffer.toString();
	}
	

}

























