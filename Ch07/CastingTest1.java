package Ch07;

import Ch07.Car;
import Ch07.FireEngine;

public class CastingTest1 {

	public static void main(String[] args) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water();
		car = fe;           // car= (Car)fe;에서 형변환이 생략된 형태
		//car.water(); 조상이 후손것을 쓸수는 없다~
		fe2 = (FireEngine)car;
		fe2.water();
	}
}
class Car {    
	String color;
	int door;
	
	void drive() {            //운전기능
		System.out.println("drive, Brrrr!");
	}
	
	void stop() {  //멈추는 기능
		System.out.println("stop!!!");
	}
}
class FireEngine extends Car {  //소방차
	void water() {
		System.out.println("water!!!");
	}
}
