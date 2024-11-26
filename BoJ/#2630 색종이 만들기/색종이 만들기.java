import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int white = 0;
	static int blue = 0;
	static int[][] paper;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		paper = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(str[j]);
			}
		}
		color(n, 0, 0);
		
		System.out.println(white + "\n" + blue);
	}

	private static void color(int n, int x, int y) {
		int color = paper[x][y];
		int wrong = 0;
		boolean flag = false;
		if (n > 1) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (color != paper[x + i][y + j]) {
						flag = true;
						break;
					}
				}
				if (flag)
					break;
			}
			if (flag) {
				color(n / 2, x, y);
				color(n / 2, x, y + n / 2);
				color(n / 2, x + n / 2, y);
				color(n / 2, x + n / 2, y + n / 2);
			} else {
				if (color == 0)
					white++;
				else
					blue++;
			}
		} else {
			if (color == 0)
				white++;
			else
				blue++;
		}
	}
}