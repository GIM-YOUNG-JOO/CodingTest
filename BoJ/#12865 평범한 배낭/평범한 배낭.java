import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int arr[][] = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[n][k + 1];

		for (int i = 0; i <= k; i++) {
			if (i >= arr[0][0])
				dp[0][i] += arr[0][1];
		}

		for (int product = 1; product < n; product++) {
			for (int weight = 0; weight <= k; weight++) {
				dp[product][weight] = dp[product - 1][weight];
				if (arr[product][0] <= weight) {
					dp[product][weight] = Math.max(dp[product][weight], dp[product - 1][weight - arr[product][0]] + arr[product][1]);
				}
			}
		}

		System.out.println(dp[n - 1][k]);
	}
}