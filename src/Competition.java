public class Competition {
	private int participantsQuantity;
	private int wantedPayment;
	private Solution solution;
	
	public Competition(int n, int k) {
		setParticipantsQuantity(n);
		setWantedPayment(k);
		solution = new Solution(n, k);
	}

	public int getParticipantsQuantity() {
		return participantsQuantity;
	}

	public void setParticipantsQuantity(int participantsQuantity) {
		this.participantsQuantity = participantsQuantity;
	}

	public int getWantedPayment() {
		return wantedPayment;
	}

	public void setWantedPayment(int wantedPayment) {
		this.wantedPayment = wantedPayment;
	}
	
	public Solution getSolution() {
		return solution;
	}
}
