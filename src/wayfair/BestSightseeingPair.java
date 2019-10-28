/*
 * https://leetcode.com/problems/best-sightseeing-pair/
*/
package wayfair;

public class BestSightseeingPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[] { 8, 1, 5, 2, 6 };

		System.out.println(new BestSightseeingPair().maxScoreSightseeingPair(A));
	}

	private int score(int[] A, int i, int j) {
		return A[i] + A[j] + i - j;
	}

	public int maxScoreSightseeingPair(int[] A) {
		int maxScore = Integer.MIN_VALUE;

		if (A != null)
			for (int i = 0; i < A.length; i++)
				for (int j = i + 1; j < A.length; j++)
					maxScore = Math.max(maxScore, score(A, i, j));

		return maxScore;
	}
}
