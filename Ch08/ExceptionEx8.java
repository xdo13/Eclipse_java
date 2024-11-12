package Ch08;

public class ExceptionEx8 {

	public static void main(String[] args) {
	System.out.println(1);
	System.out.println(2);
	try {
		System.out.println(3);
		System.out.println(0/0);  //예외 발생
		System.out.println(4);  // 실행 X
	}catch (ArithmeticException ae) {
		ae.printStackTrace();
		System.out.println("예외 메시지 : " + ae.getMessage());
	} //try catch의 끝
	System.out.println(6);
	}// main메서드 끝
}
