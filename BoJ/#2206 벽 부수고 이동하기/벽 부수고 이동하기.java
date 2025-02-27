import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dx = { 0, 0, -1, 1 }; // 상, 하, 좌, 우
	static int[] dy = { -1, 1, 0, 0 }; // 상, 하, 좌, 우

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int[][] arr = new int[n][m];
		boolean[][][] visited = new boolean[n][m][2];

		for (int i = 0; i < arr.length; i++) {
			input = br.readLine().split("");
			for (int j = 0; j < arr[0].length; j++)
				arr[i][j] = Integer.parseInt(input[j]);
		}
		System.out.println(bfs(arr, visited));
	}

	private static int bfs(int[][] arr, boolean[][][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0, 0 });
		int count = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int[] temp = queue.poll();
				int x = temp[0];
				int y = temp[1];
				int crash = temp[2];

				if (x == arr.length - 1 && y == arr[0].length - 1)
					return count;

				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx < 0 || nx >= arr.length || ny < 0 || ny >= arr[0].length) {
						continue;
					}

					if (!visited[nx][ny][crash]) {
						visited[nx][ny][crash] = true;
						if (arr[nx][ny] == 0)
							queue.add(new int[] { nx, ny, crash });
						if (arr[nx][ny] == 1 && crash == 0)
							queue.add(new int[] { nx, ny, 1 });
					}
				}
			}
			count++;
		}

		return -1;
	}
}