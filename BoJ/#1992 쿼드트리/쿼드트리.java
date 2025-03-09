import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] video;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		video = new int[n][n];

		for (int i = 0; i < n; i++) {
			input = br.readLine();
			for (int j = 0; j < n; j++) {
				video[i][j] = input.charAt(j) - 48;
			}
		}
		quadTree(0, 0, n, sb);

		System.out.println(sb.toString());
	}

	private static void quadTree(int x, int y, int n, StringBuilder sb) {
		int start = video[x][y];

		if (isSame(start, x, y, n)) {
			sb.append(start);
			return;
		} else {
			int half = n / 2;
			sb.append("(");
			quadTree(x, y, half, sb);
			quadTree(x, y + half, half, sb);
			quadTree(x + half, y, half, sb);
			quadTree(x + half, y + half, half, sb);
			sb.append(")");
			return;
		}

	}

	private static boolean isSame(int start, int x, int y, int n) {

		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (start != video[i][j]) {
					return false;
				}
			}
		}

		return true;
	}
}