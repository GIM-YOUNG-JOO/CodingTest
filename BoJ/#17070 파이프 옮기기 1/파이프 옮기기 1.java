import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] home = new int[n][n];
        int[][][] dp = new int[n][n][3];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                home[i][j] = Integer.parseInt(str[j]);
            }
        }
        dp[0][1][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (home[i][j] == 1)
                    continue;
                if (j - 1 >= 0)
                    dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][1];
                if (i - 1 >= 0)
                    dp[i][j][2] += dp[i - 1][j][1] + dp[i - 1][j][2];
                if (i - 1 >= 0 && j - 1 >= 0 && home[i][j - 1] != 1 && home[i - 1][j] != 1)
                    dp[i][j][1] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
            }
        }
        System.out.println(dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2]);
    }
}