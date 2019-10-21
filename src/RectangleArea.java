/*
 * https://leetcode.com/problems/rectangle-area/
*/
public class RectangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2; //44
		//int A = -3, B = 0, C = 3, D = 4, E = 0, F = 4, G = 9, H = 5; //33
		//int A = -3, B = 0, C = 3, D = 4, E = -4, F = -1, G = 9, H = 20; //273
		int A = -3, B = 0, C = 3, D = 4, E = -10, F = -1, G = 2, H = 2; //50
		System.out.println(new RectangleArea().computeArea(A, B, C, D, E, F, G, H));
	}

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		
		int area1 = (C-A)*(D-B);
		int area2 = (G-E)*(H-F);		
		
		int left = Math.max(A, E);
		int right = Math.min(C, G);
		int bottom = Math.max(B, F);
		int top = Math.min(D, H);
		
		if(left>=right || bottom>=top)
			return area1+area2;
		else
			return area1+area2-(right-left)*(top-bottom);
	}
}
