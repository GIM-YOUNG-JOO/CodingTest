import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	static boolean[][][] visit;
	static int[] dx = { 0, 1, 0, -1, 0, 0};
	static int[] dy = { 1, 0, -1, 0, 0, 0};
	static int[] dz = { 0, 0, 0, 0, -1, 1};
	static int day = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");

		int m = Integer.parseInt(str[0]);
		int n = Integer.parseInt(str[1]);
		int h = Integer.parseInt(str[2]);

		int[][][] tomato = new int[n][m][h];
		Stack<int[]> even = new Stack<int[]>();
		visit = new boolean[n][m][h];

		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				str = br.readLine().split(" ");
				for (int j = 0; j < m; j++) {
					tomato[i][j][k] = Integer.parseInt(str[j]);
					if (tomato[i][j][k] == 1)
						even.add(new int[] { i, j, k });
				}
			}
		}

		bfs(tomato, even, n, m, h);

		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (tomato[i][j][k] == 0) {
						System.out.println("-1");
						System.exit(0);
					}
				}
			}
		}

		System.out.println(day);
	}

	private static void bfs(int[][][] tomato, Stack<int[]> even, int n, int m, int h) {
		Queue<int[]> queue = new LinkedList<int[]>();

		while (!even.isEmpty()) {
			int[] direct = even.pop();
			visit[direct[0]][direct[1]][direct[2]] = true;

			queue.add(direct);
		}

		while (!queue.isEmpty()) {
			boolean flag = false;
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int[] direct = queue.remove();
				int x = direct[0];
				int y = direct[1];
				int z = direct[2];
				tomato[x][y][z] = 1;

				for (int i = 0; i < 6; i++) {
					int nX = x + dx[i];
					int nY = y + dy[i];
					int nZ = z + dz[i];

					if (nX < n && nY < m && nZ < h && nX >= 0 && nY >= 0 && nZ >= 0
							&& !visit[nX][nY][nZ] && tomato[nX][nY][nZ] == 0) {
						queue.add(new int[] { nX, nY, nZ });
						visit[nX][nY][nZ] = true;
						flag = true;
					}
				}
			}

			if (flag)
				day++;

		}
	}
}