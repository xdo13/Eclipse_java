package Ch06;
//생성자 기본 생성
class Data1{
	int value;
}

class Data2 {
	int value;
	Data2(int x) {
		value = x;
	}
}
public class ConstructorTest {

	public static void main(String[] args) {
		Data1 d1 = new Data1();
		Data2 d2 = new Data2(10);     //10의 인자가 없을때 컴파일 에러 발생		

	}

}
