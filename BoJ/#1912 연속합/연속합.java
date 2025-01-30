import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];

		String[] str = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}

		dp[0] = arr[0];

		for (int i = 1; i < n; i++) {
			if (dp[i - 1] < 0)
				dp[i] = arr[i];
			else
				dp[i] = dp[i - 1] + arr[i];
		}

		Arrays.sort(dp);

		System.out.println(dp[n - 1]);
	}
}