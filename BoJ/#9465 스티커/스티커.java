import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int n = 0; n < tc; n++) {
			int width = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][width + 1];

			for (int i = 0; i < sticker.length; i++) {
				String[] str = br.readLine().split(" ");
				for (int j = 1; j <= width; j++) {
					sticker[i][j] = Integer.parseInt(str[j-1]);
				}
			}

			sb.append(dp(sticker) + "\n");
		}

		sb.setLength(sb.length() - 1);

		System.out.println(sb.toString());
	}

	private static int dp(int[][] sticker) {

		int[][] dp = new int[sticker.length][sticker[0].length];
		dp[0][0] = dp[1][0] = 0;
		dp[0][1] = sticker[0][1];
		dp[1][1] = sticker[1][1];
		for (int i = 2; i < sticker[0].length; i++) {
			dp[0][i] += Math.max(dp[1][i-1], dp[1][i-2]) + sticker[0][i];
			dp[1][i] += Math.max(dp[0][i-1], dp[0][i-2]) + sticker[1][i];
		}

		return Math.max(dp[0][sticker[0].length-1], dp[1][sticker[0].length-1]);
	}
}