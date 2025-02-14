import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] grid;
	static int minus = 0, zero = 0, plus = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		grid = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				grid[i][j] = Integer.parseInt(input[j]);
			}
		}

		divide(0, 0, n);
		System.out.println(minus + "\n" + zero + "\n" + plus);
	}

	static void divide(int row, int col, int size) {
		int type = grid[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (grid[i][j] != type) {
					int newSize = size / 3;
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							divide(row + a * newSize, col + b * newSize, newSize);
						}
					}
					return;
				}
			}
		}

		switch (type) {
		case -1:
			minus++;
			break;
		case 0:
			zero++;
			break;
		case 1:
			plus++;
			break;
		}
	}
}