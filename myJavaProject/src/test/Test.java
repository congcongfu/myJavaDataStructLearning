package test;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String expression, again;
		int result = 0;
		
		Scanner in = new Scanner(System.in);
		
		do 
		{
			PostfixEvaluator evaluator = new PostfixEvaluator();
			System.out.println("Enter a valid post-fix expression on token"
					+ "at a time with a space  between each token (e.g. 5 5 + 3 2 1 - + *)");
			System.out.println("Each token must be an integer or an operator (+,-,*,/)");
			
			expression = in.nextLine();
			result = evaluator.evaluate(expression);
			System.out.println();
			System.out.println("That expression equals" + " "+result);
			System.out.println("Evaluation anothor expression [Y/N]");
			again = in.nextLine();
			System.out.println();
		}
		while(again.equalsIgnoreCase("y"));
	}

}
