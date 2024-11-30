import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] answer = new long[n];
		answer[0] = 1;
		if (n > 1) {
			answer[1] = 2;
		}
		for (int i = 2; i < n; i++) {
			answer[i] = (answer[i - 2] + answer[i - 1]) % 10007;
		}

		System.out.println(answer[n - 1]);
	}
}