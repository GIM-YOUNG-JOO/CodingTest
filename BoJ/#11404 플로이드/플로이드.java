import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] g = new int[n + 1][n + 1];

		for (int[] temp : g) {
			Arrays.fill(temp, Integer.MAX_VALUE);
		}

		for (int i = 0; i < m; i++) {
			String[] str = br.readLine().split(" ");
			int start = Integer.parseInt(str[0]);
			int end = Integer.parseInt(str[1]);
			int price = Integer.parseInt(str[2]);
			g[start][end] = Math.min(g[start][end], price);
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (g[i][k] < Integer.MAX_VALUE && g[k][j] < Integer.MAX_VALUE) {
						if (i != j)
							g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (g[i][j] < Integer.MAX_VALUE)
					bw.write(String.valueOf(g[i][j]));
				else
					bw.write("0");
				
				if(j < n)
					bw.write(" ");
			}
			if(i < n)
				bw.write("\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}