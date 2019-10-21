
public class Test extends Super{
	public Test() {
		System.out.println("Def");
	}
	
	public Test(int i) {
		//this();
		System.out.println("ctr");
	}
	public static void main(String[] args) {
		new Test(100);
	}
}