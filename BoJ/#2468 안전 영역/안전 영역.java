import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] input;

		int answer = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;

		int[][] arr = new int[n][n];
		boolean[][] visited;

		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
				max = Math.max(max, arr[i][j]);
			}
		}

		for (int rain = 0; rain < max; rain++) {
			int count = 0;
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j] && arr[i][j] > rain) {
						visited[i][j] = true;
						bfs(arr, visited, i, j, rain);
						count++;
					}
				}
			}
			answer = Math.max(answer, count);
		}

		System.out.println(answer);
	}

	private static void bfs(int[][] arr, boolean[][] visited, int x, int y, int rain) {
		Queue<int[]> queue = new LinkedList<int[]>();

		queue.add(new int[] { x, y });

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int a = temp[0];
			int b = temp[1];

			for (int i = 0; i < 4; i++) {
				int nX = a + dx[i];
				int nY = b + dy[i];

				if (nX >= 0 && nY >= 0 && nX < arr.length && nY < arr[0].length && !visited[nX][nY]
						&& arr[nX][nY] > rain) {
					queue.add(new int[] { nX, nY });
					visited[nX][nY] = true;
				}
			}
		}
	}
}