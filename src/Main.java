import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		Challenge challenge = readInput();
		
		for (Iterator<Competition> iterator = challenge.getCompetition().iterator(); iterator.hasNext();) {
			Competition comp = iterator.next();
			Solution s = new Solution(comp.getParticipantsQuantity(),comp.getWantedPayment());
			s.printSolution();
		}
	}	
	private static Challenge readInput() {
		Challenge result = new Challenge();
		BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer input = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(input.nextToken());
            for(int i = 0; i < T; i++) {
            	input = new StringTokenizer(br.readLine());
            	int n = Integer.parseInt(input.nextToken());
            	int k = Integer.parseInt(input.nextToken());
            	Competition comp = new Competition(n,k);
            	result.addCompetition(comp);
            }
        } catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}catch (NoSuchElementException e) {
			e.printStackTrace();
		} 
        finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return result;
	}
}
