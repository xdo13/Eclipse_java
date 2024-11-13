package Ch09;

class Cards{
	String kind;
	int number;
	
	Cards() {
		this("SPADE", 1);
	}
	Cards(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}
	public String toString() {
		return "kind : " + kind + ", number : " + number;
	}
}
public class cardToString2 {
	public static void main(String[] args) {
		Cards c1 = new Cards();
		Cards c2 = new Cards("HEART", 10);
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
	}

}
