package ch02.sec01.exam02;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {	
		Scanner scanner = new Scanner(System.in);
		System.out.print("a : "); int a = scanner.nextInt();
		System.out.print("b : "); int b = scanner.nextInt();
		System.out.println(a+" + "+b+" = "+add(a,b));
		System.out.println(a+" - "+b+" = " +sub(a,b));
		System.out.println(a+" * "+b+" = "+mul(a,b));
		System.out.println(a+" / "+b+" = "+div(a,b));
		System.out.println(a+" % "+b+" = "+rest(a,b));	
		
		}
		
	public static int add(int x, int y) {
		return x+y;
	}
	
	public static int sub(int x, int y) {
		return x-y;
		}
	
	public static int mul(int x, int y) {
		return x*y;
	}
	
	public static double div(int x, int y) {
		if(y==0) {
			System.out.println("y값이 0이라 실행 불가");
			return 0;
		}else {
		
		return x/y;
		}
	}
	public static int rest(int x, int y) {
		if(y==0) {
			System.out.println("y값이 0이라 실행 불가");
			return 0;
		}else {
		
		return 0;
		}
	}
}