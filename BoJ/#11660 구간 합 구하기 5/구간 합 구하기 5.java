import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] str = br.readLine().split(" ");

		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);

		int[][] table = new int[n + 1][n + 1];
		int[][] section = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			str = br.readLine().split(" ");
			for (int j = 1; j <= n; j++) {
				table[i][j] = Integer.parseInt(str[j - 1]);
				section[i][j] = section[i - 1][j] + section[i][j - 1] - section[i - 1][j - 1] + table[i][j];
			}
		}

		for (int t = 0; t < m; t++) {
			str = br.readLine().split(" ");
			int x1 = Integer.parseInt(str[0]);
			int y1 = Integer.parseInt(str[1]);
			int x2 = Integer.parseInt(str[2]);
			int y2 = Integer.parseInt(str[3]);
			int sum =  section[x2][y2] - section[x1-1][y2] - section[x2][y1-1] + section[x1-1][y1-1];
			sb.append(sum + "\n");
		}

		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}