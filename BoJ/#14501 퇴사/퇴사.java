import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str;

		int n = Integer.parseInt(br.readLine());

		int[] t = new int[n];
		int[] p = new int[n];
		int[] dp = new int[n + 1];

		for (int i = 0; i < n; i++) {
			str = br.readLine().split(" ");
			t[i] = Integer.parseInt(str[0]);
			p[i] = Integer.parseInt(str[1]);
		}

		for (int i = 0; i < n; i++) {
			if (i + t[i] <= n) {
				dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
			}
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}
		System.out.println(dp[n]);
	}
}