import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()) - 1;

		int[] dist = new int[n];
		int city;
		int min = Integer.MAX_VALUE;
		BigInteger answer = BigInteger.valueOf(0);

		String[] input = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			dist[i] = Integer.parseInt(input[i]);
		}

		input = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			city = Integer.parseInt(input[i]);
			min = Math.min(min, city);
			answer = answer.add(BigInteger.valueOf(dist[i]).multiply(BigInteger.valueOf(min)));
		}
		
		System.out.println(answer);
	}
}
