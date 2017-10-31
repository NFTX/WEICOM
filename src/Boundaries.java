public final class Boundaries {
	private static final int MAX_N = 1000;
	private static int[] maximum = new int[MAX_N+1];
	private static int[] minimum = new int[MAX_N+1];
	
	private Boundaries() {		
		maximum[0] = 1; //last calculated position		
	}
	
	public static int getMaximum(int n) {
		if(n < 2 || n > MAX_N) {
			System.err.println("Invalid value for N");
			return -1;
		}
		if(maximum[n] == 0) {			 
			fillMaxUntil(n);
		}
		return maximum[n];
	}
	
	private static void fillMaxUntil(int n) {
		for(int i = maximum[0]+1; i <= n; i++) {
			maximum[i] = maximum[i-1] + (i-1)*(i-1); 
		}
		if(maximum[0] < n){
			maximum[0] = n;
		}
	}
	
	public static int getMinimum(int n) {
		if(n < 2 || n > MAX_N) {
			System.err.println("Invalid value for N");
			return -1;
		}
		if(minimum[n] == 0) {			 
			return fillMin(n);
		} else {
			return minimum[n];
		}
		
	}
	
	private static int fillMin(int n) {
		if(n%2 == 0) {
			minimum[n] = (n*n +(n-2)*(n-2))*n/8; //== (n/2)*(n/2)*n/2 + ((n-2)/2)*((n-2)/2)*n/2
			return minimum[n];
		} else {
			minimum[n] = (n-1)*(n-1)*n/4;
			return minimum[n];
		}
	}
}
