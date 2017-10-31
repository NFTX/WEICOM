import java.io.PrintWriter;

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
		hasSolution = false;
		stateMatrix = new int[participantsQuantity][participantsQuantity+2];
		findSolution();
	}
	
	private boolean isImpossible() {
		if(k > max|| k < min) {
			return true;
		}
		if((max-k)%2 == 1) { //See suppositions.txt
			return true;
		}
		return false;
	}
	
	private void findSolution() {
		if(isImpossible()) {
			return;
		}
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

	public void printSolution(PrintWriter out) {
		if(hasSolution) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					out.print(stateMatrix[i][j]);
				}
				out.println();
			}
			
		} else {
			out.println(-1);			
		}
		
	}
}
