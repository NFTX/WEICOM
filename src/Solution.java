import java.io.PrintWriter;

public final class Solution {

	private static final int MAX_N = 1000;
	static int[] stateMatrix = new int[MAX_N+1];
	static boolean[][] matchResult = new boolean[MAX_N][MAX_N];
	static int payment;
	static int n;
	static int k;
	static int max;
	static int min;
	static int nextWinnerChange;
	static int nextLoserChange;
	static boolean hasSolution;
	
	
	public static void findSolution(int participantsQuantity, int wantedPayment, PrintWriter out) {
		n = participantsQuantity;
		k = wantedPayment;
		max = Boundaries.getMaximum(n);
		min = Boundaries.getMinimum(n);
		nextWinnerChange = 0;
		nextLoserChange = n-1;		
		hasSolution = false;
		
		if(k <= max && k >= min && (max-k)%2 == 0) {			
			firstTrySolution();
			int paymentDifference;
			while(payment != k) {
				paymentDifference = 2*(-stateMatrix[nextWinnerChange] + stateMatrix[nextLoserChange] + 1);
				if(k > payment + paymentDifference || paymentDifference > 0) {
					nextLoserChange = n-1;
					nextWinnerChange++;
				} else {
					matchResult[nextWinnerChange][nextLoserChange] = false;
					matchResult[nextLoserChange][nextWinnerChange] = true;
					stateMatrix[nextWinnerChange]--;
					stateMatrix[nextLoserChange]++;
					nextLoserChange--;
					payment += paymentDifference;
					if (payment == k) { //Solution found
						hasSolution = true;				
					} 
				}
			}
		}
		printSolution(out);
	}
	
	private static void firstTrySolution() {
		payment = 0;
		for(int i = 0; i < n; i++) {
			for(int j =i+1; j < n; j++) {
				matchResult[i][j] = true;
			}
			stateMatrix[i] = n-(i+1);
			payment += i*i; // this is the same as payment += (n-(i+1))*(n-(i+1)); in the reverse order
		}
		if(payment == k) {
			hasSolution = true;
		}
	}
	
	private static void printSolution(PrintWriter out) {
		if(hasSolution) {
			for(int i = 0; i < n; i++) {				
				for(int j = 0; j < n; j++) {			
					out.print(matchResult[i][j] ? "1" : "0");
				}
				out.println();
			}
		} else {
			out.println("-1");			
		}
	}
}
