package Ch06;

import java.util.Scanner;

public class FactorialTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("수를 입력하세요: ");
		int a = scanner.nextInt();
		int result = factorial(a);
		
		System.out.println(a+"! = "+result);
	}
	static int factorial(int n) {
		int result=0;
		
		if (n==1)
			result = 1;
		else
			result = n * factorial(n-1); //다시 메서드 자신을 호출
		
		return result;
	}

}
