import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] maze = new int[n][m];
		boolean[][] visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				maze[i][j] = str.charAt(j) - 48;
			}
		}

		System.out.println(minBfs(visit, maze));
	}

	private static int minBfs(boolean[][] visit, int[][] maze) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { 0, 0 });
		int count = 1;
		visit[0][0] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int t = 0; t < size; t++) {
				int[] direct = queue.poll();
				int x = direct[0];
				int y = direct[1];
				if(x == maze.length-1 && y == maze[0].length-1)
					return count;
				
				for (int i = 0; i < 4; i++) {
					int nX = x + dx[i];
					int nY = y + dy[i];

					if (nX >= 0 && nY >= 0 && nX < maze.length && nY < maze[0].length && !visit[nX][nY]
							&& maze[nX][nY] != 0) {
						queue.offer(new int[] { nX, nY });
						visit[nX][nY] = true;
					}
				}
			}

			count++;
		}

		return count;
	}
}
