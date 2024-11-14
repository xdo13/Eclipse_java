package Ch12;

import java.util.ArrayList;
import java.util.List;

//원래 형태
class Fruit {
	public String toString() {
		return "Fruit";
		}
	}
//한줄로 만든 형태
class Apple extends Fruit    {public String toString() {return "Apple";}}
class Grape extends Fruit    {public String toString() {return "Grape";}}
class Toy   				 {public String toString() {return "Toy";}}


class FruitBoxEx1 {
	public static void main(String[] args) {
		Box<Fruit> fruitBox = new Box<Fruit>(); //양쪽이 동일할 때 생략 가능(Fruit)
		Box<Apple> appleBox = new Box<>();
		Box<Toy> toyBox = new Box<>();
//		Box<Fruit> grapeBox = new Box<Apple>();  //에러 타입 불일치
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());  //OK. void add(Fruit item)
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
	//  appleBox.add(new Toy());  // 에러 Apple만 담을 수 있음
		
		toyBox.add(new Toy());
		
		System.out.println(fruitBox);
		System.out.println(appleBox);
		System.out.println(toyBox);
	}// main의 끝

}

class Box<T> {
	List<T> list = new ArrayList<T>();
	void add(T item) {list.add(item);}
	T get(int i)      {return list.get(i);}
	int size()        {return list.size();}
	public String toString() {return list.toString();}
}