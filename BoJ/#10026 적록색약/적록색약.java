import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static boolean[][] visit;
	static String[][] grid;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		grid = new String[n][n];
		visit = new boolean[n][n];
		int normal = 0, abnormal = 0;

		for (int i = 0; i < n; i++) {
			grid[i] = br.readLine().split("");
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j]) {
					normal(grid[i][j], i, j);
					normal++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j].equals("R"))
					grid[i][j] = "G";
			}
		}

		visit = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j]) {
					normal(grid[i][j], i, j);
					abnormal++;
				}
			}
		}
		
		System.out.println(normal + " " + abnormal);
	}

	private static void normal(String color, int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { i, j });
		visit[i][j] = true;

		while (!queue.isEmpty()) {
			int[] pos = queue.remove();
			int x = pos[0];
			int y = pos[1];

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny].equals(color)
						&& !visit[nx][ny]) {
					queue.add(new int[] { nx, ny });
					visit[nx][ny] = true;
				}
			}
		}
	}
}