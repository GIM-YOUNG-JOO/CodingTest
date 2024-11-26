import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] map;
	static int[][] answer;
	static boolean[][] visit;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);

		map = new int[n][m];
		answer = new int[n][m];
		visit = new boolean[n][m];
		int[] target = new int[2];

		for (int i = 0; i < n; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] == 2) {
					target[0] = i;
					target[1] = j;
				}
			}
		}

		bfs(target[0], target[1]);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visit[i][j])
					answer[i][j] = -1;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (j < m - 1)
					System.out.print(answer[i][j] + " ");
				else
					System.out.print(answer[i][j]);
			}
			System.out.println();
		}
	}

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { i, j });
		answer[i][j] = 0;
		visit[i][j] = true;

		while (!queue.isEmpty()) {
			int[] pos = queue.remove();
			int x = pos[0];
			int y = pos[1];

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && ny >= 0 && nx < map.length
						&& ny < map[0].length && map[nx][ny] == 1
						&& !visit[nx][ny]) {
					queue.add(new int[] { nx, ny });
					visit[nx][ny] = true;
					answer[nx][ny] = answer[x][y] + 1;
				}
			}
		}
	}
}