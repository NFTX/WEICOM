import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {		
		BufferedReader br = null;
		PrintWriter out = new PrintWriter(System.out);
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer input = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(input.nextToken());
            for(int i = 0; i < T; i++) {
            	input = new StringTokenizer(br.readLine());
            	Solution.findSolution(Integer.parseInt(input.nextToken()), Integer.parseInt(input.nextToken()), out);
            }
            out.flush();
        } catch (Exception e) {
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
	}	
}
