
public class Test {
	
	public class Haha{
		
	}
	
	public Test(int i) {
		//this();
		System.out.println("ctr");
	}
	public static void main(String[] args) {
		Haha h = new Test(100).new Haha();
		
	}
}