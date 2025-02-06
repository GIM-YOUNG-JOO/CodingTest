import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < tc; i++) {
			int n = Integer.parseInt(br.readLine());
			
			int a = n / 2;
			int b = a;
			
			while(true) {
				if(eratosthenes(a) && eratosthenes(b)) {
					sb.append(a + " " + b + "\n");
					break;
				} else {
					a--;
					b++;
				}
			}
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
	
	private static boolean eratosthenes(int num) {
		if (num == 1)
	        return false;
	    
	    for(int i = 2; i <= Math.sqrt(num); i++){
	        if(num % i == 0)
	            return false;
	    }
	    return true;
	}
}