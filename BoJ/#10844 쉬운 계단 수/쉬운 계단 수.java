import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		long[][] dp = new long[n + 1][10];

		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}

		for (int digit = 2; digit <= n; digit++) {
			for (int i = 0; i <= 9; i++) {
				if (i - 1 >= 0)
					dp[digit][i] = (dp[digit][i] + dp[digit - 1][i - 1]) % 1000000000;
				if (i + 1 < 10)
					dp[digit][i] = (dp[digit][i] + dp[digit - 1][i + 1]) % 1000000000;
			}
		}
		
		long answer = 0;
		
		for (int i = 0; i <= 9; i++) {
			answer = (answer + dp[n][i]) % 1000000000;
		}
		System.out.println(answer);
	}
}

