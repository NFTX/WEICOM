import java.util.ArrayList;
import java.util.List;

public class Challenge {
	private List<Competition> competitions;
	
	public Challenge() {
		competitions = new ArrayList<>();
	}

	public void addCompetition(Competition comp) {
		this.competitions.add(comp);
	}
	
	public List<Competition> getCompetition() {
		return competitions;
	}
}
