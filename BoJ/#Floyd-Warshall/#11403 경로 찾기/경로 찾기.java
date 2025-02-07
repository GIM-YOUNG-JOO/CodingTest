import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[][] g = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				g[i][j] = Integer.parseInt(str[j]);
			}
		}

		for (int k = 0; k < n; k++) {
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                if (g[i][k] == 1 && g[k][j] == 1) {
	                    g[i][j] = 1;
	                }
	            }
	        }
	    }

		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g[i].length; j++) {
				sb.append(g[i][j]);
				if (j < g[i].length - 1) {
					sb.append(" ");
				}
			}
			if (i < g.length - 1) {
				sb.append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}