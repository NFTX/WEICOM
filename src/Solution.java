public class Solution {

	private int[][] stateMatrix;
	private int payment;
	int n;
	int k;
	int max;
	int min;
	int nextWinnerChange;
	int nextLoserChange;
	boolean hasSolution;

	public Solution(int participantsQuantity, int wantedPayment) {
		n = participantsQuantity;
		k = wantedPayment;
		max = Boundaries.getMaximum(n);
		min = Boundaries.getMinimum(n);
		nextWinnerChange = 0;
		nextLoserChange = n-1;
		stateMatrix = new int[participantsQuantity][participantsQuantity+2];
		if(k <= max	&& k >= min) {
			findSolution();
		}
	}
	
	private void findSolution() {
		firstTrySolution();
		int paymentDifference;
		while(payment != k) {
			paymentDifference = 2*(-stateMatrix[nextWinnerChange][n] + stateMatrix[nextLoserChange][n] + 1);
			if(k < payment + paymentDifference) {
				if(nextLoserChange > nextWinnerChange+1) {
					nextLoserChange--;
				} else if (nextLoserChange == nextWinnerChange+1) { //There is not any solution
					hasSolution = false;
					break;
				} else {
					nextLoserChange = n-1;
					nextWinnerChange++;
				} 
			} else {
				stateMatrix[nextWinnerChange][nextLoserChange] = 0;
				stateMatrix[nextLoserChange][nextWinnerChange] = 1;
				stateMatrix[nextWinnerChange][n]--;
				stateMatrix[nextLoserChange][n]++;
				payment += paymentDifference;
				if (payment == k) { //Solution found
					hasSolution = true;					
				}
			}
		}
	}
	
	private void firstTrySolution() {		
		for(int i = 0; i < n; i++) {
			int j = 0;
			while(j < n){
				if(j > i) {
					stateMatrix[i][j] = 1;
				}
				j++;
			}
			stateMatrix[i][j] = n-(i+1);
			stateMatrix[i][j+1] = -1;
			payment += (n-(i+1))*(n-(i+1));
		}
		if(payment == k) {
			hasSolution = true;
		}
	}

	public void printSolution() {
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
}
