package algorithm;

public class Rabbit {
	/**
	 * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
	 * 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少对？ 
	 * 分析：除了第一，和第二个月每个月的兔子数量都是前两个月兔子数量相加
	 * 兔子需要两个月才能成熟所以当前月的兔子数量为前一个月的数量的兔子数量 加上能够生育的兔子的数量即前面两个月兔子数量的总和
	 * 
	 * 如果成熟的时间变了的话，改一下递归里面的参数就好了，如果成熟的时间为3个月
	 * 则递归可以写成   fib（n-1）* fib（n-3）；
	 * */
	public static void main(String [] args){
		int month =10;
		System.out.println(amount(month));
		System.out.printf("%s个月后兔子数量为 %s \n", month,fib(month));
	}
	
	public static long amount(int month){
		long f1 = 1L, f2 = 1L;
		long f = 1;
		for(int i = 2; i < month; i++){
			f = f1 + f2;
			f1 = f2;
			f2 = f;
		}
		return f;
	}
	
	public static int fib(int month){
		if(month == 1 || month == 2)
			return 1;
		else 
			return fib(month -1) + fib(month -2);
	}
	
}















