public final class Solution {

	private static final int MAX_N = 1000;
	static int[][] stateMatrix = new int[MAX_N][MAX_N+1];
	static int payment;
	static int n;
	static int k;
	static int max;
	static int min;
	static int nextWinnerChange;
	static int nextLoserChange;
	static boolean hasSolution;
	
	public static void findSolution(int participantsQuantity, int wantedPayment) {
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
				if(nextWinnerChange == nextLoserChange-1) {//Finished without solution 
					break; //(I guess this code will be never reached)
				}
				paymentDifference = 2*(-stateMatrix[nextWinnerChange][n] + stateMatrix[nextLoserChange][n] + 1);
				if(k > payment + paymentDifference || paymentDifference > 0) {
					nextLoserChange = n-1;
					nextWinnerChange++;
				} else {
					stateMatrix[nextWinnerChange][nextLoserChange] = 0;
					stateMatrix[nextLoserChange][nextWinnerChange] = 1;
					stateMatrix[nextWinnerChange][n]--;
					stateMatrix[nextLoserChange][n]++;
					nextLoserChange--;
					payment += paymentDifference;
					if (payment == k) { //Solution found
						hasSolution = true;				
					} 
				}
			}
		}
		
		if(hasSolution) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(stateMatrix[i][j]);
				}
				System.out.println("");
			}
			
		} else {
			System.out.println("-1");			
		}
	}
	
	private static void firstTrySolution() {
		payment = 0;
		for(int i = 0; i < n; i++) {
			int j = 0;
			while(j < n){
				if(j > i) {
					stateMatrix[i][j] = 1;
				} else {
					stateMatrix[i][j] = 0;
				}
				j++;
			}
			stateMatrix[i][j] = n-(i+1);
			payment += (n-(i+1))*(n-(i+1));
		}
		if(payment == k) {
			hasSolution = true;
		}
	}
}
