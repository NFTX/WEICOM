import java.util.ArrayList;

public class Solution {

	private ArrayList<String> competitorScore;
	private int n;
	private int k;
	
	public Solution(int participantsQuantity, int wantedPayment) {
		n = participantsQuantity;
		k = wantedPayment;
	}
	
	public ArrayList<String> getCompetitorScore() {
		return competitorScore;
	}
	
	private boolean isOverMax() {
		//TODO implement
		return n > 3;
	}

	public void printSolution() {
		if(competitorScore.isEmpty() || isOverMax()) {
			System.out.println("-1");
		} else {
			for (String compScore : competitorScore) {
				System.out.println(compScore);
			}
		}
		
	}
}
